package com.entecmedia.boendersfitness.models.classes;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import com.entecmedia.boendersfitness.R;
import com.entecmedia.boendersfitness.models.DatabaseConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MyDatabase extends DatabaseConstants {
    private static MyDatabase instance;

    private static int establishment;

    HttpURLConnection connection;

    public String[] openingHoursToday = {"9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 20:00", "11:00 - 17:00"};

    public String[] openingHoursTomorrow = {"9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 20:00", "11:00 - 17:00", "9:00 - 17:00"};

    private URL dbURL;

    public static MyDatabase getInstance (Context context){

        if (instance == null) {

            instance = new MyDatabase();

        }

        CurrEstablishment currEstablishment = new CurrEstablishment(context);

        MyDatabase.establishment = currEstablishment.getCurrEstablishment();

        return instance;

    }

    public void getAllDataFromServerRetroFit(){



        if (establishment == R.string.sharedPrefs_Rozemarijnstraat_string){

            //TODO: ADD FIREBASE IMPLEMENTATION PER LANGUAGE!!! KIJK OF VERSCHILLENDE TALEN IN ZELFDE DATABASE TAFEL GEBRUIKT KAN WORDEN

            openingHoursToday = new String[] {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "Sunday"};

        }

        // if establishment equals Rozemarijnstraat:
        //
        // run through all the items in the dayOfWeek array, and chronologically assign corresponding opening hours
        // for today and tomorrow using the 'openingHoursToday' and 'openingHoursTomorrow' arrays respectively

        else if (establishment == R.string.sharedPrefs_Stationsstraat_string){

            openingHoursToday = new String[] {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "Sunday"};

        }

        Log.i("selected hours: ", String.valueOf(establishment));

        // if establishment equals Stationsstraat:
        //
        // run through all the items in the dayOfWeek array, and chronologically assign corresponding opening hours
        // for today and tomorrow using the 'openingHoursToday' and 'openingHoursTomorrow' arrays respectively

    }

    public void getAllDataOnServer(){

        try {
            dbURL = new URL(DB_PATH);
        } catch (MalformedURLException e) {

            e.printStackTrace();
        }

        try {

            connection = (HttpURLConnection) dbURL.openConnection();

            connection.setRequestMethod("GET");

            connection.setConnectTimeout(15000);

            connection.setReadTimeout(15000);

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {

            FetchDataFromAsyncTask fetch = new FetchDataFromAsyncTask();

            fetch.execute(connection);

            } else {

            FetchDataFromAsyncTask fetch = new FetchDataFromAsyncTask();

            fetch.execute(connection);

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    private static class FetchDataFromAsyncTask extends AsyncTask<HttpURLConnection, Void, String> {

        HttpURLConnection onlyConnection;

        private ArrayList<String> dutch_special_hours_names;
        private ArrayList<String> dutch_special_hours_times;
        private ArrayList<String> english_special_hours_names;
        private ArrayList<String> english_special_hours_times;

        private JSONObject jsonObject;

        @Override
        protected String doInBackground(HttpURLConnection... connection) {

            Log.i("process status: ", "background process started");

            onlyConnection = connection[0];

            int responseCode = 0;

            try {

                responseCode = onlyConnection.getResponseCode();

                Log.i("response code: ", String.valueOf(responseCode));

            } catch (IOException e) {

                e.printStackTrace();

            }

            switch (responseCode){

                case 404:
                    String userErrorMessage =
                            "Error: Server was not found. \n (404: Not found)" ;

                    //etc, etc, etc...

                    //TODO: TOAST MAKEN

            }

                try {

                    BufferedReader br = new BufferedReader(new InputStreamReader((onlyConnection.getInputStream())));
                    StringBuilder sb = new StringBuilder();
                    String output;
                    while ((output = br.readLine()) != null) {
                        sb.append(output);
                    }

                    //TODO: GEBRUIK JSONARRAY WAAR NODIG

                    br.close();

                    String jsonString = sb.toString();

                    jsonObject = new JSONObject(jsonString);

                    fetchEverything();

                } catch (IOException | JSONException e) {

                    //TODO: MAAK ERROR

                    Log.i("excp", e.toString());

                    e.printStackTrace();

                }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            onlyConnection.disconnect();

            Log.i("process status: ", "background process ended");

        }

        private String fetchSampleNode() throws IOException {

            return null;

        }

        private void fetchEverything(){

            try {

                String email = jsonObject.getString(EMAIL);

                String phoneNumber = jsonObject.getString(PHONE_NUMBER);

                String main_text_dutch_rozemarijn = jsonObject
                        .getJSONObject(DUTCH_LANGUAGE_TABLE)
                        .getJSONObject(ROZEMARIJNSTRAAT_TABLE)
                        .getString(MAIN_FRAGMENT_DESCRIPTION_TEXT);
                String main_text_dutch_stationsstraat = jsonObject
                        .getJSONObject(DUTCH_LANGUAGE_TABLE)
                        .getJSONObject(STATIONSSTRAAT_ESTABLISHMENT)
                        .getString(MAIN_FRAGMENT_DESCRIPTION_TEXT);
                String main_text_english_rozemarijnstraat = jsonObject
                        .getJSONObject(ENGLISH_LANGUAGE_TABLE)
                        .getJSONObject(ROZEMARIJNSTRAAT_TABLE)
                        .getString(MAIN_FRAGMENT_DESCRIPTION_TEXT);
                String main_text_english_stationsstraat = jsonObject
                        .getJSONObject(ENGLISH_LANGUAGE_TABLE)
                        .getJSONObject(STATIONSSTRAAT_ESTABLISHMENT)
                        .getString(MAIN_FRAGMENT_DESCRIPTION_TEXT);

                String english_rozemarijn_monday = jsonObject
                        .getJSONObject(ENGLISH_LANGUAGE_TABLE)
                        .getJSONObject(ROZEMARIJNSTRAAT_TABLE)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(MONDAY_TEXT);
                String english_rozemarijn_tuesday = jsonObject
                        .getJSONObject(ENGLISH_LANGUAGE_TABLE)
                        .getJSONObject(ROZEMARIJNSTRAAT_TABLE)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(TUESDAY_TEXT);
                String english_rozemarijn_wednesday = jsonObject
                        .getJSONObject(ENGLISH_LANGUAGE_TABLE)
                        .getJSONObject(ROZEMARIJNSTRAAT_TABLE)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(WEDNESDAY_TEXT);
                String english_rozemarijn_thursday = jsonObject
                        .getJSONObject(ENGLISH_LANGUAGE_TABLE)
                        .getJSONObject(ROZEMARIJNSTRAAT_TABLE)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(THURSDAY_TEXT);
                String english_rozemarijn_friday = jsonObject
                        .getJSONObject(ENGLISH_LANGUAGE_TABLE)
                        .getJSONObject(ROZEMARIJNSTRAAT_TABLE)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(FRIDAY_TEXT);
                String english_rozemarijn_saturday = jsonObject
                        .getJSONObject(ENGLISH_LANGUAGE_TABLE)
                        .getJSONObject(ROZEMARIJNSTRAAT_TABLE)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(SATURDAY_TEXT);
                String english_rozemarijn_sunday = jsonObject
                        .getJSONObject(ENGLISH_LANGUAGE_TABLE)
                        .getJSONObject(ROZEMARIJNSTRAAT_TABLE)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(SUNDAY_TEXT);

                String english_stationsstraat_monday = jsonObject
                        .getJSONObject(ENGLISH_LANGUAGE_TABLE)
                        .getJSONObject(STATIONSSTRAAT_ESTABLISHMENT)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(MONDAY_TEXT);
                String english_stationsstraat_tuesday = jsonObject
                        .getJSONObject(ENGLISH_LANGUAGE_TABLE)
                        .getJSONObject(STATIONSSTRAAT_ESTABLISHMENT)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(TUESDAY_TEXT);
                String english_stationsstraat_wednesday = jsonObject
                        .getJSONObject(ENGLISH_LANGUAGE_TABLE)
                        .getJSONObject(STATIONSSTRAAT_ESTABLISHMENT)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(WEDNESDAY_TEXT);
                String english_stationsstraat_thursday = jsonObject
                        .getJSONObject(ENGLISH_LANGUAGE_TABLE)
                        .getJSONObject(STATIONSSTRAAT_ESTABLISHMENT)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(THURSDAY_TEXT);
                String english_stationsstraat_friday = jsonObject
                        .getJSONObject(ENGLISH_LANGUAGE_TABLE)
                        .getJSONObject(STATIONSSTRAAT_ESTABLISHMENT)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(FRIDAY_TEXT);
                String english_stationsstraat_saturday = jsonObject
                        .getJSONObject(ENGLISH_LANGUAGE_TABLE)
                        .getJSONObject(STATIONSSTRAAT_ESTABLISHMENT)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(SATURDAY_TEXT);
                String english_stationsstraat_sunday = jsonObject
                        .getJSONObject(ENGLISH_LANGUAGE_TABLE)
                        .getJSONObject(STATIONSSTRAAT_ESTABLISHMENT)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(SUNDAY_TEXT);

                String dutch_rozemarijn_monday = jsonObject
                        .getJSONObject(DUTCH_LANGUAGE_TABLE)
                        .getJSONObject(ROZEMARIJNSTRAAT_TABLE)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(MONDAY_TEXT);
                String dutch_rozemarijn_tuesday = jsonObject
                        .getJSONObject(DUTCH_LANGUAGE_TABLE)
                        .getJSONObject(ROZEMARIJNSTRAAT_TABLE)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(TUESDAY_TEXT);
                String dutch_rozemarijn_wednesday = jsonObject
                        .getJSONObject(DUTCH_LANGUAGE_TABLE)
                        .getJSONObject(ROZEMARIJNSTRAAT_TABLE)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(WEDNESDAY_TEXT);
                String dutch_rozemarijn_thursday = jsonObject
                        .getJSONObject(DUTCH_LANGUAGE_TABLE)
                        .getJSONObject(ROZEMARIJNSTRAAT_TABLE)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(THURSDAY_TEXT);
                String dutch_rozemarijn_friday = jsonObject
                        .getJSONObject(DUTCH_LANGUAGE_TABLE)
                        .getJSONObject(ROZEMARIJNSTRAAT_TABLE)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(FRIDAY_TEXT);
                String dutch_rozemarijn_saturday = jsonObject
                        .getJSONObject(DUTCH_LANGUAGE_TABLE)
                        .getJSONObject(ROZEMARIJNSTRAAT_TABLE)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(SATURDAY_TEXT);
                String dutch_rozemarijn_sunday = jsonObject
                        .getJSONObject(DUTCH_LANGUAGE_TABLE)
                        .getJSONObject(ROZEMARIJNSTRAAT_TABLE)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(SUNDAY_TEXT);

                String dutch_stationsstraat_monday = jsonObject
                        .getJSONObject(DUTCH_LANGUAGE_TABLE)
                        .getJSONObject(STATIONSSTRAAT_ESTABLISHMENT)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(MONDAY_TEXT);
                String dutch_stationsstraat_tuesday = jsonObject
                        .getJSONObject(DUTCH_LANGUAGE_TABLE)
                        .getJSONObject(STATIONSSTRAAT_ESTABLISHMENT)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(TUESDAY_TEXT);
                String dutch_stationsstraat_wednesday = jsonObject
                        .getJSONObject(DUTCH_LANGUAGE_TABLE)
                        .getJSONObject(STATIONSSTRAAT_ESTABLISHMENT)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(WEDNESDAY_TEXT);
                String dutch_stationsstraat_thursday = jsonObject
                        .getJSONObject(DUTCH_LANGUAGE_TABLE)
                        .getJSONObject(STATIONSSTRAAT_ESTABLISHMENT)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(THURSDAY_TEXT);
                String dutch_stationsstraat_friday = jsonObject
                        .getJSONObject(DUTCH_LANGUAGE_TABLE)
                        .getJSONObject(STATIONSSTRAAT_ESTABLISHMENT)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(FRIDAY_TEXT);
                String dutch_stationsstraat_saturday = jsonObject
                        .getJSONObject(DUTCH_LANGUAGE_TABLE)
                        .getJSONObject(STATIONSSTRAAT_ESTABLISHMENT)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(SATURDAY_TEXT);
                String dutch_stationsstraat_sunday = jsonObject
                        .getJSONObject(DUTCH_LANGUAGE_TABLE)
                        .getJSONObject(STATIONSSTRAAT_ESTABLISHMENT)
                        .getJSONObject(OPENING_HOURS_TABLE)
                        .getString(SUNDAY_TEXT);

                JSONArray dutch_special_hours_names_JSON_object = jsonObject
                        .getJSONObject(DUTCH_LANGUAGE_TABLE)
                        .getJSONObject(SPECIAL_OPENING_HOURS)
                        .getJSONArray(NAMES);

                dutch_special_hours_names = new ArrayList<>();

                for (int i = 0; i < dutch_special_hours_names_JSON_object.length(); i++){

                    dutch_special_hours_names.add(
                            dutch_special_hours_names_JSON_object.getString(i));

                }

                JSONArray dutch_special_hours_times_JSON_object = jsonObject
                        .getJSONObject(DUTCH_LANGUAGE_TABLE)
                        .getJSONObject(SPECIAL_OPENING_HOURS)
                        .getJSONArray(TIMES);

                dutch_special_hours_times = new ArrayList<>();

                for (int i = 0; i < dutch_special_hours_times_JSON_object.length(); i++){

                    dutch_special_hours_times.add(
                            dutch_special_hours_times_JSON_object.getString(i));

                }

                JSONArray english_special_hours_names_JSON_object = jsonObject
                        .getJSONObject(ENGLISH_LANGUAGE_TABLE)
                        .getJSONObject(SPECIAL_OPENING_HOURS)
                        .getJSONArray(NAMES);

                english_special_hours_names = new ArrayList<>();

                for (int i = 0; i < english_special_hours_names_JSON_object.length(); i++){

                    english_special_hours_names.add(
                            english_special_hours_names_JSON_object.getString(i));

                }

                JSONArray english_special_hours_times_JSON_object = jsonObject
                        .getJSONObject(ENGLISH_LANGUAGE_TABLE)
                        .getJSONObject(SPECIAL_OPENING_HOURS)
                        .getJSONArray(TIMES);

                english_special_hours_times = new ArrayList<>();

                for (int i = 0; i < english_special_hours_times_JSON_object.length(); i++){

                    english_special_hours_times.add(
                            english_special_hours_times_JSON_object.getString(i));

                }

            } catch (JSONException e) {

                e.printStackTrace();
            }

        }

    }

}
