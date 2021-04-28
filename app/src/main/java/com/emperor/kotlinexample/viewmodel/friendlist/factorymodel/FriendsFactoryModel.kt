package com.emperor.kotlinexample.viewmodel.friendlist.factorymodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emperor.kotlinexample.api.ApiService
import com.emperor.kotlinexample.repository.FriendListRepo
import com.emperor.kotlinexample.viewmodel.friendlist.FriendListViewModel

class FriendsFactoryModel(private val context: Context, private val apiService: ApiService): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FriendListViewModel::class.java)) {
            return FriendListViewModel(FriendListRepo(context, apiService)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}