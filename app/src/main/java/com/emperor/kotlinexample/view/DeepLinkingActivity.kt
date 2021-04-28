package com.emperor.kotlinexample.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.emperor.kotlinexample.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private const val TAG = "DeepLinkingActivity"
class DeepLinkingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deep_linking)
        val intentData = intent.data
        val intentString = intentData.toString()
        Log.d(TAG, "onCreate: $intentData")

        if(intentString.contains("token")) {
//            val lastPath = intentData?.lastPathSegment
            val tokenIndex = intentString.lastIndexOf("token")
            val token = intentString.substring(tokenIndex).removePrefix("token=")
            Log.d(TAG, "onCreate: token $token")
        }

//        GlobalScope.launch {
//
//        }


    }


}

