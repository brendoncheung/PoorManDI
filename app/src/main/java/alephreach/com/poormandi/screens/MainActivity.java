package alephreach.com.poormandi.screens;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import alephreach.com.poormandi.Networking.FetchLatestMovieUseCase;
import alephreach.com.poormandi.Networking.Movie;
import alephreach.com.poormandi.R;
import alephreach.com.poormandi.services.FragmentFrameWrapper;

public class MainActivity extends BaseActivity implements
        FetchLatestMovieUseCase.Listener,
        FragmentFrameWrapper
{
    
    private FetchLatestMovieUseCase mFetchCurrentWeatherUsecase;
    private Movie mMovie;

    private FrameLayout mFragmentFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mFetchCurrentWeatherUsecase = getControllerCompositionRoot().getFetchCurrentWeatherUsecase();
        mFetchCurrentWeatherUsecase.fetchLatestMovieAndNotify();
        mFragmentFrame = findViewById(R.id.main_fragment);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFetchCurrentWeatherUsecase.registerListeners(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mFetchCurrentWeatherUsecase.unregisterListener(this);
    }

    @Override
    public void onFetchLatestMovieSuccess(Movie movie) {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();

        mMovie = movie;
    }

    @Override
    public void onFetchLatestMovieFailure(String msg) {

    }

    @Override
    public FrameLayout getFragmentFrame() {
        return mFragmentFrame;
    }
}
