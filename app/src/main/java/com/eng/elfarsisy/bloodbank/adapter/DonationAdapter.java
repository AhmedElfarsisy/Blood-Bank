package com.eng.elfarsisy.bloodbank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eng.elfarsisy.bloodbank.R;
import com.eng.elfarsisy.bloodbank.ui.fragment.DonationDetailsFragment;
import com.eng.elfarsisy.bloodbank.ui.fragment.DonationOrderFragment;
import com.eng.elfarsisy.bloodbank.ui.fragment.PostDetailsFragment;

public class DonationAdapter extends RecyclerView.Adapter<DonationAdapter.DonationHolder> {

    Context mContext;
    FragmentManager fm;

    public DonationAdapter() {
    }

    public DonationAdapter(Context mContext, FragmentManager fm) {
        this.mContext = mContext;
        this.fm = fm;
    }

    @NonNull
    @Override
    public DonationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.donation_requests_layout, parent, false);
        return new DonationHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DonationHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class DonationHolder extends RecyclerView.ViewHolder {
        Button donationDetails;

        public DonationHolder(@NonNull View itemView) {
            super(itemView);
            donationDetails = itemView.findViewById(R.id.donationrequestdetails);
            donationDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fm.beginTransaction().replace(R.id.main_container, new DonationDetailsFragment())
                            .addToBackStack("DonationOrderFragment")
                            .commit();
                }
            });

        }
    }
}
