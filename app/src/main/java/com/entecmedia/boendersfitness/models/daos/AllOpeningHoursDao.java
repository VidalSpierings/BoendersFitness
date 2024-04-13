package com.entecmedia.boendersfitness.models.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface AllOpeningHoursDao {

    // interface yet to be implemented and used

    @Query("SELECT * FROM (tafel)")
    void insertAllData();

    @Update
    void updateDutchSpecialTimesNamesAscensionDay();
    @Update
    void updateDutchSpecialTimesNamesCarnival();
    @Update
    void updateDutchSpecialTimesNamesChristmas();
    @Update
    void updateDutchSpecialTimesNamesDecember24th();
    @Update
    void updateDutchSpecialTimesNamesDecember5th();
    @Update
    void updateDutchSpecialTimesNamesEaster();
    @Update
    void updateDutchSpecialTimesNamesLiberationDay();
    @Update
    void updateDutchSpecialTimesNamesMonarchDay();
    @Update
    void updateDutchSpecialTimesNamesNewYearsDay();
    @Update
    void updateDutchSpecialTimesNamesNewYearsEve();
    @Update
    void updateDutchSpecialTimesNamesPentecost();

    @Update
    void updateDutchSpecialTimesTimesAscensionDay();
    @Update
    void updateDutchSpecialTimesTimesCarnival();
    @Update
    void updateDutchSpecialTimesTimesChristmas();
    @Update
    void updateDutchSpecialTimesTimesDecember24th();
    @Update
    void updateDutchSpecialTimesTimesDecember5th();
    @Update
    void updateDutchSpecialTimesTimesEaster();
    @Update
    void updateDutchSpecialTimesTimesLiberationDay();
    @Update
    void updateDutchSpecialTimesTimesMonarchDay();
    @Update
    void updateDutchSpecialTimesTimesNewYearsDay();
    @Update
    void updateDutchSpecialTimesTimesNewYearsEve();
    @Update
    void updateDutchSpecialTimesTimesPentecost();

    @Update
    void updateEnglishSpecialTimesNamesAscensionDay();
    @Update
    void updateEnglishSpecialTimesNamesCarnival();
    @Update
    void updateEnglishSpecialTimesNamesChristmas();
    @Update
    void updateEnglishSpecialTimesNamesDecember24th();
    @Update
    void updateEnglishSpecialTimesNamesDecember5th();
    @Update
    void updateEnglishSpecialTimesNamesEaster();
    @Update
    void updateEnglishSpecialTimesNamesLiberationDay();
    @Update
    void updateEnglishSpecialTimesNamesMonarchDay();
    @Update
    void updateEnglishSpecialTimesNamesNewYearsDay();
    @Update
    void updateEnglishSpecialTimesNamesNewYearsEve();
    @Update
    void updateEnglishSpecialTimesNamesPentecost();

    @Update
    void updateEnglishSpecialTimesTimesAscensionDay();
    @Update
    void updateEnglishSpecialTimesTimesCarnival();
    @Update
    void updateEnglishSpecialTimesTimesChristmas();
    @Update
    void updateEnglishSpecialTimesTimesDecember24th();
    @Update
    void updateEnglishSpecialTimesTimesDecember5th();
    @Update
    void updateEnglishSpecialTimesTimesEaster();
    @Update
    void updateEnglishSpecialTimesTimesLiberationDay();
    @Update
    void updateEnglishSpecialTimesTimesMonarchDay();
    @Update
    void updateEnglishSpecialTimesTimesNewYearsDay();
    @Update
    void updateEnglishSpecialTimesTimesNewYearsEve();
    @Update
    void updateEnglishSpecialTimesTimesPentecost();

}
