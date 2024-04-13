package com.entecmedia.boendersfitness.ui.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.entecmedia.boendersfitness.MyAppFunctionality;
import com.entecmedia.boendersfitness.MyAppFunctionalityInterface;
import com.entecmedia.boendersfitness.R;
import com.entecmedia.boendersfitness.viewmodels.classes.OpeningHoursActivityViewModel;
import com.entecmedia.boendersfitness.viewmodels.interfaces.OpeningHoursActivityViewModelInterface;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/**
 * Created by Vidal on 16-07-16.
 */
public class OpeningHoursActivity extends AppCompatActivity {

    private TextView
            todays_openinghours_textView,
            tomorrows_openinghours_textView,
            today_textView,
            tomorrow_textView,
            alteration_textView;

    private ExtendedFloatingActionButton
            all_openinghours_fab_button;

    private RelativeLayout main_layout;

    private TextView[] textViews;

    private OpeningHoursActivityViewModelInterface viewModel;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.opening_hours_layout);

        findViewsById();

        addTextViewsToArray();

        initActivity();

        viewModel.setOpeningTimes(todays_openinghours_textView, tomorrows_openinghours_textView);

        all_openinghours_fab_button.setOnClickListener(
                view -> viewModel.openAllOpeningHoursActivity(this));

    }

    private void findViewsById(){

        todays_openinghours_textView = findViewById(R.id.todays_openinghours_textView);
        tomorrows_openinghours_textView = findViewById(R.id.tomorrows_openinghours_textView);
        today_textView = findViewById(R.id.today_textView);
        tomorrow_textView = findViewById(R.id.tomorrow_textView);
        alteration_textView = findViewById(R.id.alteration_textView);

        all_openinghours_fab_button = findViewById(R.id.all_openinghours_fab_button);

        main_layout = findViewById(R.id.main_layout);

    }

    private void addTextViewsToArray(){

        textViews = new TextView[]{

                todays_openinghours_textView,
                tomorrows_openinghours_textView,
                today_textView,
                tomorrow_textView,
                alteration_textView

        };

    }

    private void initActivity(){

        viewModel = new OpeningHoursActivityViewModel(getBaseContext());

        MyAppFunctionalityInterface appFunc = new MyAppFunctionality(getBaseContext());

        String s = textViews[0].getText().toString();

        appFunc.initEstablishmentActivity(this, textViews, main_layout);

    }
}
