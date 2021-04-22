package com.emperor.kotlinexample.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.emperor.kotlinexample.model.UserModel
import com.emperor.kotlinexample.repository.UserRepo

class UserViewModel: ViewModel() {

    public fun insertData(context: Context, userModel: UserModel)
    {
        UserRepo.insertUser(context, userModel)
    }

    public fun getUserLiveData(context: Context, name: String): LiveData<UserModel>? {
        return UserRepo.getUser(context, name)
    }
}