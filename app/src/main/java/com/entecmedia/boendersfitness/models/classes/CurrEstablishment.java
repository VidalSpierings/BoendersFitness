package com.entecmedia.boendersfitness.models.classes;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

import com.entecmedia.boendersfitness.R;
import com.entecmedia.boendersfitness.models.interfaces.CurrEstablishmentInterface;

import static android.content.Context.MODE_PRIVATE;

public class CurrEstablishment implements CurrEstablishmentInterface {

    private SharedPreferences.Editor editor;

    private View view;

    private final Context context;

    public CurrEstablishment(Context context){

        this.context = context;

    }

    /*

    * ----- interface methods -----

    */

    @Override
    public int getCurrEstablishment(){

            SharedPreferences prefs = context.getSharedPreferences(
                    context.getString(R.string.sharedPrefs_mainPrefs_name),
                    MODE_PRIVATE);

            int establishment = prefs.getInt(context.getString(
                    R.string.sharedPrefs_Establishment_selection_string),
                    R.string.sharedPrefs_Establishment_not_found_string);

            Log.i("establishment: ", String.valueOf(establishment));

            return establishment;

    }

    @Override
    public void setCurrEstablishment(View view){

        this.view = view;

        editor = context.getSharedPreferences(
                context.getString(R.string.sharedPrefs_mainPrefs_name),
                MODE_PRIVATE).edit();

        decideToBePassedActivity();

        editor.apply();
    }

    /*

     * ----- class methods -----

     */

    private void decideToBePassedActivity(){

        if (view.getId() == R.id.rozemarijnstraatImageView) {

            editor.putInt(
                    context.getString(R.string.sharedPrefs_Establishment_selection_string),
                    R.string.sharedPrefs_Rozemarijnstraat_string);

            Log.d("passed establishment: ", context.getString(R.string.sharedPrefs_Rozemarijnstraat_string));

        } else if (view.getId() == R.id.stationsstraatImageView) {

            editor.putInt(
                    context.getString(R.string.sharedPrefs_Establishment_selection_string),
                    R.string.sharedPrefs_Stationsstraat_string);

            Log.d("passed establishment: ", context.getString(R.string.sharedPrefs_Stationsstraat_string));

        }

        // decide which establishment environment to open according to users selected choice

    }

}
