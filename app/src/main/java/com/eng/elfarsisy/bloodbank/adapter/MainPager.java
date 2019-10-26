package com.eng.elfarsisy.bloodbank.adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.eng.elfarsisy.bloodbank.R;
import com.eng.elfarsisy.bloodbank.ui.fragment.ArticlesFragment;
import com.eng.elfarsisy.bloodbank.ui.fragment.DonationOrderFragment;

public class MainPager extends FragmentPagerAdapter {
    Context mContext;

    public MainPager(FragmentManager fm, Context mContext) {
        super(fm);
        this.mContext = mContext;

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new ArticlesFragment();
                break;
            case 1:
                fragment = new DonationOrderFragment();
                break;
            default:
                fragment = new ArticlesFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = mContext.getResources().getString(R.string.tab1);
                break;
            case 1:
                title = mContext.getResources().getString(R.string.tab2);
                break;

        }

        return title;
    }
}
