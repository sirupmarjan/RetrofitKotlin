package com.quick.datarecyclerfirebasekt.Retrofit

import com.quick.datarecyclerfirebasekt.Model.Users
import retrofit2.Call
import retrofit2.http.GET

interface NetworkInterfaces {
    @GET("Users")
    fun getUser() : Call<List<Users>>
}