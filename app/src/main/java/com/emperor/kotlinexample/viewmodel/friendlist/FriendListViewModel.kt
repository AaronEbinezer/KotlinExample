package com.emperor.kotlinexample.viewmodel.friendlist

import android.util.Log
import androidx.lifecycle.*
import com.emperor.kotlinexample.model.FriendListModel
import com.emperor.kotlinexample.repository.FriendListRepo
import com.emperor.kotlinexample.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class FriendListViewModel(private val friendListRepo: FriendListRepo): ViewModel() {
    fun getFriendList() = liveData(Dispatchers.IO){
            emit(Resource.loading(data = null))
            try {
                val data = friendListRepo.getFriendList()
                emit(Resource.success(data = data))
            } catch (exception: Exception) {
                emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            }
    }

}