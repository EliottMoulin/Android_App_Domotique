package com.example.domotique.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import com.example.domotique.Activities.MainActivity;
import com.example.domotique.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.content.Context.MODE_PRIVATE;


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

    private String ipGet;


    private TextView test;




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




        this.test = view.findViewById(R.id.test);

       this.switchAllPorts.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               if (b){
                   ControleFragment.this.state = "ON";
                   ControleFragment.this.imgPort1.setImageDrawable(getResources().getDrawable(R.drawable.led_up));
                   ControleFragment.this.imgPort2.setImageDrawable(getResources().getDrawable(R.drawable.led_up));
                   ControleFragment.this.imgPort3.setImageDrawable(getResources().getDrawable(R.drawable.led_up));
                   ControleFragment.this.imgPort4.setImageDrawable(getResources().getDrawable(R.drawable.led_up));
                   ControleFragment.this.switchport1.setChecked(true);
                   ControleFragment.this.switchport2.setChecked(true);
                   ControleFragment.this.switchport3.setChecked(true);
                   ControleFragment.this.switchport4.setChecked(true);
               }else{
                   ControleFragment.this.state = "OFF";
                   ControleFragment.this.imgPort1.setImageDrawable(getResources().getDrawable(R.drawable.led_down));
                   ControleFragment.this.imgPort2.setImageDrawable(getResources().getDrawable(R.drawable.led_down));
                   ControleFragment.this.imgPort3.setImageDrawable(getResources().getDrawable(R.drawable.led_down));
                   ControleFragment.this.imgPort4.setImageDrawable(getResources().getDrawable(R.drawable.led_down));
                   ControleFragment.this.switchport1.setChecked(false);
                   ControleFragment.this.switchport2.setChecked(false);
                   ControleFragment.this.switchport3.setChecked(false);
                   ControleFragment.this.switchport4.setChecked(false);
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
                if (ControleFragment.this.switchport1.isChecked() && ControleFragment.this.switchport2.isChecked() && ControleFragment.this.switchport3.isChecked() && ControleFragment.this.switchport4.isChecked()){
                    ControleFragment.this.switchAllPorts.setChecked(true);
                }else if(!ControleFragment.this.switchport1.isChecked() && !ControleFragment.this.switchport2.isChecked() && !ControleFragment.this.switchport3.isChecked() && !ControleFragment.this.switchport4.isChecked()){
                    ControleFragment.this.switchAllPorts.setChecked(false);
                }

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
                if (ControleFragment.this.switchport1.isChecked() && ControleFragment.this.switchport2.isChecked() && ControleFragment.this.switchport3.isChecked() && ControleFragment.this.switchport4.isChecked()){
                    ControleFragment.this.switchAllPorts.setChecked(true);
                }else if(!ControleFragment.this.switchport1.isChecked() && !ControleFragment.this.switchport2.isChecked() && !ControleFragment.this.switchport3.isChecked() && !ControleFragment.this.switchport4.isChecked()){
                    ControleFragment.this.switchAllPorts.setChecked(false);
                }
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
                if (ControleFragment.this.switchport1.isChecked() && ControleFragment.this.switchport2.isChecked() && ControleFragment.this.switchport3.isChecked() && ControleFragment.this.switchport4.isChecked()){
                    ControleFragment.this.switchAllPorts.setChecked(true);
                }else if(!ControleFragment.this.switchport1.isChecked() && !ControleFragment.this.switchport2.isChecked() && !ControleFragment.this.switchport3.isChecked() && !ControleFragment.this.switchport4.isChecked()){
                    ControleFragment.this.switchAllPorts.setChecked(false);
                }
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
                if (ControleFragment.this.switchport1.isChecked() && ControleFragment.this.switchport2.isChecked() && ControleFragment.this.switchport3.isChecked() && ControleFragment.this.switchport4.isChecked()){
                    ControleFragment.this.switchAllPorts.setChecked(true);
                }else if(!ControleFragment.this.switchport1.isChecked() && !ControleFragment.this.switchport2.isChecked() && !ControleFragment.this.switchport3.isChecked() && !ControleFragment.this.switchport4.isChecked()){
                    ControleFragment.this.switchAllPorts.setChecked(false);
                }
            }

        });


        OkHttpClient client = new OkHttpClient();
       // this.ipServ = "http://192.168.43.98";

    /*    Request request = new Request.Builder().url(ipServ).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                Log.e(TAG, "get fail",e);
            }



            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    final String myResponse = response.body().string();

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ControleFragment.this.test.setText(myResponse);
                            Log.i(TAG, "ça marche");
                            Log.i(TAG, myResponse);

                        }
                    });
                }
            }
        });

    */


       return view;

    }

    public void getIpByFile(){

        FileInputStream inputStream= null;
        try {
            inputStream = getActivity().openFileInput("ipAttribue");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder stringb= new StringBuilder();
        int content = 0;
        while (true){
            try {
                if (!((content=inputStream.read())!=-1)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.ipGet = String.valueOf(stringb.append((char)content));
        }

        ControleFragment.this.test.setText(ipGet);

    }






}
