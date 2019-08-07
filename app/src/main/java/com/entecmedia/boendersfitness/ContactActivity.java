package com.entecmedia.boendersfitness;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Vidal on 28-05-16.
 */
public class ContactActivity extends android.support.v4.app.Fragment {

    Button button;
    FloatingActionButton fabutton;

    Bundle bundle;

    int BoenderBoxtel;
    int BoenderDames;
    int BoenderMichiel;

    String mPhone;

    TextView phone;
    String phoneNumber;

    ImageView imageView5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_contact, container, false);

        phone = (TextView) rootView.findViewById(R.id.phone);

        BoenderBoxtel = getActivity().getIntent().getExtras().getInt("BoenderBoxtel");
        BoenderDames = getActivity().getIntent().getExtras().getInt("BoenderDames");
        BoenderMichiel = getActivity().getIntent().getExtras().getInt("BoenderMichiel");

        fabutton = (FloatingActionButton) rootView.findViewById(R.id.fabutton);
        imageView5 = (ImageView) rootView.findViewById(R.id.imageView5);
        button = (Button) rootView.findViewById(R.id.button);

        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP){
            button.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }

        if (BoenderBoxtel == 1){

            mPhone = "tel:0647371300";
            phoneNumber = getString(R.string.phone) + " " + "06-47371300";

        }
        else if (BoenderDames == 2){

            mPhone = "tel:0645834124";
            phoneNumber = getString(R.string.phone) + " " + "06-45834124";


        }
        else if (BoenderMichiel == 3){

            mPhone = "tel:0610152320";
            phoneNumber = getString(R.string.phone) + " " + "06-10152320";

        }

        fabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(mPhone));
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, "boenderfitness@hotmail.com");

                startActivity(intent);
            }
        });
        phone.setText(phoneNumber);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"boenderfitness@hotmail.com"});
                startActivity(intent);
            }
        });

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("http://www.boenderfitness.nl/");

                Intent intent = new Intent(Intent.ACTION_VIEW);

                intent.setData(uri);

                startActivity(intent);
            }
        });

        return rootView;
    }
}
