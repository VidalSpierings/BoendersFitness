package com.entecmedia.boendersfitness.viewmodels.classes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.ViewModel;

import com.entecmedia.boendersfitness.R;
import com.entecmedia.boendersfitness.models.classes.CurrEstablishment;
import com.entecmedia.boendersfitness.ui.misc.NavigationDrawer;
import com.entecmedia.boendersfitness.viewmodels.interfaces.MainActivityViewModelInterface;

public class MainActivityViewModel extends ViewModel implements MainActivityViewModelInterface {

    private AppCompatActivity appCompatActivity;

    private final Context context;

    private Intent intent;

    public MainActivityViewModel (AppCompatActivity appCompatActivity, Context context){

        this.appCompatActivity = appCompatActivity;
        this.context = context;

    }

    /*

     * ----- Interface methods -----

     */

    @Override
    public void startNavigationDrawerActivity(View view) {

        CurrEstablishment currEstablishment = new CurrEstablishment(context);

        currEstablishment.setCurrEstablishment(view);

        startActivity(appCompatActivity);

    }

    /*

     * ----- Class methods -----

     */

    private void startActivity(AppCompatActivity appCompatActivity){

        this.appCompatActivity = appCompatActivity;

        intent = new Intent(appCompatActivity, NavigationDrawer.class);

        appCompatActivity.overridePendingTransition(
                R.anim.activity_transition_slide_up, R.anim.activity_transition_slide_down);

        startNextActivity();

    }

    private void startNextActivity(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {

            startActivityIfAboveJellyBean(intent);

            Log.d("startAcVersion: ", " Above Jelly Bean");

        } else {

            appCompatActivity.startActivity(intent);

            Log.d("startAcVersion: ", " Below Jelly Bean");

        }

    }

    @SuppressLint("NewApi")
    private void startActivityIfAboveJellyBean (Intent intent){

        Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(context,
                android.R.anim.fade_in, android.R.anim.fade_out).toBundle();

        appCompatActivity.startActivity(intent, bundle);

    }
}
