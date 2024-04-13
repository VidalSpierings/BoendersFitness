package com.entecmedia.boendersfitness;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.content.res.AppCompatResources;

import com.google.android.material.snackbar.Snackbar;

public class MyAppFunctionality implements MyAppFunctionalityInterface {

    private AppCompatActivity appCompatActivity;
    private final Context context;

    private View main_layout;

    private int establishment;
    private TextView[] textViews;

    private boolean hasErrorAlreadyBeenShown;

    private boolean isTesting;

    public MyAppFunctionality(Context context){

        this.context = context;

    }

    /*

    * ----- interface methods -----

    */

    @Override
    public void initLayoutAccrToCurrEstablishment(int currEstablishmentResourceId) {

        // separate parameters for context and establishment initialised for Unit testing compatibility

        Log.i("establishment: ", String.valueOf(currEstablishmentResourceId));

        checkIfIsInTestingEnvironment();

        if (currEstablishmentResourceId == R.string.sharedPrefs_Rozemarijnstraat_string) {

            initLayoutRSfunctionality();

        } else if (currEstablishmentResourceId == R.string.sharedPrefs_Stationsstraat_string) {

            initLayoutSSfunctionality();

        } else {

            initLayoutIllegalValue(currEstablishmentResourceId);

        }

    }

    @Override
    public void initLayoutRSfunctionality(){

        if (!isTesting) {

            // check whether or not code is being run from test environment

            context.setTheme(R.style.AppTheme);

            loopThroughTextViews(R.color.colorRozemarijnstraatText);

            setBackground(main_layout, R.drawable.app_background_image_rozemarijnstraat);

            Log.i("darkModeType: ", "manual dark mode layout initialised RZNstraat");

        }

    }

    @Override
    public void initLayoutSSfunctionality(){

        if (!isTesting) {

            // check whether or not code is being run from test environment

            loopThroughTextViews(R.color.colorStationsstraatText);

            setBackground(main_layout, R.drawable.app_background_image_stationsstraat);

            Log.i("darkModeType: ", "manual dark mode layout initialised SNstraat");

        }

        /*

        * if code is called from test environment, no further actions,
          just confirm correct method has been called for specific if case

        */

    }

    @Override
    public void initLayoutIllegalValue(int currEstablishment){

        if (!isTesting) {

            // check whether or not code is being run from test environment

            Log.d("darkModeType: ", "Error, \n\n establishment: " + currEstablishment);

            if (!hasErrorAlreadyBeenShown) {

                showErrorAccrToAndroidVersion(context.getString(R.string.error_loading_certain_data));

            }

            hasErrorAlreadyBeenShown = true;

        }

        /*

        * if code is called from test environment, no further actions,
          just confirm correct method has been called for specific if case

        */

    }

    @Override
    public void initEstablishmentActivity(AppCompatActivity appCompatActivity, TextView[] textViews, View main_layout){

        this.appCompatActivity = appCompatActivity;

        this.textViews = textViews;

        this.main_layout = main_layout;

        checkIfCanApplyCustomStatusBarColor();

        checkIfHaveToLockScreenOrientation();

        changeLayoutAppearanceAccrToCurrEstablishment();

    }

    @Override
    public void initEstablishmentFragment(AppCompatActivity appCompatActivity, TextView[] textViews, View main_layout){

        this.appCompatActivity = appCompatActivity;

        this.textViews = textViews;

        this.main_layout = main_layout;

        changeLayoutAppearanceAccrToCurrEstablishment();

    }

    @Override
    public void initMiscActivity(AppCompatActivity appCompatActivity){

        this.appCompatActivity = appCompatActivity;

        checkIfCanApplyCustomStatusBarColor();

        checkIfHaveToLockScreenOrientation();

    }

    @Override
    public void showErrorAccrToAndroidVersion(String message){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {

            Log.i("Error Version", "Above Jelly Bean");

            showSnackBarAfterLayoutLoaded(message);

        } else {

            Log.i("Error Version", "Below Jelly Bean");


            Toast.makeText(
                    context,
                    message,
                    Toast.LENGTH_LONG).show();




        }

    }

    /*

     * ----- class methods -----

     */

    private void checkIfIsInTestingEnvironment(){

        try {
            Class.forName("com.entecmedia.MyAppFunctionalityTest");
            isTesting = true;
        } catch (ClassNotFoundException e) {
            isTesting = false;
        }

    }

    @SuppressLint("SourceLockedOrientationActivity")
    private void checkIfHaveToLockScreenOrientation(){

        if(context.getResources().getBoolean(R.bool.portrait_only)){
            appCompatActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

    }

    private void checkIfCanApplyCustomStatusBarColor(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = appCompatActivity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(appCompatActivity.getResources().getColor(R.color.colorStatusBar));

            Log.i("statusBarInit: ", "custom color applied");

        } else {

            Log.i("statusBarInit: ", "no custom color applied");

        }

    }

    private void getCurrentEstablishment(){

        establishment = appCompatActivity.getSharedPreferences(
                appCompatActivity.getString(R.string.sharedPrefs_mainPrefs_name), Context.MODE_PRIVATE)
                .getInt(appCompatActivity.getString(R.string.sharedPrefs_Establishment_selection_string),
                        R.string.sharedPrefs_Establishment_not_found_string);

        Log.i("current establishment: ", String.valueOf(establishment));

    }

    private void changeLayoutAppearanceAccrToCurrEstablishment(){

        getCurrentEstablishment();

        initLayoutAccrToCurrEstablishment(establishment);

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){

            setBackground(main_layout, R.drawable.app_background_image_rozemarijnstraat);

            Log.d("darkModeType: ", "automatic dark mode layout initialised");

        }

    }

    private void showSnackBarAfterLayoutLoaded(String message){

        ViewTreeObserver viewTreeObserver = main_layout.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener (new ViewTreeObserver.OnGlobalLayoutListener() {

            @SuppressLint("NewApi")
            @Override
            public void onGlobalLayout() {

                main_layout.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                Snackbar.make(main_layout, message, Snackbar.LENGTH_LONG).show();

            }

            /*

            * SuppressLint because showSnackBarAfterLayoutLoaded() can never be called from a device with
              version code lower than Jelly Bean

            */

        });

    }

    private void loopThroughTextViews(int color){

        for (TextView textView : textViews) {

            textView.setTextColor(context.getResources().getColor(color));

        }

        Log.i("textViewsLoop", "successfully looped through textViews and applied text colors");

    }



    private void setBackground(View layout, int drawableResource){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){

            layout.setBackground(AppCompatResources.getDrawable(context, drawableResource));

        }

        else {

            main_layout.setBackgroundResource(R.drawable.app_background_image_rozemarijnstraat);

        }

    }
}
