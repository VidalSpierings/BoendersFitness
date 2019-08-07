package com.entecmedia.boendersfitness;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class StartupActivity extends android.support.v4.app.Fragment {

    Toolbar toolbar;
    Bundle bundle;
    FloatingActionButton floatingActionButton;

    int BoenderBoxtel;
    int BoenderDames;
    int BoenderMichiel;

    TextView textView20;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.content_startup, container, false);

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        floatingActionButton = (FloatingActionButton) rootView.findViewById(R.id.fab);

        BoenderBoxtel = getActivity().getIntent().getExtras().getInt("BoenderBoxtel");
        BoenderDames = getActivity().getIntent().getExtras().getInt("BoenderDames");
        BoenderMichiel = getActivity().getIntent().getExtras().getInt("BoenderMichiel");

        textView20 = (TextView) rootView.findViewById(R.id.textView20);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), Openinghours_ActivityActivity.class);

                Bundle bundle = new Bundle();

                if (BoenderBoxtel == 1) {

                    bundle.putInt("BoenderBoxtel", 1);
                    intent.putExtra("BoenderBoxtel", 1);

                }
                if (BoenderDames == 2) {

                    bundle.putInt("BoenderDames", 2);
                    intent.putExtra("BoenderDames", 2);

                }
                if (BoenderMichiel == 3) {

                    bundle.putInt("BoenderMichiel", 3);
                    intent.putExtra("BoenderMichiel", 3);

                }


                startActivity(intent);


            }
        });

        return rootView;
    }



}
