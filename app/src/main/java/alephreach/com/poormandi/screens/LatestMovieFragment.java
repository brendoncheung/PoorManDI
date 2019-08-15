package alephreach.com.poormandi.screens;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import alephreach.com.poormandi.Networking.FetchLatestMovieUseCase;
import alephreach.com.poormandi.Networking.LatestMovie;
import alephreach.com.poormandi.Networking.Movie;
import alephreach.com.poormandi.R;
import alephreach.com.poormandi.adapers.LatestMovieAdapter;

public class LatestMovieFragment extends BaseFragment
        implements LatestMovieAdapter.Listener, FetchLatestMovieUseCase.Listener {

    private RecyclerView mRecyclerView;
    private FetchLatestMovieUseCase mFetchLatestMovieUseCase;
    private LatestMovieAdapter mLatestMovieAdapter;

    public static LatestMovieFragment newInstance() {
        LatestMovieFragment fragment = new LatestMovieFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_latest_movie, container, false);

        mRecyclerView = view.findViewById(R.id.latest_movie_recycler_view);

        mFetchLatestMovieUseCase = getControllerCompositionRoot().getFetchCurrentWeatherUsecase();
        mFetchLatestMovieUseCase.registerListeners(this);
        mFetchLatestMovieUseCase.fetchLatestMovieAndNotify();

        mLatestMovieAdapter = getControllerCompositionRoot().getLatestMovieAdapter(this);

        mRecyclerView.setAdapter(mLatestMovieAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    @Override
    public void onMovieItemClicked(LatestMovie movie) {
        Toast.makeText(getContext(), movie.getTitle() + " clicked", Toast.LENGTH_SHORT).show();
        getControllerCompositionRoot().getFragmentNavigator().navigateToDetailScreen(movie.getDescription());
    }

    @Override
    public void onFetchLatestMovieSuccess(Movie movie) {
        mLatestMovieAdapter.bindMovie(movie.getLatestMovieList());
    }

    @Override
    public void onFetchLatestMovieFailure(String msg) {

    }
}
