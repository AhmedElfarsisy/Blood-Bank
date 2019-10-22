package com.eng.elfarsisy.bloodbank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.eng.elfarsisy.bloodbank.R;

import java.util.List;

public class SildeAdapter extends PagerAdapter {
    Context mContext;
    List<Integer> instarctionList;

    public SildeAdapter() {
    }

    public SildeAdapter(Context mContext, List<Integer> instarctionList) {
        this.mContext = mContext;
        this.instarctionList = instarctionList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View slideLayout = inflater.inflate(R.layout.slide_item, null);
        ImageView slideImage = slideLayout.findViewById(R.id.slideImage);
        slideImage.setImageResource(instarctionList.get(position));
        container.addView(slideLayout);
        return slideLayout ;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);

    }

    @Override
    public int getCount() {
        return instarctionList.size() > 0 ? instarctionList.size() : 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
