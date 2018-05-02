package com.nobel.baseapp.NobelProviders;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 5/2/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class DataProvider {
    private static  DataProvider ourInstance ;
    private Map<String,Object> myData;

    public static DataProvider getInstance() {
        if (ourInstance==null)ourInstance=new DataProvider();
        return ourInstance;
    }

    private DataProvider() {
        myData=new HashMap<>();
    }

    public void put(String Key,Object o){
        myData.put(Key,o);
    }

    public Object get(String Key){
        return myData.get(Key);
    }
}
