package com.example.training.di

import android.content.Context
import android.content.SharedPreferences
import com.example.training.data.local.Pref
import com.example.training.remote.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideApi():LoveApi{
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    fun providePreference(@ApplicationContext context: Context):SharedPreferences{
        return context.getSharedPreferences(Pref.PREF_KEY, Context.MODE_PRIVATE)
    }

}