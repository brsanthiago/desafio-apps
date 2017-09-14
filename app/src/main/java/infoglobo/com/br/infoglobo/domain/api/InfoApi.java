package infoglobo.com.br.infoglobo.domain.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import infoglobo.com.br.infoglobo.BuildConfig;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import android.util.Log;
import okhttp3.logging.HttpLoggingInterceptor;
import static okhttp3.logging.HttpLoggingInterceptor.Level.HEADERS;
import static okhttp3.logging.HttpLoggingInterceptor.Level.NONE;
/**
 * Created by Bruno Santiago on 11/09/17.
 */

public class InfoApi {

    private final String BASE_URL = "https://raw.githubusercontent.com/Infoglobo/desafio-apps/master/";
    private Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create();


    public Retrofit provideApi() {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(
                        GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient())
                .build();
    }

    private OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(provideHttpLoggingInterceptor())
                .build();
    }


    private HttpLoggingInterceptor provideHttpLoggingInterceptor ()
    {
        HttpLoggingInterceptor httpLoggingInterceptor =
                new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Log.d("INFO_GLOBO", message);
                    }
                });
        httpLoggingInterceptor.setLevel(BuildConfig.DEBUG ? HEADERS : NONE );
        return httpLoggingInterceptor;
    }
}
