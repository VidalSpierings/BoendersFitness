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

import org.w3c.dom.Text;

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
            textView43, //unlimited peakhours
            family_textView,
            textView54,
            textView56, // seperate vacu ses
            textView17, // seperate vacu ses desc
            weekend_textView,
            weekend_desc_textView,
            partner_textView,
            partner_desc_textView,
            textview4, //unlimited normal
            try_out_desc,
            textView50, // senior/youth tariff desc
            textView49, // senior/youth tariff
            textView47; // unlimited_vacu_desc


    //disable family desc dames

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
        family_textView = (TextView) i.findViewById(R.id.family_textView);
        textView54 = (TextView) i.findViewById(R.id.textView54);
        weekend_textView = (TextView) i.findViewById(R.id.weekend_textView);
        weekend_desc_textView = (TextView) i.findViewById(R.id.weekend_desc_textView);
        partner_textView = (TextView) i.findViewById(R.id.partner_textView);
        partner_desc_textView = (TextView) i.findViewById(R.id.partner_desc_textView);
        textview4 = (TextView) i.findViewById(R.id.textView4);
        try_out_desc = (TextView) i.findViewById(R.id.try_out_description);
        textView50 = (TextView) i.findViewById(R.id.textView50);
        textView49 = (TextView) i.findViewById(R.id.textView49);
        textView47 = (TextView) i.findViewById(R.id.textView47);
        textView56 = (TextView) i.findViewById(R.id.textView56);
        textView17 = (TextView) i.findViewById(R.id.textView17);

        BoenderBoxtel = getActivity().getIntent().getExtras().getInt("BoenderBoxtel");
        BoenderDames = getActivity().getIntent().getExtras().getInt("BoenderDames");
        BoenderMichiel = getActivity().getIntent().getExtras().getInt("BoenderMichiel");

        if (BoenderDames == 2){

            normal_textView.setText(getString(R.string.unlimited_day_desc_gestel));
            peakhourstextView.setText(getString(R.string.dal_costs_ladies));
            textView50.setText(getString(R.string.sixty_plus_description_ladies));
        }

        else if (BoenderMichiel == 3){

            textview4.setText(getString(R.string.unlimited_day_gestel));
            normal_textView.setText(getString(R.string.unlimited_day_desc_gestel));

            textView50.setVisibility(View.INVISIBLE);
            textView49.setVisibility(View.INVISIBLE);
            textView43.setVisibility(View.INVISIBLE);
            peakhourstextView.setVisibility(View.INVISIBLE);
            textView56.setVisibility(View.INVISIBLE);
            textView17.setVisibility(View.INVISIBLE);

        }

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("http://www.boenderfitness.nl/reglement.pdf");

                Intent intent = new Intent(Intent.ACTION_VIEW);

                intent.setData(uri);

                ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
                if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)
                {
                    startActivity(intent);
                }
                else
                {
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
