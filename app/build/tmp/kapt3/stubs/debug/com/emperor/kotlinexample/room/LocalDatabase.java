package com.emperor.kotlinexample.room;

import java.lang.System;

@androidx.room.Database(entities = {com.emperor.kotlinexample.model.UserModel.class, com.emperor.kotlinexample.model.FriendListModel.class}, version = 2, exportSchema = false)
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/emperor/kotlinexample/room/LocalDatabase;", "Landroidx/room/RoomDatabase;", "()V", "friendsDao", "Lcom/emperor/kotlinexample/room/dao/FriendsDao;", "userDao", "Lcom/emperor/kotlinexample/room/dao/UserDao;", "Companion", "app_debug"})
public abstract class LocalDatabase extends androidx.room.RoomDatabase {
    private static volatile com.emperor.kotlinexample.room.LocalDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.emperor.kotlinexample.room.LocalDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.emperor.kotlinexample.room.dao.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.emperor.kotlinexample.room.dao.FriendsDao friendsDao();
    
    public LocalDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/emperor/kotlinexample/room/LocalDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/emperor/kotlinexample/room/LocalDatabase;", "getDatabase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.emperor.kotlinexample.room.LocalDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}