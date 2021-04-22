package com.emperor.kotlinexample.room

import android.content.Context
import androidx.room.*
import com.emperor.kotlinexample.model.UserModel
import com.emperor.kotlinexample.room.dao.UserDao

@Database(entities = arrayOf(UserModel::class), version = 1, exportSchema = false)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

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