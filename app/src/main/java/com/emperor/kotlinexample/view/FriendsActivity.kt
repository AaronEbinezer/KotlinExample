package com.emperor.kotlinexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.emperor.kotlinexample.R
import com.emperor.kotlinexample.api.Retroclient
import com.emperor.kotlinexample.databinding.ActivityFriendsBinding
import com.emperor.kotlinexample.model.FriendListModel
import com.emperor.kotlinexample.utils.Status
import com.emperor.kotlinexample.view.viewholder.RvFriendsList
import com.emperor.kotlinexample.viewmodel.friendlist.FriendListViewModel
import com.emperor.kotlinexample.viewmodel.friendlist.factorymodel.FriendsFactoryModel

private const val TAG = "FriendsActivity"
class FriendsActivity : AppCompatActivity() {
    lateinit var friendListViewModel: FriendListViewModel
    var activityFriendsBinding: ActivityFriendsBinding? = null
    lateinit var rvFriendListAdapter: RvFriendsList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityFriendsBinding = ActivityFriendsBinding.inflate(layoutInflater)
        setContentView(activityFriendsBinding!!.root)

        setupViewModel()
//        setupOnLineObserver()
        setupLocalObserver()
        friendListAdapter()
    }

    private fun setupViewModel()
    {
        friendListViewModel = ViewModelProviders.of(this,
                FriendsFactoryModel(this, Retroclient.apiService)
        ).get(FriendListViewModel::class.java)
    }

    private fun setupLocalObserver()
    {
        friendListViewModel.getFriendLocalList().observe(this, {
            it.let { res ->
                when (res.status) {
                    Status.SUCCESS -> {
                        res.data?.let {
                            friends ->
                            activityFriendsBinding?.progress?.visibility = View.GONE
                            setFriendList(friends as List<FriendListModel>)}
                    }
                    Status.ERROR -> {
                        Log.d(TAG, "setupObserver: Error ${res.message}")
                    }
                    Status.LOADING -> {
                        activityFriendsBinding?.progress?.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

    private fun setupOnLineObserver()
    {
        friendListViewModel.getFriendList().observe(this, Observer {
            it.let { res ->
                when (res.status) {
                    Status.SUCCESS -> {
                        res.data?.let {
                            friends ->
                            activityFriendsBinding?.progress?.visibility = View.GONE
                            setFriendList(friends as List<FriendListModel>)}
                    }
                    Status.ERROR -> {
                        Log.d(TAG, "setupObserver: Error ${res.message}")
                    }
                    Status.LOADING -> {
                        activityFriendsBinding?.progress?.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

    private fun setFriendList(list:List<FriendListModel>)
    {
        Log.d(TAG, "setupObserver: Success ${list}")
        rvFriendListAdapter?.addData(list)
        rvFriendListAdapter?.notifyDataSetChanged()

    }

    private fun friendListAdapter()
    {
        rvFriendListAdapter = RvFriendsList(arrayListOf())
        activityFriendsBinding?.rvFriendsList?.layoutManager = LinearLayoutManager(this)
        activityFriendsBinding?.rvFriendsList?.adapter = rvFriendListAdapter
    }
}