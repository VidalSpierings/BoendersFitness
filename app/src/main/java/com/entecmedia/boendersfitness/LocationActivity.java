package com.entecmedia.boendersfitness;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class LocationActivity extends android.support.v4.app.Fragment {


    FloatingActionButton fab;
    Bundle bundle;

    int BoenderBoxtel;
    int BoenderDames;
    int BoenderMichiel;

    Uri uri;

    ImageView locationImage;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View i = inflater.inflate(R.layout.activity_location, container, false);

        bundle = new Bundle();

        BoenderBoxtel = getActivity().getIntent().getExtras().getInt("BoenderBoxtel");
        BoenderDames = getActivity().getIntent().getExtras().getInt("BoenderDames");
        BoenderMichiel = getActivity().getIntent().getExtras().getInt("BoenderMichiel");

        locationImage = (ImageView) i.findViewById(R.id.locationImage);

        if (BoenderBoxtel == 1){

            locationImage.setImageResource(R.drawable.boxtel);

        }
        else if (BoenderDames == 2){

            locationImage.setImageResource(R.drawable.dames);

        }
        else if (BoenderMichiel == 3){

            locationImage.setImageResource(R.drawable.michiels);

        }

locationImage.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        if (BoenderBoxtel == 1){

            uri = Uri.parse
                    ("https://www.google.nl/maps/place/Rozemarijnstraat+6A,+5281+BZ+Boxtel/@51.5879735,5.3254722,17z/data=!3m1!4b1!4m5!3m4!1s0x47c6e84199ae6b93:0x8e15dea245884c8d!8m2!3d51.5879735!4d5.3276609");
        }
        else if (BoenderDames == 2){

            uri = Uri.parse
                    ("https://www.google.nl/maps/place/Stationsstraat+5907,+5281+GB+Boxtel/@51.5868962,5.3191723,17z/data=!3m1!4b1!4m5!3m4!1s0x47c6e846e3b344bf:0xc49feaea83b86396!8m2!3d51.5868962!4d5.321361");
        }
        else if (BoenderMichiel == 3){

            uri = Uri.parse
                    ("https://www.google.nl/maps/place/Nieuwstraat+50,+5271+AE+Sint-Michielsgestel/@51.6422622,5.3504917,17z/data=!3m1!4b1!4m5!3m4!1s0x47c6e8b26c454bfb:0xfa3f2f0960e9e037!8m2!3d51.6422622!4d5.3526804");
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

        startActivity(intent);


    }
});

return i;
    }
}
