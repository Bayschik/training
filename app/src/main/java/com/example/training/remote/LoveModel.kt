package com.example.training.remote

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LoveModel(
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    val fname:String,
    val sname:String,
    val percentage:String,
    val result:String
){
    override fun toString(): String {
        return "\n $fname \n $sname \n $percentage \n $result \n"
    }
}
