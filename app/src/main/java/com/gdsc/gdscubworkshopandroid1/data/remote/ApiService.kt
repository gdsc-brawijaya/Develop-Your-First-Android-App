package com.gdsc.gdscubworkshopandroid1.data.remote

import com.gdsc.gdscubworkshopandroid1.model.PlantResponse
import com.gdsc.gdscubworkshopandroid1.model.predict.PredictionBody
import com.gdsc.gdscubworkshopandroid1.model.predict.PredictionResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @GET("plant")
    suspend fun getAllPlants(): PlantResponse

    @GET("plant/{id}")
    suspend fun getPlantDetail(@Path("id") id: Int): PlantResponse

    @POST("prediction/predict")
    suspend fun getPrediction(@Body body: PredictionBody): PredictionResponse
}