package com.ghhitech.smisseal.network;

import android.content.Context;

import com.ghhitech.smisseal.constants.SealConstants;
import com.ghhitech.smisseal.interceptor.CookieInterceptor;
import com.ghhitech.smisseal.interceptor.HeadersInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.internal.cache.CacheInterceptor;

public class HttpProvider {

    static OkHttpClient okHttpClient;

    public static OkHttpClient Builder(Context context){
        if (okHttpClient==null) {
            synchronized (HttpProvider.class) {
                if (okHttpClient==null) {
                    OkHttpClient client = new OkHttpClient.Builder()
                            .retryOnConnectionFailure(true)
                            .addNetworkInterceptor(new com.ghhitech.smisseal.interceptor.CacheInterceptor())
                            .cache(new CacheProvider(context).provideCache())
                            .connectTimeout(SealConstants.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            .addInterceptor(new CookieInterceptor())
                            .addInterceptor(new HeadersInterceptor(context))
                            .build();
                    okHttpClient = client;
                }
            }
        }
        return okHttpClient;
    }

    public static boolean checkNULL(String str)
    {
        return ((str == null) || ("null".equals(str)) || ("".equals(str)));
    }
}
