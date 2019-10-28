package com.eng.elfarsisy.bloodbank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eng.elfarsisy.bloodbank.R;
import com.eng.elfarsisy.bloodbank.ui.fragment.ArticlesFragment;
import com.eng.elfarsisy.bloodbank.ui.fragment.PostDetailsFragment;

import java.util.zip.Inflater;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleHolder> {
    Context mContext;
    FragmentManager fm;

    public ArticleAdapter(Context mContext, FragmentManager fm) {
        this.mContext = mContext;
        this.fm = fm;
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
        ImageView postPhoto;
        int love = 0;

        public ArticleHolder(@NonNull View itemView) {
            super(itemView);

            likeimage = itemView.findViewById(R.id.like);
            postPhoto = itemView.findViewById(R.id.postphoto);
            postPhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fm.beginTransaction()
                            .replace(R.id.main_container, new PostDetailsFragment())
                            .addToBackStack("ArticlesFragment")
                            .commit();
                }
            });


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
