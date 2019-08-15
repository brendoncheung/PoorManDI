package alephreach.com.poormandi.Networking;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {

    @SerializedName("results")
    private List<LatestMovie> mLatestMovieList;

    public List<LatestMovie> getLatestMovieList() {
        return mLatestMovieList;
    }
}
