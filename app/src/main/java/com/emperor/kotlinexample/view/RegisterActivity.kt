package com.emperor.kotlinexample.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emperor.kotlinexample.R
import com.emperor.kotlinexample.databinding.ActivityRegisterBinding
import com.emperor.kotlinexample.model.UserModel
import com.emperor.kotlinexample.utils.HelperMethods
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.view.*

class RegisterActivity : AppCompatActivity() {
    lateinit var activityRegisterBinding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityRegisterBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(activityRegisterBinding.root)
        bt_reg.setOnClickListener {
            validateRegForm()
        }

    }

    private fun validateRegForm()
    {
        val name = et_name_reg.text.toString()
        val pass = et_password_reg.text.toString()
        if(HelperMethods.checkEmptyString(name, et_name_reg, "Name"))
        {
            HelperMethods.showToast(applicationContext, "Enter Name")
        }
        else if(HelperMethods.checkEmptyString(pass, et_password_reg, "Password"))
        {
            HelperMethods.showToast(applicationContext, "Enter Password")
        }
        else {
            val user = UserModel(name)
            user.password = pass
            user.save()
            startActivity(Intent(applicationContext, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
        }
    }


}