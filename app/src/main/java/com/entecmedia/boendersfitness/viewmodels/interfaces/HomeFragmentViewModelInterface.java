package com.entecmedia.boendersfitness.viewmodels.interfaces;

import android.widget.TextView;

import androidx.annotation.VisibleForTesting;

public interface HomeFragmentViewModelInterface {

    void setTextAccrToCurrEstablishment(TextView description_textView);

    void openOpeningHoursActivity();

    /*

     * ----- testing only methods -----

     */

    @VisibleForTesting(otherwise = VisibleForTesting.NONE)
    String getDescriptionTextViewText(TextView mockTextView);
}
