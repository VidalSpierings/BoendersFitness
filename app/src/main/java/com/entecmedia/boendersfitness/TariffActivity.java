package com.entecmedia.boendersfitness;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TariffActivity extends android.support.v4.app.Fragment {

    Button button5;

    int BoenderBoxtel;
    int BoenderDames;
    int BoenderMichiel;

    TextView
            normal_textView,
            peakhourstextView,
            key_title_textView,
            key_description_textView,
                    textView43,
                            include_key_textView;


    // boxtel: keep layout
    // Dames: daluren 18,50 , daguren 25, key_title_textView and key_desciption disabled
    // Michiel: textView43, peakhourstextView, key_title_textView, key_desciption disabled, normal 25

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View i = inflater.inflate(R.layout.content_tariff, container, false);

        button5 = (Button) i.findViewById(R.id.button5);
        normal_textView = (TextView) i.findViewById(R.id.normal_textView);
        peakhourstextView = (TextView) i.findViewById(R.id.peakhourstextView);
        key_title_textView = (TextView) i.findViewById(R.id.key_title_textView);
        key_description_textView = (TextView) i.findViewById(R.id.key_description_textView);
        textView43 = (TextView) i.findViewById(R.id.textView43);
        include_key_textView = (TextView) i.findViewById(R.id.include_key_textView);



        BoenderBoxtel = getActivity().getIntent().getExtras().getInt("BoenderBoxtel");
        BoenderDames = getActivity().getIntent().getExtras().getInt("BoenderDames");
        BoenderMichiel = getActivity().getIntent().getExtras().getInt("BoenderMichiel");

        if (BoenderDames == 2){

        normal_textView.setText(getString(R.string.twentyfive_string));
            peakhourstextView.setText(getString(R.string.eightteen_fifty_string));
            key_title_textView.setVisibility(View.INVISIBLE);
            key_description_textView.setVisibility(View.INVISIBLE);
            include_key_textView.setVisibility(View.INVISIBLE);


        }
        else if (BoenderMichiel == 3){

            normal_textView.setText(getString(R.string.twentyfive_string));
            textView43.setVisibility(View.INVISIBLE);
            peakhourstextView.setVisibility(View.INVISIBLE);
            key_title_textView.setVisibility(View.INVISIBLE);
            key_description_textView.setVisibility(View.INVISIBLE);
            include_key_textView.setVisibility(View.INVISIBLE);


        }

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    Uri uri = Uri.parse("http://www.boenderfitness.nl/reglement.pdf");

                    Intent intent = new Intent(Intent.ACTION_VIEW);

                    intent.setData(uri);




                ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
                if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getActivity().getApplicationContext(), R.string.no_internet_string, Toast.LENGTH_LONG).show();

                }

            }
        });

        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP){
            button5.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }



        return i;
    }

}
