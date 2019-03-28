package com.example.ali.bitirmeprojesi.Diets.Akdeniz;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ali.bitirmeprojesi.R;

public class TabListe extends Fragment {
    private static final String TAG="TabListe";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view =inflater.inflate(R.layout.akdeniz_liste,container,false);
       return view;
    }
}
