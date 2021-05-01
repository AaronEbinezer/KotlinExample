package com.emperor.kotlinexample.utils

import android.content.Context
import android.content.SharedPreferences
import com.emperor.kotlinexample.BuildConfig
import com.emperor.kotlinexample.model.UserModel
import com.emperor.kotlinexample.utils.GlobalConstants.Companion.userKey
import com.emperor.kotlinexample.utils.HelperMethods.Companion.fromJson
import com.emperor.kotlinexample.utils.HelperMethods.Companion.toJson
import com.google.gson.reflect.TypeToken

class PreferenceManager  {

    fun init(context: Context) {
        mShare = context.applicationContext.getSharedPreferences(PREF_NAME, 0)
    }

    companion object
    {
        private const val PREF_NAME = BuildConfig.APPLICATION_ID
        val instance = PreferenceManager()
    }

    private var mShare: SharedPreferences? = null
    fun putBoolean(key: String?, value: Boolean) {
        mShare!!.edit()
                .putBoolean(key, value).apply()
    }

    fun putInt(key: String?, value: Int) {
        mShare!!.edit().putInt(key, value)
                .apply()
    }

    fun getBoolean(key: String?): Boolean {
        return mShare!!.getBoolean(
                key,
                false
        )
    }

    fun getInt(key: String?): Int {
        return mShare!!.getInt(key, 0)
    }

    fun getInt(key: String?, defValue: Int): Int {
        return mShare!!.getInt(key, defValue)
    }

    fun putString(key: String?, value: String?) {
        mShare!!.edit()
                .putString(key, value).apply()
    }

    fun getString(key: String?): String? {
        return mShare!!.getString(key, "")
    }

    fun getString(key: String?, defValue: String?): String? {
        return mShare!!.getString(key, defValue)
    }

    @get:Synchronized
    @set:Synchronized
    var user: UserModel?
    get(){
        val data = mShare!!.getString(userKey,"")
        val type =
                object : TypeToken<UserModel?>() {}.type
        return if (data!!.isEmpty()) {
            null
        } else fromJson(data, type)
    }
    set(userModel)
    {
        val data = toJson(userModel)
        mShare!!.edit().putString(userKey,data).apply()
    }

}