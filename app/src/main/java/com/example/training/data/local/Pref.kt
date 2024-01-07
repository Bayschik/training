package com.example.training.data.local

import android.content.SharedPreferences
import javax.inject.Inject

class Pref @Inject constructor(private val pref: SharedPreferences) {

    fun isShow():Boolean{
        return pref.getBoolean(SHOW_KEY, false)
    }

    fun onShowed(){
        pref.edit().putBoolean(SHOW_KEY, true).apply()
    }

    companion object{
        const val PREF_KEY = "pref.key"
        const val SHOW_KEY = "show.key"
    }
}