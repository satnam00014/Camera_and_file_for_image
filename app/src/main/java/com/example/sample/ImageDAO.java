package com.example.sample;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ImageDAO {

    @Insert
    void insertImage(ImageEntity imageEntity);

    @Query("DELETE FROM images")
    void deleteAllImages();

    @Query("SELECT * FROM images")
    List<ImageEntity> getAllImages();

    @Update
    void updateImage(ImageEntity imageEntity);

    @Delete
    void deleteImage(ImageEntity imageEntity);

}