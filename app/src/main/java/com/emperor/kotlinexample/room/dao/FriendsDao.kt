package com.emperor.kotlinexample.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.emperor.kotlinexample.model.FriendListModel

@Dao
interface FriendsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertFriends(friendListModel: List<FriendListModel>?)

    @Query("Select * from FriendList")
    suspend fun getFriends():List<FriendListModel>
}