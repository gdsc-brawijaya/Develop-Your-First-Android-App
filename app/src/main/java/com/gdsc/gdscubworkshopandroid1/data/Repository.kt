package com.gdsc.gdscubworkshopandroid1.data

import com.gdsc.gdscubworkshopandroid1.data.remote.RetrofitService
import com.gdsc.gdscubworkshopandroid1.model.Plant
import com.gdsc.gdscubworkshopandroid1.model.predict.PredictionBody
import com.gdsc.gdscubworkshopandroid1.model.predict.PredictionResponse
import com.gdsc.gdscubworkshopandroid1.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class Repository {

    private val api = RetrofitService.build()

    fun getAllPlants() = flow<Resource<List<Plant>>> {
        emit(Resource.Loading())
        try {
            val plants = api.getAllPlants().plants
            emit(Resource.Success(plants))
        } catch (e:Exception) {
            emit(Resource.Error("Something went wrong: $e"))
        }
    }.flowOn(Dispatchers.IO)

    fun getPlantDetail(id: Int) = flow<Resource<Plant>> {
        emit(Resource.Loading())
        try {
            val plant = api.getPlantDetail(id).plant
            emit(Resource.Success(plant))
        } catch (e: Exception) {
            emit(Resource.Error("Something went wrong: $e"))
        }
    }.flowOn(Dispatchers.IO)

    fun getPrediction(body: PredictionBody) = flow<Resource<PredictionResponse>> {
        emit(Resource.Loading())
        try {
            val prediction = api.getPrediction(body)
            emit(Resource.Success(prediction))
        } catch (e: Exception) {
            emit(Resource.Error("Something went wrong: $e"))
        }
    }.flowOn(Dispatchers.IO)
}