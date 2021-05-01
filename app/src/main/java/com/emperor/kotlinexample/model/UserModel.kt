package com.emperor.kotlinexample.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.emperor.kotlinexample.utils.PreferenceManager

@Entity(tableName = "User")
data class UserModel(
    @ColumnInfo(name ="name")
    var name:String,
    @ColumnInfo(name = "age")
    var age:Int = 0
    )
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int? = null
    @ColumnInfo(name = "password")
    var password:String? = null
    fun save()
    {
        PreferenceManager.instance.user = this
    }
}