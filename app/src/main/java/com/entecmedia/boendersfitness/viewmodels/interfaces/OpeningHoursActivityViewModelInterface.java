package com.entecmedia.boendersfitness.viewmodels.interfaces;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public interface OpeningHoursActivityViewModelInterface {


    void setOpeningTimes(TextView todays_openinghours_textView, TextView tomorrows_openinghours_textView);

    void openAllOpeningHoursActivity(AppCompatActivity appCompatActivity);
}
