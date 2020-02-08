package com.example.domotique.Fragments;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;
import com.example.domotique.R;

public class ControleFragment extends Fragment {

    private final static String TAG = ControleFragment.class.getName();

    private String state = null;
    private Switch switchAllPorts;
    private Switch switchport1;
    private Switch switchport2;
    private Switch switchport3;
    private Switch switchport4;

    private ImageView imgPort1;
    private ImageView imgPort2;
    private ImageView imgPort3;
    private ImageView imgPort4;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateViewControle");
        View view = inflater.inflate(R.layout.fragment_controle, container, false);

        this.switchAllPorts = view.findViewById(R.id.switchAll);
        this.switchport1 = view.findViewById(R.id.switchPort1);
        this.switchport2 = view.findViewById(R.id.switchPort2);
        this.switchport3 = view.findViewById(R.id.switchPort3);
        this.switchport4 = view.findViewById(R.id.switchPort4);

        this.imgPort1 = view.findViewById(R.id.imgLed1);
        this.imgPort2 = view.findViewById(R.id.imgLed2);
        this.imgPort3 = view.findViewById(R.id.imgLed3);
        this.imgPort4 = view.findViewById(R.id.imgLed4);

       this.switchAllPorts.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               if (b){
                   ControleFragment.this.state = "ON";
                   ControleFragment.this.imgPort1.setImageDrawable(getResources().getDrawable(R.drawable.led_up));
                   ControleFragment.this.imgPort2.setImageDrawable(getResources().getDrawable(R.drawable.led_up));
                   ControleFragment.this.imgPort3.setImageDrawable(getResources().getDrawable(R.drawable.led_up));
                   ControleFragment.this.imgPort4.setImageDrawable(getResources().getDrawable(R.drawable.led_up));
               }else{
                   ControleFragment.this.state = "OFF";
                   ControleFragment.this.imgPort1.setImageDrawable(getResources().getDrawable(R.drawable.led_down));
                   ControleFragment.this.imgPort2.setImageDrawable(getResources().getDrawable(R.drawable.led_down));
                   ControleFragment.this.imgPort3.setImageDrawable(getResources().getDrawable(R.drawable.led_down));
                   ControleFragment.this.imgPort4.setImageDrawable(getResources().getDrawable(R.drawable.led_down));
               }
               Toast.makeText(getActivity(),ControleFragment.this.state,Toast.LENGTH_SHORT).show();

           }

       });

        this.switchport1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    ControleFragment.this.state = "ON";
                    ControleFragment.this.imgPort1.setImageDrawable(getResources().getDrawable(R.drawable.led_up));
                }else{
                    ControleFragment.this.state = "OFF";
                    ControleFragment.this.imgPort1.setImageDrawable(getResources().getDrawable(R.drawable.led_down));
                }
                Toast.makeText(getActivity(),ControleFragment.this.state,Toast.LENGTH_SHORT).show();

            }

        });

        this.switchport2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    ControleFragment.this.state = "ON";
                    ControleFragment.this.imgPort2.setImageDrawable(getResources().getDrawable(R.drawable.led_up));
                }else{
                    ControleFragment.this.state = "OFF";
                    ControleFragment.this.imgPort2.setImageDrawable(getResources().getDrawable(R.drawable.led_down));
                }
                Toast.makeText(getActivity(),ControleFragment.this.state,Toast.LENGTH_SHORT).show();

            }

        });
        this.switchport3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    ControleFragment.this.state = "ON";
                    ControleFragment.this.imgPort3.setImageDrawable(getResources().getDrawable(R.drawable.led_up));
                }else{
                    ControleFragment.this.state = "OFF";
                    ControleFragment.this.imgPort3.setImageDrawable(getResources().getDrawable(R.drawable.led_down));
                }
                Toast.makeText(getActivity(),ControleFragment.this.state,Toast.LENGTH_SHORT).show();

            }

        });
        this.switchport4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    ControleFragment.this.state = "ON";
                    ControleFragment.this.imgPort4.setImageDrawable(getResources().getDrawable(R.drawable.led_up));
                }else{
                    ControleFragment.this.state = "OFF";
                    ControleFragment.this.imgPort4.setImageDrawable(getResources().getDrawable(R.drawable.led_down));
                }
                Toast.makeText(getActivity(),ControleFragment.this.state,Toast.LENGTH_SHORT).show();

            }

        });




       return view;

    }



}
