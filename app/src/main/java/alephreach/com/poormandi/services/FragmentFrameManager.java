package alephreach.com.poormandi.services;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FragmentFrameManager {

    private final FragmentManager mFragmentManager;
    private final FragmentFrameWrapper mFragmentFrameWrapper;

    public FragmentFrameManager(FragmentManager manager, FragmentFrameWrapper wrapper) {
        mFragmentManager = manager;
        mFragmentFrameWrapper = wrapper;
    }

    public void replaceFragment(Fragment newFragment) {

        FragmentTransaction ft = mFragmentManager.beginTransaction();

        if(mFragmentManager.getBackStackEntryCount() == 0) {
            ft.add(getFragmentId(), newFragment);
        } else {
            ft.replace(getFragmentId(), newFragment);
        }

        ft.addToBackStack(null);
        ft.commit();

    }

    private int getFragmentId() {
        return mFragmentFrameWrapper.getFragmentFrame().getId();
    }

}
