package com.entecmedia.boendersfitness.models;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.entecmedia.boendersfitness.models.daos.AllOpeningHoursDao;
import com.entecmedia.boendersfitness.models.daos.HomeFragmentDao;
import com.entecmedia.boendersfitness.models.daos.InformationFragmentDao;
import com.entecmedia.boendersfitness.models.daos.OpeningHoursDao;

// Class yet to be implemented

/*

@Database(entities = AllData.class, version = 1)
public abstract class RoomDB extends RoomDatabase {

    private static RoomDB instance;

    public abstract AllOpeningHoursDao allOpeningHoursDao();

    public abstract HomeFragmentDao homeFragmentDao();

    public abstract OpeningHoursDao openingHoursDao();

    public abstract InformationFragmentDao informationFragmentDao();

    public static synchronized RoomDB getInstance(Context context) {

        if (instance == null) {

            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    RoomDB.class,
                    "all_data")
                    .fallbackToDestructiveMigration()
                    .build();

        }

        return instance;

    }

}

*/
