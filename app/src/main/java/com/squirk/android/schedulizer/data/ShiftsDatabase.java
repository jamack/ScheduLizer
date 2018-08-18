package com.squirk.android.schedulizer.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Shift.class}, version = 1)
public abstract class ShiftsDatabase extends RoomDatabase {

    // Instance reference for Singleton pattern
    private static ShiftsDatabase INSTANCE;

    public abstract ShiftDao shiftDao();

    public static ShiftsDatabase getShiftsDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), ShiftsDatabase.class, "shifts")
                            // TODO: REMOVE THIS PROPERTY ONCE DONE TESTING
                            // allow queries on the main thread. Don't do this on a real app!
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
