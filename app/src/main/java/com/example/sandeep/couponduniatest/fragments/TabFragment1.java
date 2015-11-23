package com.example.sandeep.couponduniatest.fragments;

/**
 * Created by sandeep on 23/11/15.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sandeep.couponduniatest.R;

public class TabFragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.i("TabFragment1","TabFragment1");


        return inflater.inflate(R.layout.tab_fragment_1, container, false);
    }
}