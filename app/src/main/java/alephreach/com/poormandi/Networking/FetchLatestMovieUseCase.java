package alephreach.com.poormandi.Networking;

import android.util.Log;

import java.util.HashSet;
import java.util.Set;

import alephreach.com.poormandi.common.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchLatestMovieUseCase {

    public interface Listener {
        void onFetchLatestMovieSuccess(Movie movie);
        void onFetchLatestMovieFailure(String msg);
    }

    private Set<Listener> mListeners = new HashSet<>();

    private final MovieDBApi mMovieDBApi;

    public void registerListeners(Listener listener) {
        mListeners.add(listener);
    }

    public void unregisterListener(Listener listener) {
        mListeners.remove(listener);
    }

    public FetchLatestMovieUseCase(MovieDBApi movieDBApi) {
        mMovieDBApi = movieDBApi;
    }

    public void fetchLatestMovieAndNotify() {

        mMovieDBApi.getCurrentWeather(Constants.MOVIEDB_API_KEY).enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Log.d("Retrofit", call.request().toString());
                if(response.isSuccessful()) {
                    notifySuccess(response.body());
                } else {
                    notifyFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                notifyFailure(t.getMessage());
            }
        });

    }

    public void notifySuccess(Movie movie) {
        for (Listener listener : mListeners) {
            listener.onFetchLatestMovieSuccess(movie);
        }
    }

    public void notifyFailure(String msg) {
        for (Listener listener : mListeners) {
            listener.onFetchLatestMovieFailure(msg);
        }
    }



}
