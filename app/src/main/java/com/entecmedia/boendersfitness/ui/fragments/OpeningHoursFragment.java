package com.entecmedia.boendersfitness.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import com.entecmedia.boendersfitness.MyAppFunctionality;
import com.entecmedia.boendersfitness.MyAppFunctionalityInterface;
import com.entecmedia.boendersfitness.R;
import com.entecmedia.boendersfitness.ui.activities.AllOpeningHoursActivity;

/**
 * Created by Vidal on 10-05-16.
 */
public class OpeningHoursFragment extends Fragment {

    private TextView
            today_textView,
            todays_openinghours_textView,
            tomorrow_textView,
            tomorrows_openinghours_textView,
            alteration_textView;

    private Button
            all_opening_hours_fab_button;

    private RelativeLayout main_layout;

    private TextView[] textViews;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.opening_hours_layout, container, false);

        findViewsById(rootView);

        addTextViewsToArray();

        initFragment();

        all_opening_hours_fab_button.setOnClickListener(v -> {

            openAllOpeningHoursActivity();

        });

        return rootView;
    }

    private void openAllOpeningHoursActivity(){

        Intent intent = new Intent(getActivity(), AllOpeningHoursActivity.class);

        startActivity(intent);

    }

    private void findViewsById(View rootView){

        main_layout = rootView.findViewById(R.id.main_layout);

        alteration_textView = rootView.findViewById(R.id.alteration_textView);
        today_textView = rootView.findViewById(R.id.today_textView);
        todays_openinghours_textView = rootView.findViewById(R.id.todays_openinghours_textView);
        tomorrow_textView = rootView.findViewById(R.id.tomorrow_textView);
        tomorrows_openinghours_textView = rootView.findViewById(R.id.tomorrows_openinghours_textView);

        all_opening_hours_fab_button = rootView.findViewById(R.id.all_openinghours_fab_button);

    }

    private void addTextViewsToArray(){

        textViews = new TextView[]{
                today_textView,
                todays_openinghours_textView,
                tomorrow_textView,
                tomorrows_openinghours_textView,
                alteration_textView

    };

        // TextViews added to array so color can be applied in for loop from MyAppFunctionality lass

}

private void initFragment(){

    MyAppFunctionalityInterface appFunc = new MyAppFunctionality(getContext());

    appFunc.initEstablishmentFragment((AppCompatActivity) getActivity(), textViews, main_layout);

}

}
