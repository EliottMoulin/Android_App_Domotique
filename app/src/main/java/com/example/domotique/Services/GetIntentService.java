package com.example.domotique.Services;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.example.domotique.Activities.LoginActivity;
import com.example.domotique.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;




public class GetIntentService extends IntentService {

    private final static String TAG = GetIntentService.class.getName();
    public static final String CHANNEL_ID_2 = "channel2";
    private String ipGet;
    private NotificationManagerCompat notificationManager;
    public GetIntentService() {
        super("GetIntentService");
    }


    @Override
    public void onCreate() {
        super.onCreate();
        getIpByFile();
        createNotificationChannels();
        notificationManager = NotificationManagerCompat.from(this);
        createNotificationChannels();


        myHandler = new Handler();
        myHandler.postDelayed(myRunnable, 1);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private Handler myHandler;
    private Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG, "run: TIMER GET ALARME");
            getEtatAlarme();

            myHandler.postDelayed(this, 2021);
        }
    };



    @Override
    protected void onHandleIntent(Intent intent) {



    }

    public void getIpByFile() {

        FileInputStream inputStream = null;
        try {
            inputStream = openFileInput("ipAttribue");
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


    }

    public void getEtatAlarme(){
        OkHttpClient client = new OkHttpClient();
        String url = "http://" + this.ipGet + "/getEtatAlarme.php";

        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "get fail", e);
            }


            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();
                    Log.d(TAG, "onResponse: "+ myResponse);

                    if (myResponse != null) {
                        if (myResponse.equals("1") ) {
                            Log.d(TAG, "onResponse: oui");
                            sendNotif();
                        }

                    }
                }
            }
        });

    }

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_ID_2,
                    "Channel 2",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is channel 2");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);

        }

    }

    public void sendNotif(){

        Intent resultIntent = new Intent(this, LoginActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 1, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID_2)
                .setSmallIcon(R.drawable.ic_intrusion_foreground)
                .setContentTitle("Alerte Intrusion !!")
                .setContentText("Intrusion détéctée dans votre maison !!")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setAutoCancel(true)
                .setContentIntent(resultPendingIntent)
                .build();
        notificationManager.notify(1, notification);
    }
}
