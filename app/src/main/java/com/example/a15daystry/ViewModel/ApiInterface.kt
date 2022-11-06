package com.example.a15daystry.ViewModel

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("entries")
    suspend fun getdata(): Response<PublicModel>

}