package com.emperor.kotlinexample.viewmodel.user

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.emperor.kotlinexample.model.UserModel
import com.emperor.kotlinexample.repository.UserRepo
import com.emperor.kotlinexample.utils.Resource
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class UserViewModel: ViewModel(), CoroutineScope {
    private val job = Job()
    public fun insertData(context: Context, userModel: UserModel)
    {
        UserRepo.insertUser(context, userModel)
    }

    public fun getUserLiveData(context: Context, name: String): LiveData<UserModel>?{
        return UserRepo.getUser(context, name)
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}