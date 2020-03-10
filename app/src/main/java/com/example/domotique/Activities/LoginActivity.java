package com.example.domotique.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.domotique.R;
import com.example.domotique.Services.GetIntentService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    private EditText password;
    private Button validate;

    private final static String TAG = LoginActivity.class.getName();
   // public static final String CHANNEL_ID_1 = "channel1";
  //  private NotificationManagerCompat notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.password = super.findViewById(R.id.numberPass);
        this.password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                LoginActivity.this.password.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                LoginActivity.this.validate.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable number) {
                if (number.length() < 4) {
                    LoginActivity.this.validate.setEnabled(false);
                }
            }
        });


        this.validate = super.findViewById(R.id.buttonPass);
        this.validate.setEnabled(false);

        /* --- CREATION DU FICHIER DE STOCKAGE DE IP SERVER --- */

        FileInputStream inputStream = null;
        FileInputStream inputStream1 = null;
        try {
            inputStream = this.openFileInput("ipAttribue");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            inputStream1 = this.openFileInput("stateConnexion");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        if (inputStream == null) {
            FileOutputStream output;
            try {
                output = openFileOutput("ipAttribue", MODE_PRIVATE);
                if (output != null)
                    output.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (inputStream1 == null) {
            FileOutputStream output1;
            try {
                output1 = openFileOutput("stateConnexion", MODE_PRIVATE);
                if (output1 != null)
                    output1.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        // 1ere notif
    /*    notificationManager = NotificationManagerCompat.from(this);
        createNotificationChannels();*/



        Intent msgIntent = new Intent(this, GetIntentService.class);
        startService(msgIntent);
    }



    @Override
    protected void onStart() {
        Log.i(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, "onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy");
        super.onDestroy();
    }

    private void startMainActivity(View view) {
        Log.d(TAG, "startMainActivity");
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);


        super.startActivity(intent);
        super.finish();
    }

    public void validatePassword(View view) {

        Log.d(TAG, "validatePassword");

        //Toast.makeText(this,this.password.getText(),Toast.LENGTH_LONG).show();
        String pass = "2121";
        if (this.password.getText().toString().equals(pass)) {
            Toast.makeText(this, "Bienvenue !", Toast.LENGTH_SHORT).show();
            startMainActivity(view);
         //   sendOnChannel1(view);
        } else {
            this.password.setText("");
            this.password.setError("Password incorect !");
        }

    }

    /*private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_ID_1,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is channel 1");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);

        }

    }

    public void sendOnChannel1(View v){
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID_1)
                .setSmallIcon(R.drawable.ic_dialog_close_dark)
                .setContentTitle("oui")
                .setContentText("ouiouiouioui")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManager.notify(1, notification);
    }*/






}
