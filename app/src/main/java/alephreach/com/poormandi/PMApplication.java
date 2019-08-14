package alephreach.com.poormandi;

import android.app.Application;

import alephreach.com.poormandi.di.CompositionRoot;

public class PMApplication extends Application {

    private CompositionRoot mCompositionRoot;

    @Override
    public void onCreate() {
        super.onCreate();
        mCompositionRoot = new CompositionRoot();
    }

    public CompositionRoot getCompositionRoot() {
        return mCompositionRoot;
    }
}
