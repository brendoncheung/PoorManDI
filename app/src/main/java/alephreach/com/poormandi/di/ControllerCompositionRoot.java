package alephreach.com.poormandi.di;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import alephreach.com.poormandi.Networking.MovieDBApi;
import alephreach.com.poormandi.Networking.FetchLatestMovieUseCase;
import alephreach.com.poormandi.adapers.LatestMovieAdapter;
import alephreach.com.poormandi.services.FragmentFrameManager;
import alephreach.com.poormandi.services.FragmentFrameWrapper;
import alephreach.com.poormandi.services.FragmentNavigator;

public class ControllerCompositionRoot {

    private final CompositionRoot mCompositionRoot;
    private final FragmentActivity mFragmentActivity;

    public ControllerCompositionRoot(CompositionRoot compositionRoot, FragmentActivity activity) {
        mCompositionRoot = compositionRoot;
        mFragmentActivity = activity;
    }

    private MovieDBApi getDarkSkyApi() {
        return mCompositionRoot.getDarkSkyApi();
    }

    private FragmentActivity getActivity() {
        return mFragmentActivity;
    }

    private FragmentManager getFragmentManager() {
        return getActivity().getSupportFragmentManager();
    }

    private FragmentFrameWrapper getFragmentFrameWrapper() {
        return (FragmentFrameWrapper) getActivity();
    }

    private FragmentFrameManager getFragmentFrameManager() {
        return new FragmentFrameManager(getFragmentManager(), getFragmentFrameWrapper());
    }


    public LatestMovieAdapter getLatestMovieAdapter(LatestMovieAdapter.Listener listener) {
        return new LatestMovieAdapter(listener);
    }


    public FetchLatestMovieUseCase getFetchCurrentWeatherUsecase() {
        return new FetchLatestMovieUseCase(getDarkSkyApi());
    }

    public FragmentNavigator getFragmentNavigator() {
        return new FragmentNavigator(getFragmentFrameManager());
    }




}
