package com.entecmedia.boendersfitness;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.test.core.app.ApplicationProvider;

import com.entecmedia.boendersfitness.models.classes.MyDatabase;
import com.google.android.material.snackbar.Snackbar;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        MyDatabase db = new MyDatabase();

        db.getAllDataOnServer();

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();



    }

}
