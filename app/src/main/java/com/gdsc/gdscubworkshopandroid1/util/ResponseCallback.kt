package com.gdsc.gdscubworkshopandroid1.util

import com.gdsc.gdscubworkshopandroid1.model.Plant
import com.gdsc.gdscubworkshopandroid1.model.predict.PredictionResponse

interface ResponseCallback {

    fun onLoading()
    fun onSuccess(plants: List<Plant>)
    fun onSuccess(plant: Plant)
    fun onSuccess(prediction: PredictionResponse)
    fun onFailed(message: String)
}