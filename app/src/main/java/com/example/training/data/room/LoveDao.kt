package com.example.training.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.training.remote.LoveModel

@Dao
interface LoveDao {
    @Insert
    fun insert(loveModel:LoveModel)

    @Query("SELECT * FROM lovemodel ORDER BY fname ASC")
    fun getAll():List<LoveModel>
}