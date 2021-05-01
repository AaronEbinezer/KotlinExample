package com.emperor.kotlinexample.utils

import android.app.Application

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        PreferenceManager.instance.init(this)
    }
}