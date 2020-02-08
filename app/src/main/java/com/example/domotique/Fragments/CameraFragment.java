package com.example.domotique.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.domotique.R;

public class CameraFragment extends Fragment {
    private final static String TAG = CameraFragment.class.getName();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateViewCamera");
        return inflater.inflate(R.layout.fragment_camera, container, false);
    }

}