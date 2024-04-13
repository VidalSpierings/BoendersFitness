package com.entecmedia.boendersfitness.viewmodels.classes;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import com.entecmedia.boendersfitness.models.classes.MyDatabase;
import com.entecmedia.boendersfitness.models.classes.CurrEstablishment;
import com.entecmedia.boendersfitness.ui.activities.AllOpeningHoursActivity;
import com.entecmedia.boendersfitness.viewmodels.interfaces.OpeningHoursActivityViewModelInterface;

import java.util.Calendar;

public class OpeningHoursActivityViewModel extends ViewModel implements OpeningHoursActivityViewModelInterface {

    private TextView
            todays_openinghours_textView,
            tomorrows_openinghours_textView;

    private int[] daysOfWeek;

    private int day;

    private CurrEstablishment currEstablishment;

    private MyDatabase myDatabase;

    private Context context;

    public OpeningHoursActivityViewModel (Context context){

        this.context = context;

    }

    /*

    * ----- Interface methods -----

    */

    @Override
    public void setOpeningTimes(TextView todays_openinghours_textView, TextView tomorrows_openinghours_textView){

        this.todays_openinghours_textView = todays_openinghours_textView;

        this.tomorrows_openinghours_textView = tomorrows_openinghours_textView;

        initSetOpeningTimesMethod();

        getAllRelevantData();

        assignHoursUsingLoop();

    }

    @Override
    public void openAllOpeningHoursActivity(AppCompatActivity appCompatActivity){

        Intent intent = new Intent(
                appCompatActivity,
                AllOpeningHoursActivity.class);

        appCompatActivity.startActivity(intent);

        /*

        Action complexity can be reduced by placing these few lines of code inside the UI activity, however,
        to demonstrate my ability to implement MVVM architecture, this method is purposefully placed
        in a ViewModel

        */

    }

    /*

     * ----- Class methods -----

     */

    private void getAllRelevantData(){

    }

    private void initSetOpeningTimesMethod(){

        currEstablishment = new CurrEstablishment(context);

        myDatabase = MyDatabase.getInstance(context);

    }

    private void assignHoursUsingLoop() {

        initDaysOfWeekData();

        setCorrectTodayTomorrowTimes();

    }

    private void initDaysOfWeekData(){

        Calendar calendar = Calendar.getInstance();

        day = calendar.get(Calendar.DAY_OF_WEEK);

        daysOfWeek = new int[] {Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.THURSDAY, Calendar.FRIDAY, Calendar.SATURDAY, Calendar.SUNDAY};

    }

    private void setCorrectTodayTomorrowTimes(){

        for (int i = 0; i < daysOfWeek.length; i++) {

            if (day == daysOfWeek[i]) {

                todays_openinghours_textView.setText(myDatabase.openingHoursToday[i]);

                tomorrows_openinghours_textView.setText(myDatabase.openingHoursTomorrow[i]);

            }

            Log.i("loopSuccess: ", "opening hours for loop completed successfully");

        }

        // for loop initialises correct opening times for current and next day
        // for the selected establishment

    }

}
