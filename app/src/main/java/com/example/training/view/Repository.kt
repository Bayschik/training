package com.example.training.view

import androidx.lifecycle.MutableLiveData
import com.example.training.remote.LoveApi
import com.example.training.remote.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api:LoveApi){
    fun getData(firstName:String, secondName:String):MutableLiveData<LoveModel>{
        val love = MutableLiveData<LoveModel>()

        api.getLove(firstName, secondName).enqueue(object : Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful){
                    response.body().let {
                        love.postValue(it)
                    }
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {}
        })
        return love
    }
}