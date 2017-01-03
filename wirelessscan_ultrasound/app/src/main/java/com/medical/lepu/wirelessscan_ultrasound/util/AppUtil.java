package com.medical.lepu.wirelessscan_ultrasound.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.DisplayMetrics;

import com.squareup.leakcanary.LeakCanary;


/**
 * Created by wong on 11/23/16.
 */

public class AppUtil extends Application {

    private    static     String     APP_CINFIG   =  "utrasound_config.pref" ;

    private static SharedPreferences sp;

    private   static   AppUtil     app ;


    @Override
    public void onCreate() {
        super.onCreate();

        app =   this ;
        sp=this.getSharedPreferences(APP_CINFIG,Context.MODE_PRIVATE);

        LeakCanary.install(this) ;


    }


    public static Context getContext() {

        return app.getApplicationContext();
    }




    public    static   SharedPreferences   getPreferences ()  {


        return      sp ;


    }



    public   static   void   setInt(String key ,  int value)   {

        Editor   editor     =  getPreferences().edit();

        editor.putInt(key, value);

        editor.apply();

    }



    public   static   void    setFloat   (String key, float  value)  {
        Editor   editor     =   getPreferences().edit();

        editor.putFloat(key, value) ;

        editor.apply();


    }


    public   static    void    setLong (String key , long  value)  {
        Editor  editor   =  getPreferences().edit();

        editor.putLong(key, value) ;

        editor.apply();



    }





    public   static    void   setBoolean(String key, boolean  value) {

        Editor   editor  =   getPreferences().edit();

        editor.putBoolean(key, value);


        editor.apply();

    }


    public   static    void   setString (String key, String value){
        Editor  editor     =   getPreferences().edit() ;

        editor.putString(key, value);

        editor.apply();
    }



    public   static   int     getInt  (String key, int defvalue)  {

        return   getPreferences().getInt(key, defvalue) ;


    }


    public   static  float    getFloat  (String key, float defvalue)  {

        return    getPreferences().getFloat(key, defvalue) ;


    }


    public   static    long    getLong (String key,  long defvalue) {

        return   getPreferences().getLong(key, defvalue) ;
    }


    public   static     boolean   getBoolean  (String key,  boolean defvalue )  {


        return   getPreferences().getBoolean(key, defvalue);


    }


    public  static   String    getString ( String key,  String defvalue)  {


        return    getPreferences().getString(key, defvalue) ;

    }



    public   static   void     setDisplaySize  ( Activity activity)   {

        DisplayMetrics displayMetrics   =   new DisplayMetrics()  ;

        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        Editor    editor     =   getPreferences().edit() ;

        editor.putInt("screen_width",displayMetrics.widthPixels);

        editor.putInt("screen_height",displayMetrics.heightPixels) ;

        editor.apply();

    }


    public    static    int[]    getDislaySize   ( int arg0, int  arg1)  {

        int []  size   =  {};

        size[0] =  getPreferences().getInt("screen_width",arg0) ;

        size[1]  = getPreferences().getInt("screen_height",arg1);

        return   size  ;

    }





}
