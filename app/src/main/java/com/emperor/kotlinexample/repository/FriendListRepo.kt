package com.emperor.kotlinexample.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.load.engine.Resource
import com.emperor.kotlinexample.api.ApiService
import com.emperor.kotlinexample.model.FriendListModel
import com.emperor.kotlinexample.room.LocalDatabase
import io.reactivex.Single
import kotlinx.coroutines.*

class FriendListRepo(private val context: Context, private val apiService: ApiService){

    var userDatabase: LocalDatabase? = null
    var friendsData = MutableLiveData<Resource<List<FriendListModel>>>()

    suspend fun getFriendData(): List<FriendListModel> {
        userDatabase = initializeDb(context)
        return userDatabase!!.friendsDao().getFriends()
    }
    suspend fun getFriendList(): List<FriendListModel>?{
        var friendList: List<FriendListModel>? = apiService.getUsers()
//        coroutineScope {
//
//
//           apiService.getUsers()
//                   .flatMap {
//                       res->
//                       insertFriends(res)
//                       friendList = res
//                       Single.just(res)
//                   }
//        }

        insertFriends(friendList)

        return apiService.getUsers()

//        return friendList
    }
    private fun initializeDb(context: Context): LocalDatabase
    {
        return LocalDatabase.getDatabase(context)
    }
    private suspend fun insertFriends(friendListModel: List<FriendListModel>?)
    {
        userDatabase = initializeDb(context)
        insertUserScope(friendListModel)
//        CoroutineScope(Dispatchers.IO).launch {
////                userDatabase!!.userDao().InsertUser(userModel)
//            launch {
//                insertUserScope(friendListModel)
//            }
//        }
    }

    private suspend fun insertUserScope(friendListModel: List<FriendListModel>?)
    {
        userDatabase!!.friendsDao().InsertFriends(friendListModel)
    }

    public fun getFriendsData(): LiveData<Resource<List<FriendListModel>>> {
        return friendsData
    }

}