package com.entecmedia.boendersfitness;

import android.content.Context;
import android.widget.TextView;

import androidx.test.core.app.ApplicationProvider;

import com.entecmedia.boendersfitness.viewmodels.classes.HomeFragmentViewModel;
import com.entecmedia.boendersfitness.viewmodels.interfaces.HomeFragmentViewModelInterface;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

//TODO: CONVERT TO COFFEE TEST

public class HomeFragmentViewModelTestA {

    Context context;

    HomeFragmentViewModelInterface homeFragment;

    TextView mockedTextView;

    @BeforeEach
    public void setUp(){

        context = ApplicationProvider.getApplicationContext();

        homeFragment = Mockito.spy(new HomeFragmentViewModel(context));

        mockedTextView = Mockito.mock(TextView.class);

    }

    @Test
    public void testIfDescriptionNotErrorOrEmpty(){

        homeFragment.setTextAccrToCurrEstablishment(mockedTextView);

        String result = homeFragment.getDescriptionTextViewText(mockedTextView);

        Assert.assertNotEquals(context.getString(R.string.error_loading_certain_data), result);

        Assert.assertNotEquals(null, result);

        Assert.assertNotEquals("", result);
    }

}
