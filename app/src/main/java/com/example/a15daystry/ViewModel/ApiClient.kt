package com.example.a15daystry.ViewModel

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        var baseurl = "https://api.publicapis.org/"

        fun getRetrofit(): Retrofit? {

            return Retrofit.Builder().baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}