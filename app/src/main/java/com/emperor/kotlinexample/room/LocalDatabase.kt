package com.emperor.kotlinexample.room

import android.content.Context
import androidx.room.*
import com.emperor.kotlinexample.model.FriendListModel
import com.emperor.kotlinexample.model.UserModel
import com.emperor.kotlinexample.room.dao.FriendsDao
import com.emperor.kotlinexample.room.dao.UserDao

@Database(entities =[UserModel::class, FriendListModel::class], version = 2, exportSchema = false)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun friendsDao(): FriendsDao

    companion object
    {
        @Volatile
        private var INSTANCE: LocalDatabase? = null

        fun getDatabase(context: Context):LocalDatabase{
            if(INSTANCE != null) return INSTANCE as LocalDatabase

            synchronized(this)
            {
                INSTANCE = Room
                    .databaseBuilder(context, LocalDatabase::class.java, "LOCAL_DATABASE")
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return INSTANCE as LocalDatabase
        }

    }
}