package com.example.runningapp.db

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface RunDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun()

    //Tarihe Göre Saklanan Tüm Çalışmaları al
    @Query("SELECT * FROM running_table ORDER BY timestamp DESC")
    fun getAllRunsStoredByDate():LiveData<List<Run>>

    //Zamana Göre Milli Saniyede Depolanan Tüm Çalışmaları Alın
    @Query("SELECT * FROM running_table ORDER BY timeInMillis DESC")
    fun getAllRunsStoredByTimeInMillis():LiveData<List<Run>>

    //Yakılan Kalorilere Göre Depolanan Tüm Koşuları Alın
    @Query("SELECT * FROM running_table ORDER BY caloriesBurned DESC")
    fun getAllRunsStoredByCaloriesBurned():LiveData<List<Run>>

    //ortalama hıza göre depolanan tüm çalıştırmaları al
    @Query("SELECT * FROM running_table ORDER BY avgSpeedInKMH DESC")
    fun getAllRunsStoredByAvgSpeed():LiveData<List<Run>>

    //Mesafeye Göre Kaydedilen Tüm Çalışmaları al
    @Query("SELECT * FROM running_table ORDER BY distanceInMeters DESC")
    fun getAllRunsStoredByDistance():LiveData<List<Run>>

    //Toplam Süreyi Mil Olarak Alın
    @Query("SELECT SUM(timeInMillis) FROM running_table")
    fun getTotalTimeInMillis():LiveData<Long>

    //Yakılan Toplam Kaloriyi Alın
    @Query("SELECT SUM(caloriesBurned) FROM running_table")
    fun getTotalCaloriesBurned():LiveData<Int>

    //Toplam mesafeyi al
    @Query("SELECT SUM(distanceInMeters) FROM running_table")
    fun getTotalDistance():LiveData<Int>

    //Toplam ortalama hızı al
    @Query("SELECT AVG(avgSpeedInKMH) FROM running_table")
    fun getTotalAvgSpeed():LiveData<Float>








}