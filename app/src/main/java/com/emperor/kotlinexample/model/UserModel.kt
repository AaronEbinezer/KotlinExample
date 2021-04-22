package com.emperor.kotlinexample.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class UserModel(
    @ColumnInfo(name ="name")
    var name:String,
    @ColumnInfo(name = "age")
    var age:Int) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int? = null
}