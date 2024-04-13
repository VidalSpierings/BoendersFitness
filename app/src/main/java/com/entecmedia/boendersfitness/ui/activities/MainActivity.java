package com.entecmedia.boendersfitness.ui.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.entecmedia.boendersfitness.MyAppFunctionality;
import com.entecmedia.boendersfitness.MyAppFunctionalityInterface;
import com.entecmedia.boendersfitness.R;
import com.entecmedia.boendersfitness.viewmodels.classes.MainActivityViewModel;
import com.entecmedia.boendersfitness.viewmodels.interfaces.MainActivityViewModelInterface;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MainActivityViewModelInterface viewModel;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView rozemarijnstraatImageView = findViewById(R.id.rozemarijnstraatImageView);
        ImageView stationsstraatImageView = findViewById(R.id.stationsstraatImageView);

        initApp();

        rozemarijnstraatImageView.setOnClickListener(this);

        stationsstraatImageView.setOnClickListener(this);

        /*

        both buttons have near-exact same functionality and thus identical onClick logic.
        logic for specific selected button is handled in MainActivityViewModel and
        CurrEstablishment classes

        */


        }


    // ----- Methods from class implementation -----

    @Override
    public void onClick(View view) {

        viewModel.startNavigationDrawerActivity(view);

    }


    // ----- Activity Methods -----


    private void initApp(){

        viewModel = new MainActivityViewModel(this, getBaseContext());

        MyAppFunctionalityInterface appFunc = new MyAppFunctionality(this);

        appFunc.initMiscActivity(this);

    }

}
