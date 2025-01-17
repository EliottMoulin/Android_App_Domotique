package com.example.domotique.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.example.domotique.R;
import com.squareup.picasso.Picasso;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class StorageActivity extends AppCompatActivity {

    private static final String URL = "http://10.102.252.136/pictures/";
    private final static String TAG = StorageActivity.class.getName();
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;
    private ImageView image6;
    private ImageView image7;
    private ImageView image8;
    private ImageView image9;
    private ImageView image10;
    private ImageView image11;
    private ImageView image12;
    private ImageView image13;
    private ImageView image14;
    private ImageView image15;
    private ImageView image16;
    private ImageView image17;
    private ImageView image18;
    private ImageView image19;
    private ImageView image20;
    private String ipGet;
    private int test = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        getIpByFile();
        getSens();
        Log.d(TAG, "onCreate: " + ipGet);
        boolean ah = true;
        while (ah) {
            if (test != -1) {
                ah = false;
                if (this.test == 0) {
                    Log.w(TAG, "onCreate: if");
                    this.image1 = this.findViewById(R.id.imageView1);
                    this.image2 = this.findViewById(R.id.imageView2);
                    this.image3 = this.findViewById(R.id.imageView3);
                    this.image4 = this.findViewById(R.id.imageView4);
                    this.image5 = this.findViewById(R.id.imageView5);
                    this.image6 = this.findViewById(R.id.imageView6);
                    this.image7 = this.findViewById(R.id.imageView7);
                    this.image8 = this.findViewById(R.id.imageView8);
                    this.image9 = this.findViewById(R.id.imageView9);
                    this.image10 = this.findViewById(R.id.imageView10);

                    this.image11 = this.findViewById(R.id.imageView11);
                    this.image12 = this.findViewById(R.id.imageView12);
                    this.image13 = this.findViewById(R.id.imageView13);
                    this.image14 = this.findViewById(R.id.imageView14);
                    this.image15 = this.findViewById(R.id.imageView15);
                    this.image16 = this.findViewById(R.id.imageView16);
                    this.image17 = this.findViewById(R.id.imageView17);
                    this.image18 = this.findViewById(R.id.imageView18);
                    this.image19 = this.findViewById(R.id.imageView19);
                    this.image20 = this.findViewById(R.id.imageView20);
                } else {
                    Log.w(TAG, "onCreate: else");
                    this.image1 = this.findViewById(R.id.imageView11);
                    this.image2 = this.findViewById(R.id.imageView12);
                    this.image3 = this.findViewById(R.id.imageView13);
                    this.image4 = this.findViewById(R.id.imageView14);
                    this.image5 = this.findViewById(R.id.imageView15);
                    this.image6 = this.findViewById(R.id.imageView16);
                    this.image7 = this.findViewById(R.id.imageView17);
                    this.image8 = this.findViewById(R.id.imageView18);
                    this.image9 = this.findViewById(R.id.imageView19);
                    this.image10 = this.findViewById(R.id.imageView20);

                    this.image11 = this.findViewById(R.id.imageView1);
                    this.image12 = this.findViewById(R.id.imageView2);
                    this.image13 = this.findViewById(R.id.imageView3);
                    this.image14 = this.findViewById(R.id.imageView4);
                    this.image15 = this.findViewById(R.id.imageView5);
                    this.image16 = this.findViewById(R.id.imageView6);
                    this.image17 = this.findViewById(R.id.imageView7);
                    this.image18 = this.findViewById(R.id.imageView8);
                    this.image19 = this.findViewById(R.id.imageView9);
                    this.image20 = this.findViewById(R.id.imageView10);
                }
                getPicture1();
                getPicture2();
                getPicture3();
                getPicture4();
                getPicture5();
                getPicture6();
                getPicture7();
                getPicture8();
                getPicture9();
                getPicture10();
                getPicture11();
                getPicture12();
                getPicture13();
                getPicture14();
                getPicture15();
                getPicture16();
                getPicture17();
                getPicture18();
                getPicture19();
                getPicture20();
            }
        }


    }


    public void getPicture1() {

        Picasso.with(this).invalidate(URL + "snap1.jpeg");
        Picasso.with(this).load(URL + "snap1.jpeg").into(this.image1);
    }

    public void getPicture2() {

        Picasso.with(this).invalidate(URL + "snap2.jpeg");
        Picasso.with(this).load(URL + "snap2.jpeg").into(this.image2);
    }

    public void getPicture3() {

        Picasso.with(this).invalidate(URL + "snap3.jpeg");
        Picasso.with(this).load(URL + "snap3.jpeg").into(this.image3);
    }

    public void getPicture4() {

        Picasso.with(this).invalidate(URL + "snap4.jpeg");
        Picasso.with(this).load(URL + "snap4.jpeg").into(this.image4);
    }

    public void getPicture5() {

        Picasso.with(this).invalidate(URL + "snap5.jpeg");
        Picasso.with(this).load(URL + "snap5.jpeg").into(this.image5);
    }

    public void getPicture6() {

        Picasso.with(this).invalidate(URL + "snap6.jpeg");
        Picasso.with(this).load(URL + "snap6.jpeg").into(this.image6);
    }

    public void getPicture7() {

        Picasso.with(this).invalidate(URL + "snap7.jpeg");
        Picasso.with(this).load(URL + "snap7.jpeg").into(this.image7);
    }

    public void getPicture8() {

        Picasso.with(this).invalidate(URL + "snap8.jpeg");
        Picasso.with(this).load(URL + "snap8.jpeg").into(this.image8);
    }

    public void getPicture9() {

        Picasso.with(this).invalidate(URL + "snap9.jpeg");
        Picasso.with(this).load(URL + "snap9.jpeg").into(this.image9);
    }

    public void getPicture10() {

        Picasso.with(this).invalidate(URL + "snap10.jpeg");
        Picasso.with(this).load(URL + "snap10.jpeg").into(this.image10);
    }

    public void getPicture11() {

        Picasso.with(this).invalidate(URL + "snap11.jpeg");
        Picasso.with(this).load(URL + "snap11.jpeg").into(this.image11);
    }

    public void getPicture12() {

        Picasso.with(this).invalidate(URL + "snap12.jpeg");
        Picasso.with(this).load(URL + "snap12.jpeg").into(this.image12);
    }

    public void getPicture13() {

        Picasso.with(this).invalidate(URL + "snap13.jpeg");
        Picasso.with(this).load(URL + "snap13.jpeg").into(this.image13);
    }

    public void getPicture14() {

        Picasso.with(this).invalidate(URL + "snap14.jpeg");
        Picasso.with(this).load(URL + "snap14.jpeg").into(this.image14);
    }

    public void getPicture15() {

        Picasso.with(this).invalidate(URL + "snap15.jpeg");
        Picasso.with(this).load(URL + "snap15.jpeg").into(this.image15);
    }

    public void getPicture16() {

        Picasso.with(this).invalidate(URL + "snap16.jpeg");
        Picasso.with(this).load(URL + "snap16.jpeg").into(this.image16);
    }

    public void getPicture17() {

        Picasso.with(this).invalidate(URL + "snap17.jpeg");
        Picasso.with(this).load(URL + "snap17.jpeg").into(this.image17);
    }

    public void getPicture18() {

        Picasso.with(this).invalidate(URL + "snap18.jpeg");
        Picasso.with(this).load(URL + "snap18.jpeg").into(this.image18);
    }

    public void getPicture19() {

        Picasso.with(this).invalidate(URL + "snap19.jpeg");
        Picasso.with(this).load(URL + "snap19.jpeg").into(this.image19);
    }

    public void getPicture20() {

        Picasso.with(this).invalidate(URL + "snap20.jpeg");
        Picasso.with(this).load(URL + "snap20.jpeg").into(this.image20);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void getSens() {
        OkHttpClient client = new OkHttpClient();
        String url = "http://" + this.ipGet + "/getSens.php";

        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }


            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();

                    if (myResponse != null) {
                        if (myResponse.equals("1")) {
                            Log.w(TAG, "onResponse: IF ");
                            StorageActivity.this.test = 0;
                        } else {
                            Log.w(TAG, "onResponse: ELSE ");
                            StorageActivity.this.test = 1;
                        }

                        Log.w(TAG, "onResponse: " + myResponse);
                    }
                }
            }
        });

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

}
