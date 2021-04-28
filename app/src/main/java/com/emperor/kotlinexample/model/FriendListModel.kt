package com.emperor.kotlinexample.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.emperor.kotlinexample.R
import com.google.gson.annotations.SerializedName

@Entity(tableName = "FriendList")
data class FriendListModel(
        @ColumnInfo(name ="image")
        @SerializedName("avatar")
        val avatar: String,
        @ColumnInfo(name ="email")
        @SerializedName("email")
        val email: String,
        @PrimaryKey
        @ColumnInfo(name ="id")
        @SerializedName("id")
        val id: String,
        @ColumnInfo(name ="name")
        @SerializedName("name")
        val name: String)
{
        companion object {
                @JvmStatic @BindingAdapter("setImageUrl")
                fun bindImageUrl(imageView: ImageView, url: String?) {
                        if (url != null && url.isNotBlank()) {
                                Glide.with(imageView.context).load("http://goo.gl/gEgYUd").error(R.drawable.ic_launcher_foreground).into(imageView);
                        }
                }
        }
}