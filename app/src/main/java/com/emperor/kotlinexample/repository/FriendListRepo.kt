package com.emperor.kotlinexample.repository

import android.content.Context
import android.util.Log
import com.emperor.kotlinexample.api.ApiService
import com.emperor.kotlinexample.model.FriendListModel
import com.emperor.kotlinexample.room.LocalDatabase
import io.reactivex.Single
import kotlinx.coroutines.*

class FriendListRepo(private val context: Context, private val apiService: ApiService){

    var userDatabase: LocalDatabase? = null
    suspend fun getFriendList(): List<FriendListModel>?{
        var friendList: List<FriendListModel>? = null
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

        return apiService.getUsers()

//        return friendList
    }
    private fun initializeDb(context: Context): LocalDatabase
    {
        return LocalDatabase.getDatabase(context)
    }
    public fun insertFriends(friendListModel: List<FriendListModel>)
    {
        userDatabase = initializeDb(context)
        CoroutineScope(Dispatchers.IO).launch {
//                userDatabase!!.userDao().InsertUser(userModel)
            launch {
                insertUserScope(friendListModel)
            }
        }
    }

    private fun insertUserScope(friendListModel: List<FriendListModel>)
    {
        userDatabase!!.friendsDao().InsertFriends(friendListModel)
    }

}