package com.gil.maxapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MySpoilsFragment extends Fragment {


    static MySpoilsFragment instance;

    public static MySpoilsFragment getInstance(){
        if (instance == null){
            instance = new MySpoilsFragment();
        }
        return instance;
    }


    public MySpoilsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_spoils, container, false);
    }

}
