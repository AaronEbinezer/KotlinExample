package com.emperor.kotlinexample.view.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emperor.kotlinexample.databinding.FriendsAdapterBinding
import com.emperor.kotlinexample.model.FriendListModel

class RvFriendsList(val friendsList:ArrayList<FriendListModel>): RecyclerView.Adapter<RvFriendsList.RvFriendsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvFriendsHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = FriendsAdapterBinding.inflate(layoutInflater)
        return RvFriendsHolder(binding)
    }

    override fun onBindViewHolder(holder: RvFriendsHolder, position: Int) {
        val currentUser = friendsList[position]
        holder.friendItemView.user = currentUser
        holder.friendItemView.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return friendsList.size
    }

    fun addData(list: List<FriendListModel>) {
        friendsList.addAll(list)
    }


    class RvFriendsHolder(val friendItemView: FriendsAdapterBinding) : RecyclerView.ViewHolder(friendItemView.root)
}