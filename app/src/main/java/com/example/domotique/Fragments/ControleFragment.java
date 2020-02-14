package com.example.domotique.Fragments;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import com.example.domotique.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


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
    private Snackbar barerror;


    @Override
    public void onPause() {
        super.onPause();
        if (myHandler != null) {
            myHandler.removeCallbacks(myRunnable);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        setHasOptionsMenu(true);
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


        myHandler = new Handler();
        myHandler.postDelayed(myRunnable, 500);


        this.switchAllPorts.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ControleFragment.this.state = "ON";
                    ControleFragment.this.imgPort1.setImageDrawable(getResources().getDrawable(R.drawable.led_up));
                    ControleFragment.this.imgPort2.setImageDrawable(getResources().getDrawable(R.drawable.led_up));
                    ControleFragment.this.imgPort3.setImageDrawable(getResources().getDrawable(R.drawable.led_up));
                    ControleFragment.this.imgPort4.setImageDrawable(getResources().getDrawable(R.drawable.led_up));
                    ControleFragment.this.switchport1.setChecked(true);
                    ControleFragment.this.switchport2.setChecked(true);
                    ControleFragment.this.switchport3.setChecked(true);
                    ControleFragment.this.switchport4.setChecked(true);
                    String val = "2";
                    setChangeAllEtats(val);
                } else {
                    ControleFragment.this.state = "OFF";
                    ControleFragment.this.imgPort1.setImageDrawable(getResources().getDrawable(R.drawable.led_down));
                    ControleFragment.this.imgPort2.setImageDrawable(getResources().getDrawable(R.drawable.led_down));
                    ControleFragment.this.imgPort3.setImageDrawable(getResources().getDrawable(R.drawable.led_down));
                    ControleFragment.this.imgPort4.setImageDrawable(getResources().getDrawable(R.drawable.led_down));
                    ControleFragment.this.switchport1.setChecked(false);
                    ControleFragment.this.switchport2.setChecked(false);
                    ControleFragment.this.switchport3.setChecked(false);
                    ControleFragment.this.switchport4.setChecked(false);
                    String val = "1";
                    setChangeAllEtats(val);
                }
                Toast.makeText(getActivity(), ControleFragment.this.state, Toast.LENGTH_SHORT).show();

            }

        });
        this.switchport1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = "1";
                setModifyEtat(val);
            }
        });


        this.switchport1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ControleFragment.this.state = "ON";
                    ControleFragment.this.imgPort1.setImageDrawable(getResources().getDrawable(R.drawable.led_up));
                } else {
                    ControleFragment.this.state = "OFF";
                    ControleFragment.this.imgPort1.setImageDrawable(getResources().getDrawable(R.drawable.led_down));
                }
                Toast.makeText(getActivity(), ControleFragment.this.state, Toast.LENGTH_SHORT).show();


            }

        });
        this.switchport2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = "2";
                setModifyEtat(val);
            }
        });
        this.switchport2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                String val = "2";
                if (b) {
                    ControleFragment.this.state = "ON";
                    ControleFragment.this.imgPort2.setImageDrawable(getResources().getDrawable(R.drawable.led_up));
                } else {
                    ControleFragment.this.state = "OFF";
                    ControleFragment.this.imgPort2.setImageDrawable(getResources().getDrawable(R.drawable.led_down));
                }
                Toast.makeText(getActivity(), ControleFragment.this.state, Toast.LENGTH_SHORT).show();

            }

        });
        this.switchport3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = "3";
                setModifyEtat(val);
            }
        });
        this.switchport3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                String val = "3";
                if (b) {
                    ControleFragment.this.state = "ON";
                    ControleFragment.this.imgPort3.setImageDrawable(getResources().getDrawable(R.drawable.led_up));
                } else {
                    ControleFragment.this.state = "OFF";
                    ControleFragment.this.imgPort3.setImageDrawable(getResources().getDrawable(R.drawable.led_down));
                }
                Toast.makeText(getActivity(), ControleFragment.this.state, Toast.LENGTH_SHORT).show();

            }

        });

        this.switchport4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = "4";
                setModifyEtat(val);
            }
        });
        this.switchport4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                String val = "4";
                if (b) {
                    ControleFragment.this.state = "ON";
                    ControleFragment.this.imgPort4.setImageDrawable(getResources().getDrawable(R.drawable.led_up));
                } else {
                    ControleFragment.this.state = "OFF";
                    ControleFragment.this.imgPort4.setImageDrawable(getResources().getDrawable(R.drawable.led_down));
                }
                Toast.makeText(getActivity(), ControleFragment.this.state, Toast.LENGTH_SHORT).show();

            }

        });


        return view;

    }

    public void setAllEtatsInApp(String allEtats) {

        String etats = allEtats;

        switch (etats) {
            case "0":
                ControleFragment.this.switchAllPorts.setChecked(false);
                break;
            case "1":
                ControleFragment.this.switchport1.setChecked(true);
                break;

            case "2":
                ControleFragment.this.switchport2.setChecked(true);
                break;
            case "3":
                ControleFragment.this.switchport1.setChecked(true);
                ControleFragment.this.switchport2.setChecked(true);
                break;

            case "4":
                ControleFragment.this.switchport3.setChecked(true);
                break;
            case "5":
                ControleFragment.this.switchport1.setChecked(true);
                ControleFragment.this.switchport3.setChecked(true);
                break;

            case "6":
                ControleFragment.this.switchport2.setChecked(true);
                ControleFragment.this.switchport3.setChecked(true);
                break;
            case "7":
                ControleFragment.this.switchport1.setChecked(true);
                ControleFragment.this.switchport2.setChecked(true);
                ControleFragment.this.switchport3.setChecked(true);
                break;

            case "8":
                ControleFragment.this.switchport4.setChecked(true);
                break;
            case "9":
                ControleFragment.this.switchport1.setChecked(true);
                ControleFragment.this.switchport4.setChecked(true);
                break;
            case "10":
                ControleFragment.this.switchport2.setChecked(true);
                ControleFragment.this.switchport4.setChecked(true);
                break;
            case "11":
                ControleFragment.this.switchport1.setChecked(true);
                ControleFragment.this.switchport2.setChecked(true);
                ControleFragment.this.switchport4.setChecked(true);
                break;
            case "12":
                ControleFragment.this.switchport3.setChecked(true);
                ControleFragment.this.switchport4.setChecked(true);
                break;
            case "13":
                ControleFragment.this.switchport1.setChecked(true);
                ControleFragment.this.switchport3.setChecked(true);
                ControleFragment.this.switchport4.setChecked(true);
                break;
            case "14":
                ControleFragment.this.switchport2.setChecked(true);
                ControleFragment.this.switchport3.setChecked(true);
                ControleFragment.this.switchport4.setChecked(true);
                break;
            case "15":
                ControleFragment.this.switchAllPorts.setChecked(true);
                break;
            default:



        }


    }

    /* --- PROCESSUS TIMER --- */

    private Handler myHandler;
    private Runnable myRunnable = new Runnable() {
        @Override
        public void run() {

            getIpByFile();
            getEtatPort();

            myHandler.postDelayed(this, 5000);
        }
    };


    public void getIpByFile() {

        FileInputStream inputStream = null;
        try {
            inputStream = getActivity().openFileInput("ipAttribue");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder stringb = new StringBuilder();
        int content = 0;
        while (true) {
            try {
                if (!((content = inputStream.read()) != -1)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.ipGet = String.valueOf(stringb.append((char) content));
        }

        ControleFragment.this.test.setText(ipGet);

    }


    public void getEtatPort() {
        OkHttpClient client = new OkHttpClient();
        String url = "http://" + this.ipGet + "/getPorts.php";

        Request request = new Request.Builder().url(url).build();
        
        final boolean[] test = {false};
        
        
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "get fail", e);
                setErrorServer();
            }


            @Override
            public void onResponse(final Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            int i = 0;
                            do {

                                if (!myResponse.equals(Integer.toString(i))){
                                     test[0] = false;

                                }else{
                                    test[0] = true;
                                /*    MenuItem item = getActivity().findViewById(R.id.config_server);
                                    item.setIcon(R.drawable.ic_wifi_toolbar_foreground); */
                                    setAllEtatsInApp(myResponse);
                                    Log.i(TAG, "getEtatPort, connecté au serveur :  " + ControleFragment.this.ipGet);
                                    Log.i(TAG, myResponse);
                                }
                                i++;

                            }while (i <= 15 && test[0] == false );

                            if (!test[0]){
                                setErrorServer();
                                ControleFragment.this.switchAllPorts.setChecked(false);
                            }
                        }
                    });
                }
            }
        });
    }


        public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
            // Do something that differs the Activity's menu here
            super.onCreateOptionsMenu(menu, inflater);
        }

        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.config_server:
                    item.setIcon(R.drawable.ic_wifi_toolbar_foreground);
                    return false;
            }

            return false;
        }



    private void setErrorServer() {

        this.barerror.make(getActivity().findViewById(R.id.mainLayout), "Verify ip Server ...", Snackbar.LENGTH_INDEFINITE).show();
    }


    public void setChangeAllEtats(String arg){
        OkHttpClient client = new OkHttpClient();
        String url = "http://" + this.ipGet + "/setAllPorts.php?value=" + arg;

        Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                Log.e(TAG, "get fail", e);
            }


            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            setAllEtatsInApp(myResponse);
                            Log.i(TAG, "setAllPorts, connecté au serveur :  " + ControleFragment.this.ipGet);
                            Log.i(TAG, myResponse);

                        }
                    });
                }
            }
        });
    }

    public void setModifyEtat(String arg){
        OkHttpClient client = new OkHttpClient();
        String url = "http://" + this.ipGet + "/setModifyEtat.php?value=" + arg;

        Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                Log.e(TAG, "get fail", e);
            }


            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            setAllEtatsInApp(myResponse);
                            Log.i(TAG, "setModifyEtat, connecté au serveur :  " + ControleFragment.this.ipGet);
                            Log.i(TAG, myResponse);

                        }
                    });
                }
            }
        });
    }


}
