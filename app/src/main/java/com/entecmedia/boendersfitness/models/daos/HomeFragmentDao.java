package com.entecmedia.boendersfitness.models.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface HomeFragmentDao {

    // interface yet to be implemented and used

    @Query("SELECT * FROM (tafel)")
    void insertAllData();

    @Update
    void updateDutchRSMainText();
    @Update
    void updateDutchSSMainText();
    @Update
    void updateEnglishRSMainText();
    @Update
    void updateEnglishSSMainText();

}
