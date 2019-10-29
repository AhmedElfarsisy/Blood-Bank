package com.eng.elfarsisy.bloodbank.ui.fragment;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.eng.elfarsisy.bloodbank.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DonationRequestFragment extends Fragment {

    Toolbar requestToolbar;
    Spinner city;
    Spinner governorate;
    Spinner casecount;
    ImageButton hospitallocation;
    double latitude;
    double longtitude;
    EditText requestHospitalAddress;

    public DonationRequestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_donation_request, container, false);

        city = view.findViewById(R.id.requestcity);
        governorate = view.findViewById(R.id.requestgovernorate);
        casecount = view.findViewById(R.id.casenumber);
        List<String> governoratList = new ArrayList<>();
        governoratList.add("المحافظة");
        governoratList.add("Alexandria");
        governoratList.add("Aswan");
        governoratList.add("Cairo");
        governoratList.add("Dakahlia ");
        List<String> cityList = new ArrayList<>();
        cityList.add("المدينة");
        cityList.add("Giza");
        cityList.add("Mansoura");
        cityList.add("Cairo");
        cityList.add("Alex");
        List<String> casecountList = new ArrayList<>();
        casecountList.add("عدد الأكياس");
        casecountList.add("1");
        casecountList.add("2");
        casecountList.add("3");
        casecountList.add("4");
        ArrayAdapter governoratAdapter = new ArrayAdapter(container.getContext(), android.R.layout.simple_spinner_dropdown_item, governoratList);
        governoratAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        governorate.setAdapter(governoratAdapter);

        ArrayAdapter cityAdapter = new ArrayAdapter(container.getContext(), android.R.layout.simple_spinner_dropdown_item, cityList);
        cityAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        city.setAdapter(cityAdapter);
        ArrayAdapter casecountAdapter = new ArrayAdapter(container.getContext(), android.R.layout.simple_spinner_dropdown_item, casecountList);
        casecountAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        casecount.setAdapter(casecountAdapter);


        requestHospitalAddress = view.findViewById(R.id.requesthospitaladdress);
        requestToolbar = view.findViewById(R.id.requesttoolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(requestToolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.backicon);
        hospitallocation = view.findViewById(R.id.requestlocation);
        hospitallocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack("DonationRequestFragment")
                        .replace(R.id.main_container, new MapFragment())
                        .commit();
            }
        });
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            latitude = bundle.getDouble("latitude");
            longtitude = bundle.getDouble("latitude");

        }
        requestHospitalAddress.setText(latitude + "," + longtitude);

        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.notificationmenu, menu);

    }


}
