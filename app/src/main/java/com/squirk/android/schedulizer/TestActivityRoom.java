package com.squirk.android.schedulizer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TestActivityRoom extends AppCompatActivity {

    private Button mTestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_room);

        mTestButton = findViewById(R.id.test_button_room);
        mTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: CODE TO ADD A TEST SHIFT OBJECT TO THE ROOM DATABASE. (INSERT. QUERY. DISPLAY RETURNED LIST).
            }
        });
    }
}
