package com.nobel.baseapp.Base;

import android.app.Application;

import com.nobel.baseapp.NobelProviders.PrefrencesProvider;


/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 5/2/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class NobelApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PrefrencesProvider.init(this);
    }
}
