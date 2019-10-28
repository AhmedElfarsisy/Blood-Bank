package com.eng.elfarsisy.bloodbank.ui.fragment;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.eng.elfarsisy.bloodbank.R;
import com.eng.elfarsisy.bloodbank.ui.activity.MainActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    Toolbar toolbar;
    EditText regname;
    EditText regemail;
    EditText regBirthdate;
    EditText regBloodtype;
    EditText reglastDonate;
    Spinner reggovernorat;
    Spinner regcity;
    EditText regphone;
    EditText regpassword;
    EditText regpassword2;
    Button Registerbtn;
    Context mContext;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        regname = view.findViewById(R.id.regName);
        regemail = view.findViewById(R.id.regEmail);
        regBloodtype = view.findViewById(R.id.regBloodType);
        regBirthdate = view.findViewById(R.id.regBirthDate);
        reglastDonate = view.findViewById(R.id.regLastDonate);
        regphone = view.findViewById(R.id.regPhone);
        regpassword = view.findViewById(R.id.regPassword);
        regpassword2 = view.findViewById(R.id.regPassword2);
        Registerbtn = view.findViewById(R.id.RegisterBtn);
        regcity = view.findViewById(R.id.regCity);
        reggovernorat = view.findViewById(R.id.regGovernorate);
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
        ArrayAdapter governoratAdapter = new ArrayAdapter(container.getContext(), android.R.layout.simple_spinner_dropdown_item, governoratList);
        governoratAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        reggovernorat.setAdapter(governoratAdapter);

        ArrayAdapter cityAdapter = new ArrayAdapter(container.getContext(), android.R.layout.simple_spinner_dropdown_item, cityList);
        cityAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        regcity.setAdapter(cityAdapter);
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        reglastDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePicker = new DatePickerDialog(container.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mDay, int mMonth, int mYear) {
                        mMonth = mMonth + 1;
                        reglastDonate.setText(mDay + " / " + mMonth + " / " + mYear);
                    }
                }, year, month, day);
                datePicker.show();
            }

        });
        regBirthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(container.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mDay, int mMonth, int mYear) {
                        mMonth = mMonth + 1;
                        regBirthdate.setText(mDay + " / " + mMonth + " / " + mYear);
                    }
                }, 2002, month, day);
                datePickerDialog.show();
            }
        });

        Registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = regname.getText().toString();
                String email = regemail.getText().toString();
                String phone = regphone.getText().toString();
                String lastdonatedate = reglastDonate.getText().toString();
                String birthdate = regBirthdate.getText().toString();
                String bloodtype = regBloodtype.getText().toString();
                String password = regpassword.getText().toString();
                String password2 = regpassword2.getText().toString();


                boolean allfieldsVerifed = !TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(phone) && !TextUtils.isEmpty(lastdonatedate) &&
                        !TextUtils.isEmpty(birthdate) && !TextUtils.isEmpty(bloodtype) && !TextUtils.isEmpty(password) && TextUtils.equals(password, password2);
                if (allfieldsVerifed) {
                    startActivity(new Intent(getActivity(), MainActivity.class));

                } else {
                    Toast.makeText(container.getContext(), "Verify all fields ", Toast.LENGTH_SHORT).show();

                }

            }
        });


        return view;
    }

}
