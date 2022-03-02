package com.gdsc.gdscubworkshopandroid1.util

import com.gdsc.gdscubworkshopandroid1.model.Plant
import com.gdsc.gdscubworkshopandroid1.model.prediction.PredictionResponse

interface ResponseCallback {
    fun onLoading()
    fun onSuccess(plant: Plant?)
    fun onSuccess(list: List<Plant>)
    fun onSuccess(prediction: PredictionResponse)
    fun onFailed(message: String)
}