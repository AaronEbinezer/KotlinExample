package com.emperor.kotlinexample.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.liveData
import com.emperor.kotlinexample.databinding.ActivitySplashBinding
import com.emperor.kotlinexample.utils.HelperMethods
import com.emperor.kotlinexample.utils.PreferenceManager
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {
    var activitySplashBinding: ActivitySplashBinding? = null
    val activityScope = CoroutineScope(Dispatchers.Main)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySplashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(activitySplashBinding!!.root)

        var i = 0
        activityScope.launch {
            delay(3000)
            val user = PreferenceManager.instance.user
            if(user == null) {
                  var intent = Intent(applicationContext, RegisterActivity::class.java)
                  startActivity(intent)
                  finish()
            }
            else{
              var intent = Intent(applicationContext, MainActivity::class.java)
              startActivity(intent)
              finish()
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        activityScope.cancel()
    }
}