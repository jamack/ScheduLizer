package com.squirk.android.schedulizer.data;

import java.util.Date;

public class Shift {

    // Title/Location of shift
    private String mTitle;

    // Date of shift
    private Date mDate;

    // Start time of shift, in minutes that have passed since midnight
    private int mStartTime;

    // End time of shift, in minutes that have passed since midnight
    private int mEndTime;

    // Note(s) about the shift
    private String mNote;

    // How many consecutive days have the same shift (start/end times)
    private int mRepeatedDays;

    // Whether a reminder is to be set. (Standard reminder time, as set in Preferences)
    private boolean mNeedsReminder;

    // Whether user is busy (e.g. their own shift) or free (e.g. partner's shift)
    private boolean mIsBusy;

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
}
