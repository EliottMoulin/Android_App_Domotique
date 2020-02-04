package com.example.domotique;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText password;
    private Button validate;

    private final static String TAG = LoginActivity.class.getName();

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
                if(number.length() < 4)
                {
                    LoginActivity.this.validate.setEnabled(false);
                }
            }
        });


        this.validate = super.findViewById(R.id.buttonPass);
        this.validate.setEnabled(false);

    }

    @Override
    protected void onStart()
    {
        Log.i(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onResume()
    {
        Log.i(TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        Log.i(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop()
    {
        Log.i(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onRestart()
    {
        Log.i(TAG, "onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy()
    {
        Log.i(TAG, "onDestroy");
        super.onDestroy();
    }

    private void startMainActivity(View view){
        Log.d(TAG,"startMainActivity");
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);


        super.startActivity(intent);
        super.finish();
    }

    public void validatePassword(View view){

        Log.d(TAG,"validatePassword");

        //Toast.makeText(this,this.password.getText(),Toast.LENGTH_LONG).show();
        String pass = "2121";
        if ( this.password.getText().toString().equals(pass)){
            Toast.makeText(this,"Validé !",Toast.LENGTH_SHORT).show();
            startMainActivity(view);
        }else {
            this.password.setError("Password incorect !");
        }



    }
}
