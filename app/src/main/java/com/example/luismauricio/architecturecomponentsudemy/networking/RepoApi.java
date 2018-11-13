package com.example.luismauricio.architecturecomponentsudemy.networking;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RepoApi {

    private static final String BASE_URL = "https://api.github.com/";
    private static Retrofit sRetrofit;
    private static RepoService sRepoService;

    private RepoApi() {
    }

    public static RepoService getInstance() {
        if (sRepoService != null) {
            return sRepoService;
        }
        if (sRetrofit == null) {
            initializeRetrofit();
        }
        sRepoService = sRetrofit.create(RepoService.class);
        return sRepoService;
    }

    public static void initializeRetrofit() {
        sRetrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(getClient())
                .build();
    }

    private static OkHttpClient getClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
    }
}

