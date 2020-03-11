package com.example.domotique.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.domotique.Activities.StorageActivity;
import com.example.domotique.R;
import com.squareup.picasso.Picasso;


public class CameraFragment extends Fragment {
    private final static String TAG = CameraFragment.class.getName();

    public ImageView image1;
    private Button buttonGoTo;

    private static final String URL = "http://10.102.252.221/snap.jpeg";
    private Handler handler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateViewCamera");
        View view = inflater.inflate(R.layout.fragment_camera, container, false);

        this.image1 = view.findViewById(R.id.imageViewLive);
        this.buttonGoTo = view.findViewById(R.id.buttonGoToStorage);

        handler = new Handler();
        handler.postDelayed(imageUpdater, 0);

        this.buttonGoTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStorageActivity();
            }
        });


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

            loadDisplayImage();

            handler.postDelayed(this, 921);
        }
    };




    private void loadDisplayImage() {

                Picasso.with(getContext()).invalidate(URL); //recharge URL
                Picasso.with(getContext()).load(URL).fit().centerCrop()
                        .noPlaceholder()
                        .into(CameraFragment.this.image1);


    }

    private void startStorageActivity() {
        Log.d(TAG, "startStorageActivity");
        Intent intent = new Intent();
        intent.setClass(getActivity(), StorageActivity.class);
        super.startActivity(intent);

    }


}