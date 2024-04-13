package com.entecmedia.boendersfitness.models.daos;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface InformationFragmentDao {

    // interface yet to be implemented and used

    @Query("SELECT * FROM (tafel)")
    void insertAllData();

    @Update
    void updateEmail();
    @Update
    void updatePhoneNumber();

}
