package com.example.domotique.Fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.domotique.R;
import com.squareup.picasso.Picasso;


public class CameraFragment extends Fragment {
    private final static String TAG = CameraFragment.class.getName();

    public ImageView image1;
    public ImageView image2;
    private Boolean bool = true;

    private static final String URL = "http://10.102.252.221/snap.jpeg";
    private Handler handler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateViewCamera");
        View view = inflater.inflate(R.layout.fragment_camera, container, false);

        this.image1 = view.findViewById(R.id.imageViewLive);
        this.image2 = view.findViewById(R.id.imageViewLoad);

        handler = new Handler();
        handler.postDelayed(imageUpdater, 0);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (handler != null) {
            handler.removeCallbacks(imageUpdater);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        if (handler != null) {
            handler.postDelayed(imageUpdater, 10);
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        if (handler != null) {
            handler.removeCallbacks(imageUpdater);
        }

    }


    Runnable imageUpdater = new Runnable() {
        @Override
        public void run() {
            if(bool){
                loadDisplayImage(image2, image1);
                bool = false;
            }else{
                loadDisplayImage(image1, image2);
                bool = true;
            }


            handler.postDelayed(this, 750);
        }
    };




    private void loadDisplayImage(ImageView i1, ImageView i2) {
        this.image1 = i1;
        this.image2 = i2;
        i1.setVisibility(View.VISIBLE);
        i2.setVisibility(View.GONE);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Picasso.with(getContext()).invalidate(URL); //recharge URL
                Picasso.with(getContext()).load(URL).into(CameraFragment.this.image2); //on remet la photo de l'URL dans i2
            }
        },250);

    }

}