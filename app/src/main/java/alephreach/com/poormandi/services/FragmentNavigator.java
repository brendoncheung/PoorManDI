package alephreach.com.poormandi.services;

import alephreach.com.poormandi.Networking.LatestMovie;
import alephreach.com.poormandi.screens.LatestMovieDetailFragment;
import alephreach.com.poormandi.screens.LatestMovieFragment;

public class FragmentNavigator {

    private final FragmentFrameManager mFragmentFrameSwapper;

    public FragmentNavigator(FragmentFrameManager fragmentFrameManager) {
        mFragmentFrameSwapper = fragmentFrameManager;
    }

    public void navigateToDetailScreen(String description) {
        mFragmentFrameSwapper.replaceFragment(LatestMovieDetailFragment.newInstance(description));

    }

    public void navigateToLatestMovieScreen() {
        mFragmentFrameSwapper.replaceFragment(LatestMovieFragment.newInstance());
    }

    public void navigateToAddItemScreen() {

    }

}
