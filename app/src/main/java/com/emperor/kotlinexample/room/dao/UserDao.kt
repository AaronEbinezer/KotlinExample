package com.emperor.kotlinexample.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.emperor.kotlinexample.model.FriendListModel
import com.emperor.kotlinexample.model.UserModel

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertUser(userModel: UserModel)

    @Query("Select * from User where name = :userName order by id desc")
    fun getUserList(userName:String): LiveData<UserModel>

}