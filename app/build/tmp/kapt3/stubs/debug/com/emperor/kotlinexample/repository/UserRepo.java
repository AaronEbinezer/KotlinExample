package com.emperor.kotlinexample.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/emperor/kotlinexample/repository/UserRepo;", "", "()V", "Companion", "app_debug"})
public final class UserRepo {
    @org.jetbrains.annotations.Nullable()
    private static com.emperor.kotlinexample.room.LocalDatabase userDatabase;
    @org.jetbrains.annotations.Nullable()
    private static androidx.lifecycle.LiveData<com.emperor.kotlinexample.model.UserModel> userDetails;
    @org.jetbrains.annotations.NotNull()
    public static final com.emperor.kotlinexample.repository.UserRepo.Companion Companion = null;
    
    public UserRepo() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u000bJ\u0019\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/emperor/kotlinexample/repository/UserRepo$Companion;", "", "()V", "userDatabase", "Lcom/emperor/kotlinexample/room/LocalDatabase;", "getUserDatabase", "()Lcom/emperor/kotlinexample/room/LocalDatabase;", "setUserDatabase", "(Lcom/emperor/kotlinexample/room/LocalDatabase;)V", "userDetails", "Landroidx/lifecycle/LiveData;", "Lcom/emperor/kotlinexample/model/UserModel;", "getUserDetails", "()Landroidx/lifecycle/LiveData;", "setUserDetails", "(Landroidx/lifecycle/LiveData;)V", "getUser", "context", "Landroid/content/Context;", "name", "", "initializeDb", "insertUser", "", "userModel", "insertUserScope", "(Lcom/emperor/kotlinexample/model/UserModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.Nullable()
        public final com.emperor.kotlinexample.room.LocalDatabase getUserDatabase() {
            return null;
        }
        
        public final void setUserDatabase(@org.jetbrains.annotations.Nullable()
        com.emperor.kotlinexample.room.LocalDatabase p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final androidx.lifecycle.LiveData<com.emperor.kotlinexample.model.UserModel> getUserDetails() {
            return null;
        }
        
        public final void setUserDetails(@org.jetbrains.annotations.Nullable()
        androidx.lifecycle.LiveData<com.emperor.kotlinexample.model.UserModel> p0) {
        }
        
        private final com.emperor.kotlinexample.room.LocalDatabase initializeDb(android.content.Context context) {
            return null;
        }
        
        public final void insertUser(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        com.emperor.kotlinexample.model.UserModel userModel) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final androidx.lifecycle.LiveData<com.emperor.kotlinexample.model.UserModel> getUser(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String name) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}