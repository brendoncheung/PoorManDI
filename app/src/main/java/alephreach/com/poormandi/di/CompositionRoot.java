package alephreach.com.poormandi.di;

import alephreach.com.poormandi.common.Constants;
import alephreach.com.poormandi.Networking.MovieDBApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompositionRoot {

    private Retrofit mRetrofit;

    private Retrofit getRetrofit() {

        if (mRetrofit == null) {

            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Constants.MOVIEDB_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }

    public MovieDBApi getMovieDBApi() {
        return getRetrofit().create(MovieDBApi.class);
    }


}
