package com.emperor.kotlinexample.viewmodel.user

import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.emperor.kotlinexample.model.UserModel
import com.emperor.kotlinexample.repository.UserRepo
import com.emperor.kotlinexample.utils.Resource
import kotlinx.coroutines.*
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

private const val TAG = "UserViewModel"
class UserViewModel: ViewModel(), CoroutineScope {
    private val job = Job()// Should cancel this on Destroy
    public fun insertData(context: Context, userModel: UserModel)
    {
        UserRepo.insertUser(context, userModel)
    }

    private val userMutableLiveData = MutableLiveData<LiveData<UserModel>>()

    public fun getUserLiveData(context: Context, name: String): LiveData<UserModel>? {
        return UserRepo.getUser(context, name)// with live data
    }

    public fun getNormalData(context: Context, name: String) = liveData(Dispatchers.IO) {// background coroutine
        emit(Resource.loading(data = "Please wait"))
        try{
            val liveData = MutableLiveData<UserModel>()
            val data = UserRepo.getUserData(context,name)
            Log.d(TAG, "getNormalData: $data")
            liveData.postValue(data)
//            emit(Resource.success(data = UserRepo.getUserData(context,name)))
            emit(Resource.success(data = liveData))
        }catch (e:Exception)
        {
            emit(e.message?.let { Resource.error(data = null, message = it) })
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}