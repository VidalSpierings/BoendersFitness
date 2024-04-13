package com.entecmedia.boendersfitness.viewmodels.classes;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import com.entecmedia.boendersfitness.MyAppFunctionality;
import com.entecmedia.boendersfitness.MyAppFunctionalityInterface;
import com.entecmedia.boendersfitness.R;
import com.entecmedia.boendersfitness.viewmodels.interfaces.InformationFragmentViewModelInterface;

public class InformationFragmentViewModel extends ViewModel implements InformationFragmentViewModelInterface {

    private final AppCompatActivity appCompatActivity;

    private Intent intent;

    public InformationFragmentViewModel (AppCompatActivity appCompatActivity){

        this.appCompatActivity = appCompatActivity;

    }

    /*

     * ----- Interface methods -----

     */

    @Override
    public void startActivityDialIntent(){

        intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + appCompatActivity.getString(R.string.phone_number)));

        appCompatActivity.startActivity(intent);

        // opens users' phone/call application with phone number already entered in dial
        // (intent does not call the number by itself and waits on user to press the dial button)

        Log.i("opened intent: ", "dial");

    }

    @Override
    public void startActivitySendToIntent(){

        intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));

        intent.putExtra(Intent.EXTRA_EMAIL,
                new String[]{appCompatActivity.getString(R.string.email)});

        appCompatActivity.startActivity(intent);

        // opens users' e-mail app and creates a new blank e-mail
        // with the Boender e-mail address as the recipient

        Log.i("opened intent: ", "send e-mail");

    }

    @Override
    public void openTermsOfServiceUrl() {

        initIntent();

        openUrlIfConnectedToInternet();

    }

    private void initIntent(){

        Uri uri = Uri.parse(appCompatActivity.getString(R.string.terms_and_conditions_url));

        intent = new Intent(Intent.ACTION_VIEW);

        intent.setData(uri);

        // opens URL containing Boender Fitness terms of service PDF file

    }

    private void openUrlIfConnectedToInternet(){

        ConnectivityManager connectivityManager = (ConnectivityManager) appCompatActivity.getSystemService(Context.CONNECTIVITY_SERVICE);

        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)
        {
            appCompatActivity.startActivity(intent);

            Log.i("opened intent: ", "open terms of service");

        }
        else
        {

            showError();

        }

    }

    private void showError(){

        MyAppFunctionalityInterface appFunc = new MyAppFunctionality(appCompatActivity.getApplicationContext());

        Log.d("opened intent: ", " (failed to) open terms of service");

        appFunc.showErrorAccrToAndroidVersion(appCompatActivity.getString(R.string.no_internet_string));

    }

}
