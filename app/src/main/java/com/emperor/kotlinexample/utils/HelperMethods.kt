package com.emperor.kotlinexample.utils

import android.content.Context
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson
import java.lang.reflect.Type

class HelperMethods private constructor() {

    companion object{

        fun toJson(`object`: Any?): String {
            val gson = Gson()
            return gson.toJson(`object`)
        }

            /* create model class from string response
         *  @param json string response
         *  @param type Type Token of model class
         *  return generic class
         */
            fun <T> fromJson(json: String?, type: Type?): T? {
                val gson = Gson()
                return if (json != null && !json.isEmpty()) {
                    gson.fromJson(json, type)
                } else null
            }

            fun showToast(context: Context, msg: String)
            {
                Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
            }

            fun checkEmptyString(string: String, edtText: EditText, name:String): Boolean
            {
                if(string.isEmpty()) {
                    edtText.error = "Enter $name"
                    return true
                }
                else {
                    return false
                }
            }
    }
}