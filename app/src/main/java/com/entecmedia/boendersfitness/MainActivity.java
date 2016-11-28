package com.entecmedia.boendersfitness;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Button button1, button2, button3;
    Intent intent;
    Bundle bundle;




    // create apk

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);




        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorStatusbar));
        }



         button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bundle = new Bundle();
                bundle.putInt("BoenderBoxtel", 1);
                intent = new Intent(MainActivity.this, NavigationDrawer.class);
                intent.putExtra("BoenderBoxtel", 1);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(MainActivity.this, button1, getString(R.string.activity_image_trans));
                    startActivity(intent, options.toBundle());
                } else {

                    startActivity(intent);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bundle = new Bundle();
                bundle.putInt("BoenderDames", 2);
                intent = new Intent(MainActivity.this, NavigationDrawer.class);
                intent.putExtra("BoenderDames", 2);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(MainActivity.this, button2, "activity_image_trans2");
                    startActivity(intent, options.toBundle());
                } else {

                    startActivity(intent);
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle = new Bundle();
                bundle.putInt("BoenderMichiel", 3);
                intent = new Intent(MainActivity.this, NavigationDrawer.class);
                intent.putExtra("BoenderMichiel", 3);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(MainActivity.this, button3, "activity_image_trans2");
                    startActivity(intent, options.toBundle());
                } else {

                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }
}

//51.5879627,5.3275548
