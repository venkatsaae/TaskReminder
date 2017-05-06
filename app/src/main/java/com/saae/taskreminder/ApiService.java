package com.saae.taskreminder;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Srinath on 22/04/17.
 */

public interface ApiService {


    @GET("users/{username}")
    Observable<RootObject> getUser(@Path("username") String username);
}
