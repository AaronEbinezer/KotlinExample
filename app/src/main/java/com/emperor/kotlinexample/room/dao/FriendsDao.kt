package com.emperor.kotlinexample.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.emperor.kotlinexample.model.FriendListModel

@Dao
interface FriendsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun InsertFriends(friendListModel: List<FriendListModel>)
}