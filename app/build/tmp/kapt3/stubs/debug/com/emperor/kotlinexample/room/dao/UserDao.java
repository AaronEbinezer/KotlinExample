package com.emperor.kotlinexample.room.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\nH\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/emperor/kotlinexample/room/dao/UserDao;", "", "InsertUser", "", "userModel", "Lcom/emperor/kotlinexample/model/UserModel;", "(Lcom/emperor/kotlinexample/model/UserModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserList", "Landroidx/lifecycle/LiveData;", "userName", "", "app_debug"})
public abstract interface UserDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object InsertUser(@org.jetbrains.annotations.NotNull()
    com.emperor.kotlinexample.model.UserModel userModel, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "Select * from User where name = :userName order by id desc")
    public abstract androidx.lifecycle.LiveData<com.emperor.kotlinexample.model.UserModel> getUserList(@org.jetbrains.annotations.NotNull()
    java.lang.String userName);
}