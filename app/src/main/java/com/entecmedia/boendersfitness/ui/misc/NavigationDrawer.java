package com.entecmedia.boendersfitness.ui.misc;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.entecmedia.boendersfitness.MyAppFunctionality;
import com.entecmedia.boendersfitness.MyAppFunctionalityInterface;
import com.entecmedia.boendersfitness.R;
import com.entecmedia.boendersfitness.viewmodels.classes.NavigationDrawerViewModel;
import com.entecmedia.boendersfitness.viewmodels.interfaces.NavigationDrawerViewModelInterface;
import com.google.android.material.navigation.NavigationView;

public class NavigationDrawer extends AppCompatActivity {

    private NavigationDrawerViewModelInterface viewModel;

    private Toolbar toolbar;

    private DrawerLayout drawer;

    private ImageView toolbar_decoration_imageView;

    private NavigationView nav_view;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        findViewsById();

        viewModel = new NavigationDrawerViewModel(
                this, getBaseContext(), drawer, toolbar,
                toolbar_decoration_imageView, nav_view);

        viewModel.initActivity();

        viewModel.setNavItemOnClickListener();
    }

    // ----- class implementation methods -----

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        viewModel.openOrCloseDrawer();

        return super.onOptionsItemSelected(item);
    }

    /*

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        return true;
    }

    */

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        viewModel.initToolbar();

        // toolbar initialised in onPostCreate according to (Google) Android development guidelines

    }

    @Override
    protected void onStart() {
        super.onStart();

        initActivity();

        viewModel.initLayoutForFoldableDevices();

    }

    @Override
    protected void onStop() {
        super.onStop();

        viewModel.removeWindowLayoutListener();

    }

    // ----- Activity methods -----

    private void findViewsById(){

        toolbar = findViewById(R.id.toolbar);

        drawer = findViewById(R.id.main_layout);

        toolbar_decoration_imageView = findViewById(R.id.toolbar_decoration_imageView);

        nav_view = findViewById(R.id.nav_view);

    }

    private void initActivity(){

        MyAppFunctionalityInterface appFunc = new MyAppFunctionality(this);

        appFunc.initMiscActivity(this);

    }

}
