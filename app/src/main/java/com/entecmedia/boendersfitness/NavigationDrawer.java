package com.entecmedia.boendersfitness;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class NavigationDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
     //   ,
      //  GoogleApiClient.ConnectionCallbacks,
     //   GoogleApiClient.OnConnectionFailedListener,
     //   ResultCallback<Status>
{

    int
            BoenderBoxtel,
            BoenderDames,
            BoenderMichiel;

    ActionBarDrawerToggle actionBarDrawerToggle;

    Toolbar toolbar;

    DrawerLayout drawer;

    NavigationView nav_view;

   // protected GoogleApiClient mGoogleApiClient;

   // protected ArrayList<Geofence> mGeofenceList;

   // PendingIntent mGeofencePendingIntent;

   // private SharedPreferences mSharedPreferences;

   // boolean mGeofencesAdded;

   // LocationRequest locationRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        nav_view = (NavigationView) findViewById(R.id.nav_view);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.setDrawerListener(actionBarDrawerToggle);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        BoenderBoxtel = getIntent().getExtras().getInt("BoenderBoxtel");
        BoenderDames = getIntent().getExtras().getInt("BoenderDames");
        BoenderMichiel = getIntent().getExtras().getInt("BoenderMichiel");

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle(getString(R.string.home_string));

        toolbar.setLogo(R.drawable.logo);

        setSupportActionBar(toolbar);

        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

    //    mGeofenceList = new ArrayList<Geofence>();

       // mGeofencePendingIntent = null;

       // mSharedPreferences = getSharedPreferences(Constants.SHARED_PREFERENCES_NAME,
      //          MODE_PRIVATE);

        // Get the value of mGeofencesAdded from SharedPreferences. Set to false as a default.
       // mGeofencesAdded = mSharedPreferences.getBoolean(Constants.GEOFENCES_ADDED_KEY, false);

      //  populateGeofenceList();

      //  buildGoogleApiClient();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorStatusbar));
        }


        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container, new StartupActivity()).commit();

    }


   // private GeofencingRequest getGeofencingRequest() {

    //    GeofencingRequest.Builder builder = new GeofencingRequest.Builder();
     //   builder.setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER);
     //   builder.addGeofences(mGeofenceList);

       // return builder.build();

   // }

    private PendingIntent getGeofencePendingIntent() {

        Uri uri = Uri.parse("http://entec.weebly.com");

        Intent intent = new Intent(Intent.ACTION_VIEW);

        intent.setData(uri);        // We use FLAG_UPDATE_CURRENT so that we get the same pending intent back when calling
        // addGeofences() and removeGeofences().
        return PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

   // public void populateGeofenceList() {
    //    for (Map.Entry<String, LatLng> entry : Constants.LANDMARKS.entrySet()) {

      //      mGeofenceList.add(new Geofence.Builder()
                    // Set the request ID of the geofence. This is a string to identify this
                    // geofence.
        //            .setRequestId(entry.getKey())

                    // Set the circular region of this geofence.
           //         .setCircularRegion(
          //                  entry.getValue().latitude,
           //                 entry.getValue().longitude,
           //                 Constants.GEOFENCE_RADIUS_IN_METERS
           //         )

                    // Set the expiration duration of the geofence. This geofence gets automatically
                    // removed after this period of time.
                //    .setExpirationDuration(Constants.GEOFENCE_EXPIRATION_IN_MILLISECONDS)

                    // Set the transition types of interest. Alerts are only generated for these
                    // transition. We track entry and exit transitions in this sample.
                 //   .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER)

                    // Create the geofence.
                 //   .build());
       // }
    //}

    //protected synchronized void buildGoogleApiClient() {
     //   mGoogleApiClient = new GoogleApiClient.Builder(this)
     //           .addConnectionCallbacks(this)
      //          .addOnConnectionFailedListener(this)
      //          .addApi(LocationServices.API)
      //          .build();
   // }

   // public void startApiClient() {

      //  try {

       //     locationRequest = LocationRequest.create()
       //             .setInterval(5000)
       //             .setFastestInterval(4000)
       //             .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

       //    if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

       //         return;
         //   }
      //      LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, locationRequest, new LocationListener() {
        //        @Override
        //        public void onLocationChanged(Location location) {


         //       }
        //    });


       // } catch (Exception e) {

       // }

      //  if (!mGoogleApiClient.isConnected()) {
       //     Toast.makeText(this, getString(R.string.not_connected), Toast.LENGTH_SHORT).show();
       //     return;
       // }

      //  try {

      //      LocationServices.GeofencingApi.addGeofences
        //            (mGoogleApiClient, getGeofencingRequest(), getGeofencePendingIntent()).setResultCallback(this); // Result processed in onResult().

       // } catch (SecurityException securityException) {
       //     securityException.notify();
      //  }
   // }

   // public void onResult(Status status) {
     //   if (status.isSuccess()) {
            // Update state and save in shared preferences.
     //       mGeofencesAdded = !mGeofencesAdded;
       //     SharedPreferences.Editor editor = mSharedPreferences.edit();
      //      editor.putBoolean(Constants.GEOFENCES_ADDED_KEY, mGeofencesAdded);
      //      editor.apply();
       // }


   // }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            if (!drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.openDrawer(GravityCompat.START);
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (id == R.id.home) {
            fragmentManager.beginTransaction().replace(R.id.fragment_container, new StartupActivity()).commit();

            toolbar.setTitle(getString(R.string.home_string));

        } else if (id == R.id.music) {

          //  fragmentManager.beginTransaction().replace(R.id.fragment_container, new MusicImplementation()).commit();

            toolbar.setTitle(getString(R.string.music_string));

        } else if (id == R.id.openinghours) {

            fragmentManager.beginTransaction().replace(R.id.fragment_container, new NotKeyFragment()).commit();

            toolbar.setTitle(getString(R.string.opening_hours_string));

        } else if (id == R.id.tariff) {

            fragmentManager.beginTransaction().replace(R.id.fragment_container, new TariffActivity()).commit();

            toolbar.setTitle(getString(R.string.tariffs_string));

        } else if (id == R.id.nav_slideshow) {

            fragmentManager.beginTransaction().replace(R.id.fragment_container, new LocationActivity()).commit();

            toolbar.setTitle(getString(R.string.establishments_string));

        } else if (id == R.id.contact) {

            fragmentManager.beginTransaction().replace(R.id.fragment_container, new ContactActivity()).commit();

            toolbar.setTitle(getString(R.string.contact_string));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

  //  @Override
  //  public void onConnected(Bundle connectionHint) {
  //      Log.i("", "Connected to GoogleApiClient");

    //    if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

     //       return;
     //   }
    //    LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, locationRequest, getGeofencePendingIntent());
  //  }

   // @Override
   // public void onConnectionFailed(ConnectionResult result) {

    //    Log.i("", "Connection failed: ConnectionResult.getErrorCode() = " + result.getErrorCode());
   // }

  //  @Override
   // public void onConnectionSuspended(int cause) {
    //    Log.i("", "Connection suspended");
  //  }


  //  @Override
  //  protected void onStart() {

   //     mGoogleApiClient.connect();

   //     super.onStart();

   // }

  //  @Override
   // protected void onStop() {
  //      super.onStop();
  //      mGoogleApiClient.disconnect();
   // }

   // @Override
   // protected void onResume() {
  //      super.onResume();



     //   if (mGoogleApiClient.isConnected()){

     //       Toast.makeText(getApplicationContext(), "great success!", Toast.LENGTH_LONG).show();

     //   }

        //if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        //    return;
       // }
   // }

}
