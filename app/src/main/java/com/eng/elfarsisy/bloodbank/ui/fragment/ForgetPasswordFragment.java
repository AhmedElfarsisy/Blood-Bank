package com.eng.elfarsisy.bloodbank.ui.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.eng.elfarsisy.bloodbank.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForgetPasswordFragment extends Fragment {
    Button sendCode;
    EditText phone;

    public ForgetPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forget_password, container, false);
        sendCode = view.findViewById(R.id.sendcode);
        phone = view.findViewById(R.id.forgetPhone);
        sendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNum = phone.getText().toString().trim();
                if (!TextUtils.isEmpty(phoneNum)) {
                    getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("SignInFragment").replace(R.id.fragment_container, new ChangePasswordFragment()).commit();

                }
            }
        });

        return view;
    }

}
