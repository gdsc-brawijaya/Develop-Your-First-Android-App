package com.gdsc.gdscubworkshopandroid1.model.prediction

import com.squareup.moshi.Json

data class PredictionBody(
    @field:Json(name = "sepal_length")
    val sepalLength: Double,

    @field:Json(name = "sepal_width")
    val sepalWidth: Double,

    @field:Json(name = "petal_length")
    val petalLength: Double,

    @field:Json(name = "petal_width")
    val petalWidth: Double,
)
