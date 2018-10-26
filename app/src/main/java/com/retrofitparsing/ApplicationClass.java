package com.retrofitparsing;

import android.app.Application;

/**
 * Created by Debopam Sikder on 8/6/2017.
 */
//updated by sumit
public class ApplicationClass extends Application {
    private static ApplicationClass applicationClass;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationClass = this;
    }

    public static ApplicationClass getInstance() {
        return applicationClass;
    }
}
