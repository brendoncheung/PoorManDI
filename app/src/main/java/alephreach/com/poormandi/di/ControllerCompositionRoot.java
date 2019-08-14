package alephreach.com.poormandi.di;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import alephreach.com.poormandi.Networking.MovieDBApi;
import alephreach.com.poormandi.Networking.FetchLatestMovieUseCase;
import alephreach.com.poormandi.services.FragmentFrameSwapper;
import alephreach.com.poormandi.services.FragmentFrameWrapper;

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

    public FragmentFrameSwapper getFragmentFrameSwapper() {
        return new FragmentFrameSwapper(getFragmentManager(), getFragmentFrameWrapper());
    }



    public FetchLatestMovieUseCase getFetchCurrentWeatherUsecase() {
        return new FetchLatestMovieUseCase(getDarkSkyApi());
    }




}
