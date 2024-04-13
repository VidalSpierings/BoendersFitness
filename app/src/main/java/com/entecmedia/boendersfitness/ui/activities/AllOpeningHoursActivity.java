package com.entecmedia.boendersfitness.ui.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.entecmedia.boendersfitness.MyAppFunctionality;
import com.entecmedia.boendersfitness.MyAppFunctionalityInterface;
import com.entecmedia.boendersfitness.R;

/**
 * Created by inter on 21-7-2016.
 */
public class AllOpeningHoursActivity extends AppCompatActivity {

    private TextView[] textViews;

    private ScrollView main_layout;

    private TextView
            allOpeningHoursTextView,

            fifthOfDecemberTextView,
            december24thTextView,
            christmasTextView,
            kingsDayTextView,
            ascensionDayTextView,
            pentecostTextView,
            carnivalTextView,
            newYearsEveDayTextView,

            specialOpeningTimesTextView,

            december24thTimesTextView,
            fifthOfDecemberTimesTextView,
            christmasTimesTextView,
            kingsDayTimesTextView,
            ascensionTimesTextView,
            pentecostTimesTextView,
            carnivalTimesTextView,
            newYearsEveDayTimesTextView;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_opening_hours);

        findViewsById();

        addTextViewsToArray();

        initActivity();

    }

    private void findViewsById(){

        main_layout = findViewById(R.id.main_layout);

        allOpeningHoursTextView = findViewById(R.id.allOpeningHoursTextView);

        fifthOfDecemberTextView = findViewById(R.id.fifthOfDecemberTextView);
        december24thTextView = findViewById(R.id.december24thTextView);
        christmasTextView = findViewById(R.id.christmasTextView);
        kingsDayTextView = findViewById(R.id.kingsDayTextView);
        ascensionDayTextView = findViewById(R.id.ascensionDayTextView);
        pentecostTextView = findViewById(R.id.pentecostTextView);
        carnivalTextView = findViewById(R.id.carnivalTextView);
        newYearsEveDayTextView = findViewById(R.id.newYearsEveDayTextView);

        specialOpeningTimesTextView = findViewById(R.id.specialOpeningTimesTextView);

        december24thTimesTextView = findViewById(R.id.december24thTimesTextView);
        fifthOfDecemberTimesTextView = findViewById(R.id.fifthOfDecemberTimesTextView);
        christmasTimesTextView = findViewById(R.id.christmasTimesTextView);
        kingsDayTimesTextView = findViewById(R.id.kingsDayTimesTextView);
        ascensionTimesTextView = findViewById(R.id.ascensionDayTimesTextView);
        pentecostTimesTextView = findViewById(R.id.pentecostTimesTextView);
        carnivalTimesTextView = findViewById(R.id.carnivalTimesTextView);
        newYearsEveDayTimesTextView = findViewById(R.id.newYearsEveDayTimesTextView);

    }

    private void addTextViewsToArray(){

        textViews = new TextView[]{

                allOpeningHoursTextView,
                fifthOfDecemberTextView,
                december24thTextView,
                christmasTextView,
                kingsDayTextView,
                ascensionDayTextView,
                pentecostTextView,
                carnivalTextView,
                newYearsEveDayTextView,
                specialOpeningTimesTextView,
                december24thTimesTextView,
                fifthOfDecemberTimesTextView,
                christmasTimesTextView,
                kingsDayTimesTextView,
                ascensionTimesTextView,
                pentecostTimesTextView,
                carnivalTimesTextView,
                newYearsEveDayTimesTextView
        };

        // TextViews added to array so can go through setTextColor() forloop in MyAppFunc class

    }

    private void initActivity(){

        MyAppFunctionalityInterface appFunc = new MyAppFunctionality(this);

        appFunc.initEstablishmentActivity(this, textViews, main_layout);

    }

}
