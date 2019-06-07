package com.example.zagamx.proyectofinalpma.Shared;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedLogin {
    private static SharedLogin minst;
    private static Context mct;

    private static final String SHARD_PERFNAME="myshardperf624";
    private static final String KEY_ID="id";
    private static final String KEY_USERNAME="name";
    private static final String KEY_EMAIL="email";
    private static final String KEY_PASS="pass";
    private static final String KEY_CARRERA="carrera";
    private static final String KEY_SEMESTRE="semestre";
    private static final String KEY_TURNO="turno";

    private SharedLogin(Context context){
        mct=context;
    }
    public static synchronized SharedLogin getInstans(Context context){
        if (minst==null){
            minst=new SharedLogin(context);
        }
        return minst;
    }
    public boolean userLogin(String id,String name,String email,String contra,String carrera,String semestre, String turno){
        SharedPreferences sharedPreferences=mct.getSharedPreferences(SHARD_PERFNAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(KEY_ID,id);
        editor.putString(KEY_USERNAME,name);
        editor.putString(KEY_EMAIL,email);
        editor.putString(KEY_PASS,contra);
        editor.putString(KEY_CARRERA,carrera);
        editor.putString(KEY_SEMESTRE,semestre);
        editor.putString(KEY_TURNO,turno);
        editor.apply();
        return true;
    }
    public boolean isLogin(){
        SharedPreferences sharedPreferences=mct.getSharedPreferences(SHARD_PERFNAME,Context.MODE_PRIVATE);
        if (sharedPreferences.getString(KEY_ID,null)!=null){
            return true;
        }
        return false;
    }
    public boolean logout(){
        SharedPreferences sharedPreferences=mct.getSharedPreferences(SHARD_PERFNAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;

    }
    public String getUserId(){
        SharedPreferences sharedPreferences=mct.getSharedPreferences(SHARD_PERFNAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_ID,null);

    }
    public String getUsername(){
        SharedPreferences sharedPreferences=mct.getSharedPreferences(SHARD_PERFNAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME,null);

    }
    public String getUserEmail(){
        SharedPreferences sharedPreferences=mct.getSharedPreferences(SHARD_PERFNAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_EMAIL,null);

    }

    public String getUserPass(){
        SharedPreferences sharedPreferences = mct.getSharedPreferences(SHARD_PERFNAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_PASS, null);
    }

    public String getUserCarrera(){
        SharedPreferences sharedPreferences = mct.getSharedPreferences(SHARD_PERFNAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_CARRERA, null);
    }

    public String getUserSemestre(){
        SharedPreferences sharedPreferences = mct.getSharedPreferences(SHARD_PERFNAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_SEMESTRE, null);
    }
    public String getUserTurno(){
        SharedPreferences sharedPreferences = mct.getSharedPreferences(SHARD_PERFNAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_TURNO, null);
    }
}
