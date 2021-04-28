package com.emperor.kotlinexample.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.emperor.kotlinexample.model.UserModel
import com.emperor.kotlinexample.room.LocalDatabase
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

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
//                userDatabase!!.userDao().InsertUser(userModel)
                launch {
                    insertUserScope(userModel)
                }
            }
        }

        private suspend fun insertUserScope(userModel: UserModel)
        {
            userDatabase!!.userDao().InsertUser(userModel)
        }

        public fun getUser(context: Context, name: String): LiveData<UserModel>? = runBlocking{
            userDatabase = initializeDb(context)

            coroutineScope {
                //Since coroutineScope is used all the launch block will be executed and then only bottom block will be executed
//                delay(10000L) // Freezes the UI for 10 sec
                launch {
                    userDetails = userDatabase!!.userDao().getUserList(name) as LiveData<UserModel>
                }

            }
            userDetails

//            val job = GlobalScope.launch {
//                delay(10000L) // Freezes the UI for 10 sec
//                userDetails = userDatabase!!.userDao().getUserList(name) as LiveData<UserModel>
//            }
//            job.join()
//            userDetails
        }

    }
}