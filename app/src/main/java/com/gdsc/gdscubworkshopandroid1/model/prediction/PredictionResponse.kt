package com.gdsc.gdscubworkshopandroid1.model.prediction

import com.squareup.moshi.Json

data class PredictionResponse(
    @field:Json(name = "prediction")
    val prediction: Int
)
