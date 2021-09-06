package com.cykj.guitdemo;

import android.app.Application;

/**
 * @author : admin
 * date : 2021/8/17 18:47
 * description :
 */
public class MyApp extends Application {
    private static MyApp instance;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static MyApp getInstance() {
        return instance;
    }
}
