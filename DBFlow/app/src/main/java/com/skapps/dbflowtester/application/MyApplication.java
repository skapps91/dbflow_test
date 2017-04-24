package com.skapps.dbflowtester.application;


import android.app.Application;
import android.os.StrictMode;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        // This instantiates DBFlow
        FlowManager.init(new FlowConfig.Builder(this).build());
        // add for verbose logging
        // FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

    }


}
