package alephreach.com.poormandi.screens;

import android.support.v7.app.AppCompatActivity;

import alephreach.com.poormandi.PMApplication;
import alephreach.com.poormandi.di.CompositionRoot;
import alephreach.com.poormandi.di.ControllerCompositionRoot;

public class BaseActivity extends AppCompatActivity {

    private ControllerCompositionRoot mControllerCompositionRoot;

    protected ControllerCompositionRoot getControllerCompositionRoot() {
        if (mControllerCompositionRoot == null) {
            mControllerCompositionRoot = new ControllerCompositionRoot(getCompositionRoot(), this);
        }
        return mControllerCompositionRoot;
    }

    private CompositionRoot getCompositionRoot() {
        return ((PMApplication) getApplication()).getCompositionRoot();
    }

}
