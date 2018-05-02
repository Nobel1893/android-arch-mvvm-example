package com.nobel.baseapp.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/24/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class ApiManager {

 //   private final static String BASEURL="http://www.atozqatar.com/mazad-app/APIs/";
    private final static String BASEURL="http://new.etathaker.com/api/";

    private static Retrofit retrofitinstance;

    public static Retrofit getInstance(){

        if (retrofitinstance==null)
            retrofitinstance=new Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        return retrofitinstance;

    }

   public static  APICalls getApiService(){
       return getInstance().create(APICalls.class);
    }

}

