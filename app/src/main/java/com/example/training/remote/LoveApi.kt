package com.example.training.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun getLove(
        @Query("fname") firstName:String,
        @Query("sname") secondName:String,
        @Header("X-RapidAPI-Key") key:String = "7753737404msh1de34a18e6f9f85p107731jsne1168a9b8ff3",
        @Header("X-RapidAPI-Host") host:String = "love-calculator.p.rapidapi.com",
    ):Call<LoveModel>
}