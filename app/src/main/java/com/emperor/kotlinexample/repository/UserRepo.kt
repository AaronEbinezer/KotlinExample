package com.emperor.kotlinexample.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.emperor.kotlinexample.model.UserModel
import com.emperor.kotlinexample.room.LocalDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class UserRepo {

    companion object{

        var userDatabase: LocalDatabase? = null
        var userDetails: LiveData<UserModel>? = null

        private fun initializeDb(context: Context): LocalDatabase
        {
            return LocalDatabase.getDatabase(context)
        }

        public fun insertUser(context: Context, userModel: UserModel)
        {
            userDatabase = initializeDb(context)

            CoroutineScope(IO).launch {
                userDatabase!!.userDao().InsertUser(userModel)
            }
        }

        public fun getUser(context: Context, name: String): LiveData<UserModel>? {
            userDatabase = initializeDb(context)
//            CoroutineScope(IO).launch {
               userDetails = userDatabase!!.userDao().getUserList(name)
//            }

            return userDetails
        }

    }
}