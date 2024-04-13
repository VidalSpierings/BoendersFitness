package com.entecmedia.boendersfitness.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.entecmedia.boendersfitness.MyAppFunctionality;
import com.entecmedia.boendersfitness.MyAppFunctionalityInterface;
import com.entecmedia.boendersfitness.R;

public class EstablishmentFragment extends Fragment {

    private ConstraintLayout main_layout;

    private TextView
            rozemarijnstraatTextView,
            stationsstraatTextView;

    private TextView[] textViews;

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.content_establishment, container, false);

        findViewsById();

        textViews = new TextView[] {rozemarijnstraatTextView, stationsstraatTextView};

        initFragment();

        return rootView;
    }

    private void initFragment(){

        MyAppFunctionalityInterface appFunc = new MyAppFunctionality(getContext());

        appFunc.initEstablishmentFragment((AppCompatActivity) getActivity(), textViews, main_layout);

    }

    private void findViewsById(){

        main_layout = rootView.findViewById(R.id.main_layout);

        rozemarijnstraatTextView = rootView.findViewById(R.id.rozemarijnstraat_textView);

        stationsstraatTextView = rootView.findViewById(R.id.stationsstraatTextView);

    }

}
