package com.nobel.baseapp.NobelProviders;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 5/2/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class PrefrencesProvider {
    public static final String LANG="LANG";
    public static final String ENGLISHLANG="en";
    public static final String ARABICLANG="ar";
    public static final String defLang="en";


    private static  PrefrencesProvider ourInstance ;
    private static SharedPreferences sharedPreferences;
    private static final String PrefKey="PAZPreferencesTHST#$%HJSCJ456&^@#$";
    public static PrefrencesProvider init(Context context){
        PrefrencesProvider.sharedPreferences=context.getSharedPreferences(PrefKey,Context.MODE_PRIVATE);
        ourInstance=new PrefrencesProvider();
        return ourInstance;
    }
    public static PrefrencesProvider getInstance() {
        return ourInstance;
    }

    public  void put(String Key,String Value){
        sharedPreferences.edit().putString(Key,Value).apply();
    }
    public String get(String key,String defValue){
        return sharedPreferences.getString(key,defValue);
    }
}
