package com.example.training.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.training.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun getDao():LoveDao
}