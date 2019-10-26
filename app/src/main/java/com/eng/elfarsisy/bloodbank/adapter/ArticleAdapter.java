package com.eng.elfarsisy.bloodbank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eng.elfarsisy.bloodbank.R;

import java.util.zip.Inflater;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleHolder> {
    Context mContext;

    public ArticleAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ArticleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.article_item, parent, false);
        return new ArticleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ArticleHolder extends RecyclerView.ViewHolder {
        de.hdodenhof.circleimageview.CircleImageView likeimage;
        int love = 0;
        public ArticleHolder(@NonNull View itemView) {
            super(itemView);

            likeimage = itemView.findViewById(R.id.like);
            likeimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (love == 0) {
                        likeimage.setImageResource(R.drawable.lovedark);
                        love++;
                    } else {
                        likeimage.setImageResource(R.drawable.lovelight);
                        love--;
                    }
                }
            });

        }
    }
}
