package com.example.sample;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ImageEntity.class},version = 1,exportSchema = false)
public abstract class ImageDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "Image_Database";

    public abstract ImageDAO imageDAO();

    private static volatile ImageDatabase INSTANCE;

    public static ImageDatabase getInstance(Context context) {
        if (INSTANCE == null)
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ImageDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        return INSTANCE;
    }

}
