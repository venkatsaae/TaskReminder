package com.saae.taskreminder.Dependency;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Saae on 1/9/2017.
 */
@Module
public class NetModule {

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }


    Retrofit retrofit = new Retrofit.Builder()
            ///users/ahmedrizwan
            .baseUrl("https://api.github.com")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Provides
    @Singleton
    public Retrofit getRetrofit() {
        return retrofit;
    }
}
