package com.gdsc.gdscubworkshopandroid1.data.remote

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitService {

    fun build(): ApiService =
        Retrofit.Builder()
            .baseUrl("https://iris-gateway.herokuapp.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ApiService::class.java)
}