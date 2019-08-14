package alephreach.com.poormandi.Networking;

import com.google.gson.annotations.SerializedName;

public class LatestMovie {

    @SerializedName("title")
    private String mTitle;

    @SerializedName("vote_average")
    private String mVoteAverage;

    public String getTitle() {
        return mTitle;
    }

    public String getVoteAverage() {
        return mVoteAverage;
    }
}
