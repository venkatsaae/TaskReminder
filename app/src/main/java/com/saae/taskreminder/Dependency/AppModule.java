package com.saae.taskreminder.Dependency;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Saae on 1/9/2017.
 */
@Module
public class AppModule {



        MyApplication mApplication;

        public AppModule(MyApplication application) {
            mApplication = application;
        }

        @Provides
        @Singleton
        Application providesApplication() {
            return mApplication;
        }

}
