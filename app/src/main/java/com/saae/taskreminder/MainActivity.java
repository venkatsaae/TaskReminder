package com.saae.taskreminder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.saae.taskreminder.Dependency.MyApplication;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    @Inject
    Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApplication) getApplication()).getNetComponent().inject(this);

//        Retrofit retrofit = new Retrofit.Builder()
//                ///users/ahmedrizwan
//                .baseUrl("https://api.github.com")
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();


        ApiService apiService = retrofit.create(ApiService.class);

        Observable<RootObject> rootObjectObservable = apiService.getUser("ahmedrizwan");


        rootObjectObservable.
                subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RootObject>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull RootObject rootObject) {
                        rootObject.getCompany();
                        Log.d("Success",rootObject.getCompany());


                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                        Log.d("Success","Success");


                    }
                });


        getAnother();


       // tvclick = (TextView) findViewById(R.id.tvclick);


     //   tvclick.setOnClickListener(view -> call());


    }

    private void getAnother() {

//        Retrofit retrofit = new Retrofit.Builder()
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl("http://api.openweathermap.org/data/2.5/")
//                .build();
//
//        WeatherService weatherService = retrofit.create(WeatherService.class);
//        Observable<WeatherData> london = weatherService.getWeatherData("Islamabad");
//
//        london.subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(weatherData -> {
//                    Log.e("Current Weather", weatherData.getWeather()
//                            .get(0)
//                            .getDescription());
//                });
    }

    private void getData(RootObject weatherData) {

        Toast.makeText(this, weatherData.getId() + "", Toast.LENGTH_SHORT).show();

    }

    private void call() {

        Toast.makeText(this, "called", Toast.LENGTH_SHORT).show();
    }
}
