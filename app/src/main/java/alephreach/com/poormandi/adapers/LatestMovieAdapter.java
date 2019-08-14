package alephreach.com.poormandi.adapers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import alephreach.com.poormandi.Networking.LatestMovie;
import alephreach.com.poormandi.R;

public class LatestMovieAdapter extends RecyclerView.Adapter<LatestMovieAdapter.ViewHolder> {

    private List<LatestMovie> mLatestMovieList;

    public void bindMovie(List<LatestMovie> movies) {
        mLatestMovieList = movies;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());

        View view = layoutInflater.inflate(R.layout.view_latest_movie_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        LatestMovie movie = mLatestMovieList.get(i);

        viewHolder.mTitle.setText(movie.getTitle());
        viewHolder.mRating.setText(movie.getVoteAverage());
    }

    @Override
    public int getItemCount() {
        return mLatestMovieList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitle;
        private TextView mRating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.latest_movie_id);
            mRating = itemView.findViewById(R.id.latest_movie_vote_id);
        }
    }
}
