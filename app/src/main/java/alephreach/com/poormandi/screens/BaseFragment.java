package alephreach.com.poormandi.screens;

import android.support.v4.app.Fragment;

import alephreach.com.poormandi.PMApplication;
import alephreach.com.poormandi.di.CompositionRoot;
import alephreach.com.poormandi.di.ControllerCompositionRoot;

public class BaseFragment extends Fragment {

    private ControllerCompositionRoot mControllerCompositionRoot;

    protected ControllerCompositionRoot getControllerCompositionRoot() {
        if (mControllerCompositionRoot == null) {
            mControllerCompositionRoot = new ControllerCompositionRoot(getCompositionRoot(), requireActivity());
        }
        return mControllerCompositionRoot;
    }

    private CompositionRoot getCompositionRoot() {
        return ((PMApplication) requireActivity().getApplication()).getCompositionRoot();
    }





}
