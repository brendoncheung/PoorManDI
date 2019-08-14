package alephreach.com.poormandi.Networking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDBApi {

    @GET("/3/movie/popular")
    Call<Movie> getCurrentWeather(@Query("api_key")String key);
}
