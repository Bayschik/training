package com.example.training.view

import android.app.Application
import androidx.room.Room
import com.example.training.data.room.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App:Application() {
    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "love-file")
            .allowMainThreadQueries().build()
    }

    companion object{
        lateinit var db:AppDatabase
    }
}