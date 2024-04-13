package com.entecmedia.boendersfitness.ui.fragments;

import android.os.Bundle;

import com.entecmedia.boendersfitness.MyAppFunctionality;
import com.entecmedia.boendersfitness.MyAppFunctionalityInterface;
import com.entecmedia.boendersfitness.R;
import com.entecmedia.boendersfitness.viewmodels.classes.HomeFragmentViewModel;
import com.entecmedia.boendersfitness.viewmodels.interfaces.HomeFragmentViewModelInterface;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;


public class HomeFragment extends Fragment {

    private TextView
            welcome_textView,
            description_textView;

    private ConstraintLayout mainLayout;

    private FloatingActionButton floatingActionButton;

    private HomeFragmentViewModelInterface viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.content_home, container, false);

        findViewsById(rootView);

        initFragment();

        viewModel.setTextAccrToCurrEstablishment(description_textView);

        floatingActionButton.setOnClickListener(v -> viewModel.openOpeningHoursActivity());

        return rootView;
    }

    private void findViewsById(View rootView){

        mainLayout = rootView.findViewById(R.id.main_layout);

        floatingActionButton = rootView.findViewById(R.id.fab);

        welcome_textView = rootView.findViewById(R.id.welcome_textView);

        description_textView = rootView.findViewById(R.id.description_textView);

    }

    private void initFragment(){

        TextView[] textViews = new TextView[]{welcome_textView, description_textView};

        MyAppFunctionalityInterface appFunc = new MyAppFunctionality(getContext());

        appFunc.initEstablishmentFragment((AppCompatActivity) getActivity(), textViews, mainLayout);

        viewModel = new HomeFragmentViewModel(getActivity());

    }

}
