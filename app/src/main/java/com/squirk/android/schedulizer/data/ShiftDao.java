package com.squirk.android.schedulizer.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ShiftDao {
    // TODO: IMPLEMENT METHOD TO INSERT A NEW SHIFT OBJECT

    @Query("SELECT * FROM shifts")
    List<Shift> getAllShifts();

    @Insert
    void insertShift(Shift shift);
}
