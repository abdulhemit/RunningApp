package com.example.runningapp.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "running_table")
class Run (
    var img : Bitmap? = null,

    //zaman damgası
    var timestamp : Long = 0L,

    //ortalama hiz
    var avgSpeedInKMH : Float = 0f,

    //mesafe Metre
    var distanceInMeters : Int = 0,

    //zaman Mil olarak
    var timeInMillis : Long = 0L,

    //yakilan kalori
    var caloriesBurned : Int = 0
) {
    @PrimaryKey(autoGenerate = true)
    var id :Int? = null
}
