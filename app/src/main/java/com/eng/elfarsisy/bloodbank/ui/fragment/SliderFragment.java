package com.eng.elfarsisy.bloodbank.ui.fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;

import com.eng.elfarsisy.bloodbank.R;
import com.eng.elfarsisy.bloodbank.adapter.SildeAdapter;
import com.eng.elfarsisy.bloodbank.helper.Helper;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class SliderFragment extends Fragment {

    private List<Integer> instractList;
    private ViewPager viewPager;
    TabLayout tableLayout;
    Button skip;

    public SliderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_slider, container, false);
        viewPager = view.findViewById(R.id.viewpager);
        tableLayout = view.findViewById(R.id.indicator);
        skip = view.findViewById(R.id.skipbtn);
        instractList = new ArrayList<>();
        instractList.add(R.drawable.instract);
        instractList.add(R.drawable.instract1);
        instractList.add(R.drawable.instract2);
        SildeAdapter sildeAdapter = new SildeAdapter(getActivity(), instractList);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderFragment.Slidermove(), 3000, 2000);
        viewPager.setAdapter(sildeAdapter);
        tableLayout.setupWithViewPager(viewPager, true);
        skip.setVisibility(View.INVISIBLE);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.cancel();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SignInFragment()).commit();
            }
        });
        return view;

    }

    class Slidermove extends TimerTask {

        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() != instractList.size() - 1) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                        skip.setVisibility(View.VISIBLE);

                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }

}
