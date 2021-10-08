package com.tapque.game.skilly.app.newwork;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tapque.game.skilly.ui.Skilly;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * time:2017/4/7
 * description:
 * author: LiYou
 */

public class Api {

    public static final String baseUrl = "http://121.199.2.104:8090";

    //读超时长，单位：毫秒
    private static final int READ_TIME_OUT = 60000;
    //连接时长，单位：毫秒
    private static final int CONNECT_TIME_OUT = 30000;
    private Retrofit retrofit;
    private ApiService apiService;
    private static Api retrofitManager;

    //构造方法私有
    private Api() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //缓存
        File cacheFile = new File(Skilly.getInstance().getCacheDir(), "cache");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100MB

        //添加请求头
        Interceptor headerInterceptor = chain -> {
            //String tokenData = SPUtils.getSharedStringData(AppConfig.USER_TOKEN);
            Request build = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json;charset=utf-8")
                    .addHeader("token", "")
                    .build();
            return chain.proceed(build);
        };

        //日志显示级别
        if (Skilly.isDebug) {
            HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
            //新建log拦截器
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(
                    message ->
                            Log.e("OkHttp", message)
            );
            loggingInterceptor.setLevel(level);

            builder.addNetworkInterceptor(loggingInterceptor);
        }

        builder.readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .addInterceptor(headerInterceptor)
                .cache(cache);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();//使用 gson coverter，统一日期请求格式

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public static ApiService getDefault() {
        if (retrofitManager == null) {
            synchronized (Api.class) {
                retrofitManager = new Api();
            }
        }
        return retrofitManager.apiService;
    }

}
