package com.gdsc.gdscubworkshopandroid1.data.remote

import com.gdsc.gdscubworkshopandroid1.model.Plant
import com.gdsc.gdscubworkshopandroid1.model.PlantResponse
import com.gdsc.gdscubworkshopandroid1.model.prediction.PredictionPost
import com.gdsc.gdscubworkshopandroid1.model.prediction.PredictionResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @GET("plant")
    fun getAllPlants(): Call<PlantResponse>

    @GET("plant/{id}")
    fun getPlantDetail(@Path("id") id: Int): Call<PlantResponse>

    @POST("prediction/predict")
    fun getPrediction(@Body predictionPost: PredictionPost): Call<PredictionResponse>
}