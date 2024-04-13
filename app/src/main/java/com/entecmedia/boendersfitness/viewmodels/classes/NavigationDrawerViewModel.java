package com.entecmedia.boendersfitness.viewmodels.classes;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.Toolbar;
import androidx.core.util.Consumer;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.window.java.layout.WindowInfoTrackerCallbackAdapter;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;

import com.entecmedia.boendersfitness.MyAppFunctionality;
import com.entecmedia.boendersfitness.MyAppFunctionalityInterface;
import com.entecmedia.boendersfitness.R;
import com.entecmedia.boendersfitness.models.classes.CurrEstablishment;
import com.entecmedia.boendersfitness.ui.fragments.EstablishmentFragment;
import com.entecmedia.boendersfitness.ui.fragments.HomeFragment;
import com.entecmedia.boendersfitness.ui.fragments.InformationFragment;
import com.entecmedia.boendersfitness.ui.fragments.OpeningHoursFragment;
import com.entecmedia.boendersfitness.viewmodels.interfaces.NavigationDrawerViewModelInterface;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class NavigationDrawerViewModel extends ViewModel implements NavigationDrawerViewModelInterface {

    private final AppCompatActivity appCompatActivity;

    private final DrawerLayout drawer;

    private final Toolbar toolbar;

    private final ImageView toolbar_decoration_imageView;

    private WindowInfoTracker windowInfoTracker;

    private NavigationView nav_view;

    private Context context;

    public NavigationDrawerViewModel (AppCompatActivity appCompatActivity, Context context, DrawerLayout drawer, Toolbar toolbar, ImageView toolbar_decoration_imageView, NavigationView nav_view){

        this.appCompatActivity = appCompatActivity;
        this.context = context;
        this.drawer = drawer;
        this.toolbar = toolbar;
        this.toolbar_decoration_imageView = toolbar_decoration_imageView;
        this.nav_view = nav_view;

    }

    /*

     * ----- Interface methods -----

     */

    @Override
    public void initActivity(){

        initContainer();

        createNewWindowInfoTrackerCallbackAdapter();

    }

    @Override
    public void openOrCloseDrawer(){

        if (drawer.isDrawerOpen(GravityCompat.START)) {

            drawer.closeDrawer(GravityCompat.START);

            Log.i("drawerState: ", "drawer closed");

        } else if (!drawer.isDrawerOpen(GravityCompat.START)) {

            drawer.openDrawer(GravityCompat.START);

            Log.i("drawerState: ", "drawer opened");

        }

    }

    @Override
    public void setNavItemOnClickListener(){

        Log.i("menu item selected", "menu item selected");

        nav_view.setNavigationItemSelectedListener(item -> {

            FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();

            int id = item.getItemId();

            if (id == R.id.home) {
                fragmentManager.beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

                Log.i("selected fragment: ", "home");

            } if (id == R.id.establishments) {

                fragmentManager.beginTransaction().replace(R.id.fragment_container, new EstablishmentFragment()).commit();

                Log.i("selected fragment: ", "establishments");

            } if (id == R.id.opening_hours) {

                fragmentManager.beginTransaction().replace(R.id.fragment_container, new OpeningHoursFragment()).commit();

                Log.i("selected fragment: ", "opening hours");

            } if (id == R.id.information) {

                fragmentManager.beginTransaction().replace(R.id.fragment_container, new InformationFragment()).commit();

                Log.i("selected fragment: ", "information");

            }

            drawer.closeDrawer(GravityCompat.START);

            return true;
        });
    }

    @Override
    public void initToolbar(){

        initToggle();

        initToolbarAccrToEstablishment();

        appCompatActivity.setSupportActionBar(toolbar);

    }

    @Override
    public void initLayoutForFoldableDevices(){



    }

    @Override
    public void removeWindowLayoutListener(){

    }

    /*

    * ----- Class methods -----

    */

    private void initContainer(){

        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        // init container containing all the different Fragments that user can navigate between
        // (Home fragment, Establishment fragment, Opening hours fragment, Information fragment)

    }

    private void createNewWindowInfoTrackerCallbackAdapter(){

        windowInfoTracker = new WindowInfoTrackerCallbackAdapter(WindowInfoTracker.getOrCreate(appCompatActivity));

    }

    private void initToggle(){

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                appCompatActivity, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toggle.setDrawerSlideAnimationEnabled(false);

        // initialises toggle (= three lines button in top left corner used to open and close navigation drawer),
        // connects toggle to navigation drawer and disables 'hamburger to left arrow' toggle animation

    }

    private void initToolbarAccrToEstablishment(){

        CurrEstablishment currEstablishment = new CurrEstablishment(appCompatActivity.getApplicationContext());

        // check if method called from test environment

        int establishment = currEstablishment.getCurrEstablishment();

        if (establishment == R.string.sharedPrefs_Rozemarijnstraat_string
                && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {


            toolbar_decoration_imageView.setImageDrawable(
                    AppCompatResources.getDrawable(appCompatActivity.getApplicationContext(),
                            R.mipmap.toolbar_image_rozemarijnstraat)
            );

            Log.i("toolbarImage: ", String.valueOf(establishment));

        } else if (establishment == R.string.sharedPrefs_Stationsstraat_string
                && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {

            toolbar_decoration_imageView.setImageDrawable(
                    AppCompatResources.getDrawable(appCompatActivity.getApplicationContext(),
                            R.mipmap.toolbar_image_stationsstraat)


            );

            Log.i("toolbarImage: ", String.valueOf(establishment));

        } else {

            MyAppFunctionalityInterface appFunc = new MyAppFunctionality(appCompatActivity.getApplicationContext());

            Log.i("toolbarImage: ", "unknown");

            appFunc.showErrorAccrToAndroidVersion(appCompatActivity.getString(R.string.error_loading_certain_data));

        }

    }

    static class LayoutStateChangeCallback implements Consumer<WindowLayoutInfo> {

        public boolean isTableTop;
        public boolean isBookMode;

        @Override
        public void accept(WindowLayoutInfo newLayoutInfo) {
            // Use newLayoutInfo to update the Layout
            List<DisplayFeature> displayFeatures = newLayoutInfo.getDisplayFeatures();
            for (DisplayFeature feature : displayFeatures) {
                if (feature instanceof FoldingFeature) {
                    isTableTop = isTableTopMode((FoldingFeature) feature);
                    isBookMode = isBookMode((FoldingFeature) feature);
                }
            }
        }

        private boolean isTableTopMode(FoldingFeature foldFeature) {

            // Code for tabletop mode activated, implement animations for changing of fragments

            return (foldFeature != null) &&
                    (foldFeature.getState() == FoldingFeature.State.HALF_OPENED) &&
                    (foldFeature.getOcclusionType() == FoldingFeature.OcclusionType.FULL) &&
                    (foldFeature.getOrientation() == FoldingFeature.Orientation.HORIZONTAL);
        }

        private boolean isBookMode(FoldingFeature foldFeature) {

            // Code for tabletop mode activated, implement animations for changing of fragments

            return (foldFeature != null) &&
                    (foldFeature.getState() == FoldingFeature.State.HALF_OPENED) &&
                    (foldFeature.getOcclusionType() == FoldingFeature.OcclusionType.FULL) &&
                    (foldFeature.getOrientation() == FoldingFeature.Orientation.VERTICAL);
        }

    }

}
