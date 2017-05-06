package com.saae.taskreminder.Dependency;

import com.saae.taskreminder.MainActivity;

import javax.inject.Singleton;

/**
 * Created by Saae on 1/11/2017.
 */


@Singleton
@dagger.Component(modules = {AppModule.class,NetModule.class})
public interface NetComponent {

    void inject(MainActivity mainActivity);
//    void inject(RegistrationActivity registrationActivity);
//    void inject(AddProverbActivity addProverbActivity);
//    void inject(FullListFragment fullListFragment);
//    void inject(FavouriteListFragment favouriteListFragment);
//    void inject(SignInFragment signInFragment);
//    void inject(RegistrationFragment registrationFragment);
//    void inject(SplashScreenActivity splashScreenActivity);
//    void inject(MyFirebaseInstanceIDService myFirebaseInstanceIDService);
//    void inject(MyFirebaseMessagingService myFirebaseMessagingService);

}