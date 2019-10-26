package com.eng.elfarsisy.bloodbank.ui.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ListAdapter;

import com.eng.elfarsisy.bloodbank.R;
import com.eng.elfarsisy.bloodbank.adapter.ArticleAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticlesFragment extends Fragment {
    EditText search;
    ArticleAdapter articleAdapter;
    RecyclerView articleRecycler;

    public ArticlesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_articles, container, false);
        articleRecycler = view.findViewById(R.id.recyclerarticl);
        search = view.findViewById(R.id.searchtxt);
        articleAdapter = new ArticleAdapter(container.getContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        articleRecycler.setLayoutManager(linearLayoutManager);
        articleRecycler.setAdapter(articleAdapter);



        return view;
    }

}
