package com.example.accumulation;

import android.app.Application;

/**
 * create by tanhs on 2020/5/25 20:01
 */
public class App extends Application {

    public static App INSTANCE;

    public static App getInstance(){
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }
}
