package alephreach.com.poormandi.screens;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import alephreach.com.poormandi.Networking.FetchLatestMovieUseCase;
import alephreach.com.poormandi.Networking.Movie;
import alephreach.com.poormandi.R;
import alephreach.com.poormandi.services.FragmentFrameWrapper;
import alephreach.com.poormandi.services.FragmentNavigator;

public class MainActivity extends BaseActivity implements
        FragmentFrameWrapper {

    private FragmentNavigator mFragmentNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentNavigator = getControllerCompositionRoot().getFragmentNavigator();
    }

    @Override
    public FrameLayout getFragmentFrame() {
        return findViewById(R.id.main_fragment);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFragmentNavigator.navigateToLatestMovieScreen();
    }



}
