package com.eng.elfarsisy.bloodbank.ui.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eng.elfarsisy.bloodbank.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DonationOrderFragment extends Fragment {


    public DonationOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donation_order, container, false);
    }

}
