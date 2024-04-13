package com.entecmedia.boendersfitness.models.daos;

import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

public interface OpeningHoursDao {

    // interface yet to be implemented and used

    @Query("SELECT * FROM (tafel)")
    void insertAllData();

    @Update
    void updateDutchOpeningHoursRS();
    @Update
    void updateDutchOpeningHoursSS();
    @Update
    void updateEnglishOpeningHoursRS();
    @Update
    void updateEnglishOpeningHoursSS();

}
