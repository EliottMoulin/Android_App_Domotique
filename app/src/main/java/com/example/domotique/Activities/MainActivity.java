package com.example.domotique.Activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.domotique.Fragments.CameraFragment;
import com.example.domotique.Fragments.ControleFragment;
import com.example.domotique.R;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity{
    private final static String TAG = MainActivity.class.getName();

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);

        viewPager =  findViewById(R.id.viewpager);
        setViewPager(viewPager);

        tabLayout = findViewById(R.id.mytabs);
        tabLayout.setupWithViewPager(viewPager);

        


        if (!isConnected()) {
            snackInternet();
            return;
        }


    }


    /* <-- VERIF CONNECTION -->  */

    private boolean isConnected() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
    private void snackInternet() {
        final Snackbar snackbar = Snackbar
                .make(findViewById(R.id.mainLayout), "No Internet Connectivity", Snackbar.LENGTH_INDEFINITE)
                .setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (isConnected()) {
                            Snackbar snackbar1 = Snackbar.make(view, "Connected to the Internet!", Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                            return;
                        }else{
                            snackInternet();
                        }

                    }
                });

        snackbar.show();
    }

    /* <-- VIEW MENU ITEM & DIALOG POPUP -->  */


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(final MenuItem item) {

        switch (item.getItemId()) {

            case R.id.config_server:


                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_config_server, null);
                final EditText ip = mView.findViewById(R.id.inputIp);
                final Button validate = mView.findViewById(R.id.validateIp);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                ip.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        ip.setError(null);
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        validate.setEnabled(true);
                    }

                    @Override
                    public void afterTextChanged(Editable text) {

                        if(text.length() == 0)
                        {
                            validate.setEnabled(false);
                        }

                    }
                });

                validate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        if(Patterns.IP_ADDRESS.matcher(ip.getText()).matches()) {
                            String ipSet = ip.getText().toString();


                            /* --- STOCKAGE DANS FILE --- */

                            FileOutputStream output = null;
                            try {
                                output = openFileOutput("ipAttribue", MODE_PRIVATE);
                                output.write(ipSet.getBytes());
                                if(output != null)
                                    output.close();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            Snackbar.make(findViewById(R.id.mainLayout), "Connecté à "+ipSet , Snackbar.LENGTH_LONG).show();
                            dialog.dismiss();
                        }
                        else {
                            ip.setError(MainActivity.super.getString(R.string.ip_not_valid));
                        }


                    }
                });

                return true;

        }
        return super.onOptionsItemSelected(item);
    }

   /* <-- VIEW PAGE ONGLETS -->  */

    private void setViewPager(ViewPager viewPager) {
            Log.i(TAG, "setViewPager");
            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
            adapter.addFragment(new ControleFragment(), "Node Control");
            adapter.addFragment(new CameraFragment(), "Camera View");
            viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }
}