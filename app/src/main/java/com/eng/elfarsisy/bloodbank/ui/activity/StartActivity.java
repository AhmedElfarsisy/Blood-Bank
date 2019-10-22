package com.eng.elfarsisy.bloodbank.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.eng.elfarsisy.bloodbank.R;
import com.eng.elfarsisy.bloodbank.helper.Helper;
import com.eng.elfarsisy.bloodbank.ui.fragment.SliderFragment;
import com.eng.elfarsisy.bloodbank.ui.fragment.SpalshFragment;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SpalshFragment()).commit();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SliderFragment()).commit();
            }
        }, 2000);
    }
}
