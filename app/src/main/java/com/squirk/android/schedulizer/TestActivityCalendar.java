package com.squirk.android.schedulizer;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract.Events;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;
import java.util.TimeZone;

public class TestActivityCalendar extends AppCompatActivity {

    private static final String LOG_TAG = TestActivityCalendar.class.getSimpleName();

    private static final int MY_PERMISSIONS_REQUEST_WRITE_CALENDAR = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_calendar);

        Button testButton = findViewById(R.id.test_button);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermission();
            }
        });
    }

    private void insertEvent(){
        Log.d(LOG_TAG,"Entering insertEvent() method.");

        // CODE SNIPPET FROM GOOGLE FOR CALENDAR PROVIDER INSERTION

        // TODO: figure out how to get the user's default calendar
        // code from the snippet. Why "3"?
//        long calID = 3;
        // trying this...
        long calId = 1;
//        long calID = CalendarContract.CalendarColumns.IS_PRIMARY + "=1"
        long startMillis = 0;
        long endMillis = 0;
        Calendar beginTime = Calendar.getInstance();

//        beginTime.set(2012, 9, 14, 7, 30);
        beginTime.set(Calendar.HOUR_OF_DAY,13);
        beginTime.set(Calendar.MINUTE,15);

        startMillis = beginTime.getTimeInMillis();
        Calendar endTime = Calendar.getInstance();

//        endTime.set(2012, 9, 14, 8, 45);
        endTime.set(Calendar.HOUR_OF_DAY, 14);
        endTime.set(Calendar.MINUTE,0);

        endMillis = endTime.getTimeInMillis();

        ContentResolver cr = getContentResolver();
        ContentValues values = new ContentValues();
        values.put(Events.DTSTART, startMillis);
        values.put(Events.DTEND, endMillis);
        values.put(Events.TITLE, "TEST EVENT INSERTED BY APP");
        values.put(Events.DESCRIPTION, "I need to drop Colin off at daycare");
        values.put(Events.CALENDAR_ID, calId);
//        values.put(Events.EVENT_TIMEZONE, "America/Los_Angeles");
        values.put(Events.EVENT_TIMEZONE, TimeZone.getDefault().getID());

        values.put(Events.AVAILABILITY, Events.AVAILABILITY_FREE);

        // TODO: FUTURE ADD: event color is complicated; need to use an option that's specific to that calendar
//        values.put(Events.EVENT_COLOR, );
        //TODO: ALSO ADD: notes (drop Colin off), event color, mark me as "free"

        Uri uri;
        try {
            uri = cr.insert(Events.CONTENT_URI, values);

            // get the event ID that is the last element in the Uri
            long eventID = Long.parseLong(uri.getLastPathSegment());

            //
            // ... do something with event ID
            //
            //
            Toast.makeText(this,"Check calendar to verify successful insertion",Toast.LENGTH_SHORT).show();
        } catch (SecurityException exception) {
            Log.e(LOG_TAG, "In insertEvent() method; WRITE_CALENDAR permission not granted.", exception);
        }
    }

    private void checkPermission() {
        // Check whether user has currently granted permission for app to write to calendar.
        // Note: This permission can be revoked, so need to check each time the write attempt is made.
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_CALENDAR)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            Toast.makeText(this, "Operation failed./n/nRequires user's permission to write to calendar.",
                    Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_CALENDAR},
                    MY_PERMISSIONS_REQUEST_WRITE_CALENDAR);
        } else {
            insertEvent();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_WRITE_CALENDAR: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // calendar-related task you need to do.
                    // TODO: CALL CALENDAR INSERT CODE
                    insertEvent();
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    // TODO: PRESENT DIALOG EXPLAINING ISSUE & PROMPTING AGAIN FOR PERMISSION?
                    Toast.makeText(this, "Operation failed./n/nRequires user's permission to write to calendar.",
                            Toast.LENGTH_SHORT).show();
                }
                return;
            }

        }
    }
}
