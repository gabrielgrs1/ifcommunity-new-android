package ifcommunity.com.br.ifcommunity.service.api;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.concurrent.TimeUnit;

import ifcommunity.com.br.ifcommunity.utils.Utils;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * API Client for request on server
 *
 */
public class APIClient {

    private Retrofit retrofit;
    private OkHttpClient okHttpClient;
    private Picasso picasso;

    public APIClient(@NonNull Context context, @NonNull String baseUrl) {

        buildOkHttpClient();
        buildRetrofit(baseUrl);
    }

    private void buildOkHttpClient() {
        okHttpClient = new OkHttpClient()
                .newBuilder()
                .addInterceptor(checkConnectionInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    private void buildRetrofit(@NonNull String baseUrl) {
        retrofit = new Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    private final Interceptor checkConnectionInterceptor = chain -> {
        if (!Utils.isOnline()) {
            throw new NoConnectionException();
        }
        return chain.proceed(chain.request());
    };

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public Picasso getPicasso() {
        return picasso;
    }

}
