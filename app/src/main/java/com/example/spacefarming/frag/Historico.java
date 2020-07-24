package com.example.spacefarming.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.spacefarming.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Historico#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Historico extends Fragment {


    public Historico() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_historico, container, false);
        return v;
    }
}