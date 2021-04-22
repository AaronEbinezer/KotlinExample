package com.emperor.kotlinexample.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005\u00a8\u0006\r"}, d2 = {"Lcom/emperor/kotlinexample/viewmodel/UserViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "getUserLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/emperor/kotlinexample/model/UserModel;", "context", "Landroid/content/Context;", "name", "", "insertData", "", "userModel", "app_debug"})
public final class UserViewModel extends androidx.lifecycle.ViewModel {
    
    public final void insertData(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.emperor.kotlinexample.model.UserModel userModel) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.LiveData<com.emperor.kotlinexample.model.UserModel> getUserLiveData(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    public UserViewModel() {
        super();
    }
}