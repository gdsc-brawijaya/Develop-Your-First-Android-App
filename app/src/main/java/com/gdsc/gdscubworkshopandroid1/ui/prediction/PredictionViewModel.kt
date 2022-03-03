package com.gdsc.gdscubworkshopandroid1.ui.prediction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.gdsc.gdscubworkshopandroid1.data.Repository
import com.gdsc.gdscubworkshopandroid1.model.prediction.PredictionBody

class PredictionViewModel : ViewModel() {

    private val repository = Repository()

    fun getPrediction(body: PredictionBody) = repository.getPrediction(body).asLiveData()
}