package com.entecmedia.boendersfitness.viewmodels.classes;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.ViewModel;

import com.entecmedia.boendersfitness.MyAppFunctionality;
import com.entecmedia.boendersfitness.MyAppFunctionalityInterface;
import com.entecmedia.boendersfitness.R;
import com.entecmedia.boendersfitness.models.classes.CurrEstablishment;
import com.entecmedia.boendersfitness.ui.activities.OpeningHoursActivity;
import com.entecmedia.boendersfitness.viewmodels.interfaces.HomeFragmentViewModelInterface;

public class HomeFragmentViewModel extends ViewModel implements HomeFragmentViewModelInterface {

    Context context;

    private MyAppFunctionalityInterface appFunc;

    private int establishment;

    public HomeFragmentViewModel(Context context){

        this.context = context;

    }

    /*

     * ----- Interface methods -----

     */

    @Override
    public void setTextAccrToCurrEstablishment(TextView description_textView){

        initSetTextMethod();

        if (establishment == R.string.sharedPrefs_Rozemarijnstraat_string) {

            description_textView.setText(context.getString(R.string.startup_activity_main_string_rozemarijnstraat));

        }

        else if (establishment == R.string.sharedPrefs_Stationsstraat_string){

            description_textView.setText(context.getString(R.string.startup_activity_main_string_stationsstraat));

        } else {

            // TODO: TEST OF HASALREADYBEENSHOWN BOOLEAN HIER CORRECT WERKT!!!!!!!!!

            appFunc.showErrorAccrToAndroidVersion(context.getString(R.string.error_loading_certain_data));

        }

        Log.i("setTextEstablishment: ", String.valueOf(establishment));

    }

    @Override
    public void openOpeningHoursActivity(){

        Intent intent = new Intent(context, OpeningHoursActivity.class);

        context.startActivity(intent);

        /*

        Action complexity can be reduced by placing these few lines of code inside the UI activity, however,
        to demonstrate my ability to implement MVVM architecture, this method is purposefully placed
        in a ViewModel

        */

    }

    /*

    * ----- Testing only methods -----

    */

    @VisibleForTesting (otherwise = VisibleForTesting.NONE)
    @Override
    public String getDescriptionTextViewText(TextView mockTextView){

        return String.valueOf(mockTextView.getText());

    }

    /*

     * ----- Class methods -----

     */

    private void initSetTextMethod(){

        appFunc = new MyAppFunctionality(context);

        establishment = new CurrEstablishment(context).getCurrEstablishment();

    }

}
