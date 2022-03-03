package com.gdsc.gdscubworkshopandroid1.data

import android.util.Log
import com.gdsc.gdscubworkshopandroid1.data.remote.RetrofitService
import com.gdsc.gdscubworkshopandroid1.model.prediction.PredictionBody
import com.gdsc.gdscubworkshopandroid1.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class Repository {

    private val api = RetrofitService.build()

    fun getAllPlants() = flow {
        emit(Resource.Loading())
        try {
            val plants = api.getAllPlants().plants
            emit(Resource.Success(plants))
        } catch (e: Exception) {
            emit(Resource.Error("Something went wrong: $e"))
            Log.d("Get All Plants", e.toString())
        }
    }.flowOn(Dispatchers.IO)

    fun getPlantDetail(id: Int) = flow {
        emit(Resource.Loading())
        try {
            val plant = api.getPlantDetail(id).plant
            emit(Resource.Success(plant))
        } catch (e: Exception) {
            emit(Resource.Error("Something went wrong: $e"))
        }
    }.flowOn(Dispatchers.IO)

    fun getPrediction(body: PredictionBody) = flow {
        emit(Resource.Loading())
        try {
            val predict = api.getPrediction(body)
            emit(Resource.Success(predict))
        } catch (e: Exception) {
            emit(Resource.Error("Something went wrong: $e"))
        }
    }
}