package com.entecmedia;

import android.content.Context;
import android.widget.TextView;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.entecmedia.boendersfitness.MyAppFunctionality;
import com.entecmedia.boendersfitness.MyAppFunctionalityInterface;
import com.entecmedia.boendersfitness.R;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import java.lang.invoke.MethodHandle;


public class MyAppFunctionalityTest {

    MyAppFunctionalityInterface myAppFunc;

    Context mockContext;

    @BeforeEach
    public void setup(){

        mockContext = Mockito.mock(Context.class);

        myAppFunc = PowerMockito.spy(new MyAppFunctionality(mockContext));

    }

    @Test
    public void testLayoutInitFunctionalityRS(){

        myAppFunc.initLayoutAccrToCurrEstablishment(R.string.sharedPrefs_Rozemarijnstraat_string);

        Mockito.verify(myAppFunc).initLayoutRSfunctionality();

    }

    @Test
    public void testLayoutInitFunctionalitySS(){

        myAppFunc.initLayoutAccrToCurrEstablishment(R.string.sharedPrefs_Stationsstraat_string);

        Mockito.verify(myAppFunc).initLayoutSSfunctionality();

    }

    @Test
    public void testLayoutInitFunctionalityDefault(){

        int defaultValueInt = R.string.sharedPrefs_Establishment_not_found_string;

        myAppFunc.initLayoutAccrToCurrEstablishment(defaultValueInt);

        Mockito.verify(myAppFunc).initLayoutIllegalValue(defaultValueInt);

    }

    @Test
    public void testLayoutInitFunctionalityZero(){

        int zeroInt = 0;

        myAppFunc.initLayoutAccrToCurrEstablishment(zeroInt);

        Mockito.verify(myAppFunc).initLayoutIllegalValue(zeroInt);

    }

}
