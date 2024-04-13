package com.entecmedia.boendersfitness;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public interface MyAppFunctionalityInterface {

    void initLayoutAccrToCurrEstablishment(int currEstablishmentResourceId);

    void initLayoutRSfunctionality();

    void initLayoutSSfunctionality();

    void initLayoutIllegalValue(int currEstablishment);

    void initEstablishmentActivity(AppCompatActivity appCompatActivity, TextView[] textViews, View main_layout);

    void initEstablishmentFragment(AppCompatActivity appCompatActivity, TextView[] textViews, View main_layout);

    void initMiscActivity(AppCompatActivity appCompatActivity);

    void showErrorAccrToAndroidVersion(String message);
}
