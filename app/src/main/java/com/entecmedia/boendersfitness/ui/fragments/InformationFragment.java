package com.entecmedia.boendersfitness.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.entecmedia.boendersfitness.MyAppFunctionality;
import com.entecmedia.boendersfitness.MyAppFunctionalityInterface;
import com.entecmedia.boendersfitness.R;
import com.entecmedia.boendersfitness.viewmodels.classes.InformationFragmentViewModel;
import com.entecmedia.boendersfitness.viewmodels.interfaces.InformationFragmentViewModelInterface;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/**
 * Created by Vidal on 28-05-16.
 */
public class InformationFragment extends androidx.fragment.app.Fragment {

    private View rootView;

    private ConstraintLayout mainLayout;

    private ExtendedFloatingActionButton
            call_fab_button,
            email_fab_button,
            terms_of_service_button;

    private TextView prices_info_textView;

    private InformationFragmentViewModelInterface viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.content_information, container, false);
        findViewsById();

        initFragment();

        setOnClickListeners();

        return rootView;
    }

    private void findViewsById(){

        mainLayout = rootView.findViewById(R.id.main_layout);

        prices_info_textView = rootView.findViewById(R.id.prices_and_info_textView);

        call_fab_button = rootView.findViewById(R.id.call_fab_button);
        email_fab_button = rootView.findViewById(R.id.email_fab_button);
        terms_of_service_button = rootView.findViewById(R.id.terms_of_service_fab_button);

    }

    private void initFragment(){

        viewModel = new InformationFragmentViewModel((AppCompatActivity) getActivity());

        TextView[] textViews = new TextView[]{prices_info_textView};

        MyAppFunctionalityInterface appFunc = new MyAppFunctionality(getContext());

        appFunc.initEstablishmentFragment((AppCompatActivity) getActivity(), textViews, mainLayout);

    }

    private void setOnClickListeners(){

        call_fab_button.setOnClickListener(v -> viewModel.startActivityDialIntent());

        email_fab_button.setOnClickListener(v -> viewModel.startActivitySendToIntent());

        terms_of_service_button.setOnClickListener(v -> viewModel.openTermsOfServiceUrl());

    }


}
