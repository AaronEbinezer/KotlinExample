package com.emperor.kotlinexample.api

import com.emperor.kotlinexample.model.FriendListModel
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<FriendListModel>
}