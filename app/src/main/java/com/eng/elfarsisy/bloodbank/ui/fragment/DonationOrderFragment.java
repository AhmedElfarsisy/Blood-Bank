package com.eng.elfarsisy.bloodbank.ui.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.eng.elfarsisy.bloodbank.R;
import com.eng.elfarsisy.bloodbank.adapter.DonationAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DonationOrderFragment extends Fragment {


    RecyclerView donationRecycler;
    Spinner donerCity;
    Spinner donerBloodtype;
    List<String> donarcityList;
    List<String> donarbloodtypeList;


    public DonationOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_donation_order, container, false);

        donerCity = view.findViewById(R.id.donarcity);
        donerBloodtype = view.findViewById(R.id.donerBloodType);

        donarcityList = new ArrayList<>();
        donarcityList.add("اختر المدينة");
        donarcityList.add("Giza");
        donarcityList.add("Mansoura");
        donarcityList.add("Cairo");
        donarcityList.add("Alex");
        donarbloodtypeList = new ArrayList<>();
        donarbloodtypeList.add("اختر فصيلة الدم");
        donarbloodtypeList.add("A+");
        donarbloodtypeList.add("o+");
        donarbloodtypeList.add("B+");
        donarbloodtypeList.add("A-");

        ArrayAdapter spinneradaptertype = new ArrayAdapter(container.getContext(), android.R.layout.simple_spinner_dropdown_item, donarbloodtypeList);
        spinneradaptertype.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        donerBloodtype.setAdapter(spinneradaptertype);

        ArrayAdapter spinneradaptercity = new ArrayAdapter(container.getContext(), android.R.layout.simple_spinner_dropdown_item, donarcityList);
        spinneradaptercity.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        donerCity.setAdapter(spinneradaptercity);

        donationRecycler = view.findViewById(R.id.donationrecycler);
        DonationAdapter donationAdapter = new DonationAdapter(container.getContext(),getFragmentManager());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        donationRecycler.setLayoutManager(linearLayoutManager);
        donationRecycler.setAdapter(donationAdapter);


        return view;
    }

}
