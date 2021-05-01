package com.emperor.kotlinexample.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.*
import com.emperor.kotlinexample.R
import com.emperor.kotlinexample.api.ApiService
import com.emperor.kotlinexample.api.Retroclient
import com.emperor.kotlinexample.model.FriendListModel
import com.emperor.kotlinexample.model.UserModel
import com.emperor.kotlinexample.utils.Status
import com.emperor.kotlinexample.viewmodel.friendlist.FriendListViewModel
import com.emperor.kotlinexample.viewmodel.friendlist.factorymodel.FriendsFactoryModel
import com.emperor.kotlinexample.viewmodel.user.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.lang.Exception
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
//                txtUsername.error= "Enter name"
//                return@setOnClickListener
                startActivity(Intent(this, FriendsActivity::class.java))
            }

            userViewModel.getNormalData(this, name)!!.observe(this, Observer {
                if (it == null) {
                    lblReadResponse.text = "Data Not Found"
                    lblUseraname.text = "- - -"
                    lblPassword.text = "- - -"
                } else {
//                    Log.d(TAG, "onCreate: ${it.name}")
//                    lblUseraname.text = it.name
//                    lblPassword.text = it.age.toString()
                    when (it.status) {
                        Status.SUCCESS -> {
                            try {
                                val data = it.data as LiveData<UserModel>
                                lblUseraname.text = data?.value?.name
                                lblPassword.text = data?.value?.age.toString()
                            } catch (e: Exception) {
                                Log.d(TAG, "onCreate: $e")
                            }
                        }
                        Status.ERROR -> {
                            Log.d(TAG, "onCreate: error")
                        }
                        Status.LOADING -> {
                            Log.d(TAG, "onCreate: loading")
                        }
                    }


                    lblReadResponse.text = "Data Found Successfully"
                }
            })

        }
//        coroutineMethod()

        
        inlineFunction({normalFun(1)}, { normalFun(2)}) // second function is not calling
        higherFun("Hello", ::print)
        coroutines()
    }

    private fun higherFun(str:String, myCustFun:(String) -> Unit)
    {
        myCustFun(str)
    }

    public inline fun printStr(str: Any?): Unit
    {

    }

    private fun normalFun(int: Int)
    {
        Log.d(TAG, "normalFun: $int")
    }

    private inline fun inlineFunction(myFun: () -> Unit, mySecFun: () -> Unit)
    {
        myFun()
        
    }

    private fun coroutines() {

//        launch {
//            delay(8000L)
//            Log.d(TAG, "coroutines:launch ")
//        }
//        coroutineScope {
//            delay(10000L)
//            Log.d(TAG, "coroutinesScope: ")
//        }

        CoroutineScope(Dispatchers.IO).launch {
            suspendCoroutine()
        }

//        GlobalScope.launch {
//            delay(10000L)
//            Log.d(TAG, "coroutinesScope: GlobalScope")
//
//            coroutineScope {
//                delay(10000L)
//                Log.d(TAG, "coroutinesScope: Nested")
////                lblUseraname.text = "it.name"
//            }
//        }

        Log.d(TAG, "coroutines: ")
    }

    private suspend fun suspendCoroutine()
    {
        lblUseraname.text = "it.name"
    }

    private fun coroutineMethod()
    {
            GlobalScope.launch {  // launch new coroutine in background and continue
                delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
                Log.d(TAG, "coroutineMethod: World!") // print after delay
                val sum1 = async { // non blocking sum1
                    delay(100L)
                    2 + 2
                }
                val sum2 = async { // non blocking sum2
                    delay(500L)
                    3 + 3
                }
                Log.d(TAG, "coroutineMethod: waiting concurrent sums")
                val total = sum1.await() + sum2.await() // execution stops until both sums are calculated
                Log.d(TAG, "coroutineMethod: Total is: $total")
            }
        Log.d(TAG, "coroutineMethod: Hello,")     // main thread continues while coroutine executes
            Thread.sleep(2000L)   // block main thread for 2 seconds to keep JVM alive
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