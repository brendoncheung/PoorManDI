package alephreach.com.poormandi.screens;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import alephreach.com.poormandi.R;

public class LatestMovieDetailFragment extends BaseFragment {

    public static final String MOVIE_DESC_KEY = "MOVIE_DESC_KEY";

    private TextView mDescriptionTextView;

    public static LatestMovieDetailFragment newInstance(String description) {

        LatestMovieDetailFragment fragment = new LatestMovieDetailFragment();
        Bundle bundle = new Bundle();

        bundle.putString(MOVIE_DESC_KEY, description);

        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_latest_movie_description, container, false);
        mDescriptionTextView = view.findViewById(R.id.latest_movie_description_id);

        mDescriptionTextView.setText(getArguments().getString(LatestMovieDetailFragment.MOVIE_DESC_KEY));

        return view;
    }
}
