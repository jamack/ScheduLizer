package com.squirk.android.schedulizer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.squirk.android.schedulizer.data.Shift;
import com.squirk.android.schedulizer.data.ShiftsDatabase;

import java.util.Date;
import java.util.List;

public class TestActivityRoom extends AppCompatActivity {

    private static final String LOG_TAG = TestActivityRoom.class.getSimpleName();

    private Button mTestButton;

    Shift testShift;
    ShiftsDatabase shiftsDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_room);

        // Create parameters for test Shift object
        String testTitle = "Liz works in Sun Prairie";
        Date testDate = new Date();
        int testStartTime = 9 * 60;
        int testEndTime = 13 * 60;
        testShift = new Shift(testTitle, testDate, testStartTime, testEndTime);

        shiftsDb = ShiftsDatabase.getShiftsDatabase(getApplicationContext());

        mTestButton = findViewById(R.id.test_button_room);
        mTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: CODE TO ADD A TEST SHIFT OBJECT TO THE ROOM DATABASE. (INSERT. QUERY. DISPLAY RETURNED LIST).
                Log.d(LOG_TAG, "Inserting sample Shift to database...");
                shiftsDb.shiftDao().insertShift(testShift);

                Log.d(LOG_TAG,"Querying the database...");
                List<Shift> queriedShifts = shiftsDb.shiftDao().getAllShifts();
                Toast.makeText(getApplicationContext(),queriedShifts.get(0).toString(),Toast.LENGTH_LONG).show();
                Log.d(LOG_TAG,"First queried Shift: " + queriedShifts.get(0).toString());
            }
        });
    }
}
