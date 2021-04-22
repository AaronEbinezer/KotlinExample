package com.emperor.kotlinexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emperor.kotlinexample.R
import com.emperor.kotlinexample.model.UserModel
import com.emperor.kotlinexample.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.contracts.contract

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        btnAddLogin.setOnClickListener{
            val name = txtUsername.text.toString().trim()
            val age = txtAge.text.toString().trim()
            if(name.isEmpty())
            {
                txtUsername.error= "Enter name"
            }
            else if(age.isEmpty())
            {
                txtAge.error= "Enter name"
            }
            else
            {
                val userModel = UserModel(name, age.toInt())
                userViewModel.insertData(this, userModel)
                lblInsertResponse.text = "Inserted Successfully"
            }
        }

        btnReadLogin.setOnClickListener {
            val name = txtUsername.text.toString().trim()
            if(name.isEmpty())
            {
                txtUsername.error= "Enter name"
                return@setOnClickListener
            }


            userViewModel.getUserLiveData(this, name)!!.observe(this, Observer {
                if (it == null) {
                    lblReadResponse.text = "Data Not Found"
                    lblUseraname.text = "- - -"
                    lblPassword.text = "- - -"
                }
                else {
                    lblUseraname.text = it.name
                    lblPassword.text = it.age.toString()

                    lblReadResponse.text = "Data Found Successfully"
                }
            })


        }


    }

    private fun scopeFunctions()
    {
        val list = arrayOf(1, 2, 3)
        list.let {
            Log.d(TAG, "onCreate: ${it[0]}")
        }
        list.also {
            Log.d(TAG, "onCreate also: ${it}")
        }
        val str = "Jesus"
        val strUpperCase = str.let { it.toUpperCase() }
        Log.d(TAG, "onCreate: str $str")
        Log.d(TAG, "onCreate: uppercase $strUpperCase")
        var a = 1
        var b = 2
        a = a.let { it + 2 }.let {
            val i = it + b
            i
        }

        var x = "Anupam"
        x.let { oute -> oute.let { inner -> print("Inner is $inner and outer is $oute") } }

        var tutorial = "This is Kotlin Tutorial"
        println(tutorial) //This is Kotlin Tutorial
        tutorial = run {  //tutorial.run { this can also be used
            val tutorial = "This is run function"
            tutorial
        }
        Log.d(TAG, "tutorial: $tutorial")

        var m = 1
        m = m.also { it + 1
            it
        }.also { it + 1
            it
        }

        Log.d(TAG, "onCreate: also $m") // value is 1
        data class Person(var name: String, var tutorial : String)
        var person = Person("Anupam", "Kotlin")
        Log.d(TAG, "onCreate: person $person")
        var al = person.also {
            it.tutorial = "Android"

        }
        Log.d(TAG, "onCreate: also person $person")
        Log.d(TAG, "onCreate: also $al")

        var l = person.let {
            it.tutorial = "And"
            it
        }// returns the object if last line is not given
        // returns the value

        Log.d(TAG, "onCreate: let person $person")
        Log.d(TAG, "onCreate: let $l")

        with(person)
        {
            name = "Anupa"
        }
        Log.d(TAG, "onCreate: with person1 $person")
        val secPerson = with(person)
        {
            name = "Anupama"
            person
        }
        Log.d(TAG, "onCreate: with person2 $person")
        Log.d(TAG, "onCreate: with $secPerson")
//        Log.d(TAG, "onCreate: 3$person")
//        val personDube = person.apply {
//            this.tutorial = "Swi"
//            val xyz = "XYZ"
//            xyz
//
//        }
//        Log.d(TAG, "onCreate: 4 $person")
//        Log.d(TAG, "onCreate: 4 $personDube")
//
//        person.also { it.tutorial = "Kotlin" }
//        Log.d(TAG, "also: $person")
//
//
//        var xyz = with(person)
//        {
//            person.apply {
//                tutorial = "Kot"
//                val xyz = "End of tutorial"
//            }
//            val p = {
//                name = "No Name"
//                tutorial = "Kotlin tutorials"
//
//            }
//            person
//        }
//
//        Log.d(TAG, "onCreate: 5 $person")
//        Log.d(TAG, "onCreate: 6 $xyz")
//
//        val numbers = mutableListOf("one", "two", "three")
//        val countEndsWithE = numbers.run {
//            add("four")
//            add("five")
//            count { it.endsWith("e") }
//        }
//
//        Log.d(TAG, "There are $countEndsWithE elements that end with e.")
//
//        val numberss = mutableListOf("one", "two", "three", "four", "five")
//        numberss.map { it.length }.filter { it > 3 }.let {
//            Log.d(TAG, "numberss: $it")
//        }
    }
}