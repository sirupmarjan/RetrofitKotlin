package com.quick.datarecyclerfirebasekt.Model

import com.google.gson.annotations.SerializedName

data class Geo(

    @SerializedName("lat") val lat : Double,
    @SerializedName("lng") val lng : Double
)