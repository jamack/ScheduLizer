package com.squirk.android.schedulizer.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "shifts")
public class Shift {

    // Unique identifier for shift
    @PrimaryKey(autoGenerate = true)
    private int mId;

    // Title/Location of shift
    @ColumnInfo(name = "title")
    private String mTitle;

    // Date of shift
    @ColumnInfo(name = "date")
    private Date mDate;

    // Start time of shift, in minutes that have passed since midnight
    @ColumnInfo(name = "start_time")
    private int mStartTime;

    // End time of shift, in minutes that have passed since midnight
    @ColumnInfo(name = "end_time")
    private int mEndTime;

    // Note(s) about the shift. Does NOT need to be stored in database.
    @Ignore
    private String mNote;

    // How many consecutive days have the same shift (start/end times). Does NOT need to be stored in database.
    @Ignore
    private int mRepeatedDays;

    // Whether a reminder is to be set. (Standard reminder time, as set in Preferences). Does NOT need to be stored in database.
    @Ignore
    private boolean mNeedsReminder;

    // Whether user is busy (e.g. their own shift) or free (e.g. partner's shift). Does NOT need to be stored in database.
    @Ignore
    private boolean mIsBusy;

    // Constructor for use by Room Persistence Library
    public Shift(int Id, String title, Date date, int startTime, int endTime) {
        mId = Id;
        mTitle = title;
        mDate = date;
        mStartTime = startTime;
        mEndTime = endTime;
    }

    // Constructor for standard use
    // @Ignore annotation tells Room Persistence Library NOT to use this constructor.
    // (Room needs to find ONE available constructor).
    public Shift(String title, Date date, int startTime, int endTime) {

        mTitle = title;
        mDate = date;
        mStartTime = startTime;
        mEndTime = endTime;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public int getStartTime() {
        return mStartTime;
    }

    public void setStartTime(int startTime) {
        mStartTime = startTime;
    }

    public int getEndTime() {
        return mEndTime;
    }

    public void setEndTime(int endTime) {
        mEndTime = endTime;
    }

    public String getNote() {
        return mNote;
    }

    public void setNote(String note) {
        mNote = note;
    }

    public int getRepeatedDays() {
        return mRepeatedDays;
    }

    public void setRepeatedDays(int repeatedDays) {
        mRepeatedDays = repeatedDays;
    }

    public boolean isNeedsReminder() {
        return mNeedsReminder;
    }

    public void setNeedsReminder(boolean needsReminder) {
        mNeedsReminder = needsReminder;
    }

    public boolean isBusy() {
        return mIsBusy;
    }

    public void setBusy(boolean busy) {
        mIsBusy = busy;
    }

    @Override
    public String toString() {
        return "Title: " + mTitle + "; "
                + "Date: " + mDate.toString() + "; "
                + "Start time (in minutes): " + Integer.toString(mStartTime) + "; "
                + "End time (in minutes): " + Integer.toString(mEndTime) + ".";

//        return super.toString();
    }
}
