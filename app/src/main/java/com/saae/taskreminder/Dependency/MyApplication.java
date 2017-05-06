package com.saae.taskreminder.Dependency;

import android.app.Application;

/**
 * Created by Saae on 1/9/2017.
 */

public class MyApplication extends Application {


    public NetComponent mnetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mnetComponent = DaggerNetComponent.builder().
                appModule(new AppModule(this)).netModule(new NetModule()).build();


    }

    public NetComponent getNetComponent() {
        return mnetComponent;
    }
}
