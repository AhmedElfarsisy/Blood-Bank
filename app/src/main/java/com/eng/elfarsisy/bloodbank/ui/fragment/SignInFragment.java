package com.eng.elfarsisy.bloodbank.ui.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.eng.elfarsisy.bloodbank.R;
import com.eng.elfarsisy.bloodbank.ui.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {

    Button signinBtn, registerMoveBtn;
    TextView forgetpassword;
    CheckBox remember;
    EditText signPhone;
    EditText signPassword;

    public SignInFragment() {
        // Required empty public constructor
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        forgetpassword = view.findViewById(R.id.forgetPassword);
        signinBtn = view.findViewById(R.id.signinbtn);
        registerMoveBtn = view.findViewById(R.id.registerMove);
        signPassword = view.findViewById(R.id.signinPassword);
        signPhone = view.findViewById(R.id.signinMobile);
        remember = view.findViewById(R.id.checkBox);
        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("SignInFragment").replace(R.id.fragment_container, new ForgetPasswordFragment()).commit();
            }
        });
        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = signPhone.getText().toString().trim();
                String password = signPassword.getText().toString().trim();
                if (!TextUtils.isEmpty(phone) && !TextUtils.isEmpty(password)) {
                    startActivity(new Intent(getActivity(), MainActivity.class));
                } else {
                    Toast.makeText(getActivity(), "complet fields", Toast.LENGTH_SHORT).show();
                }

            }
        });
        registerMoveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("SignInFragment").replace(R.id.fragment_container, new RegisterFragment()).commit();

            }
        });
        return view;
    }


}
