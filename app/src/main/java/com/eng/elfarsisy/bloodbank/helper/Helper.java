package com.eng.elfarsisy.bloodbank.helper;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.eng.elfarsisy.bloodbank.R;
import com.eng.elfarsisy.bloodbank.ui.fragment.SpalshFragment;

public class Helper {
    public static void replaceFragment(Context context, int container, Fragment fragment, String back) {

        Fragment f = new Fragment();
        f.getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(container, fragment).addToBackStack(back).commit();

    }

}
