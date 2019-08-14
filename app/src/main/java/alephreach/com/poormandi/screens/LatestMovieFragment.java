package alephreach.com.poormandi.screens;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import alephreach.com.poormandi.Networking.Movie;
import alephreach.com.poormandi.R;
import alephreach.com.poormandi.adapers.LatestMovieAdapter;

public class LatestMovieFragment extends Fragment {

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_latest_movie, container, false);

        mRecyclerView = container.findViewById(R.id.latest_movie_recycler_view);

        LatestMovieAdapter adapter = new LatestMovieAdapter();

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}
