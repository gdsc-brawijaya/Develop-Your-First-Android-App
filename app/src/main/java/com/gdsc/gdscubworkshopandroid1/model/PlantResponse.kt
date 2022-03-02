package com.gdsc.gdscubworkshopandroid1.model

import com.squareup.moshi.Json

data class PlantResponse(
    @Json(name = "message")
    val message: String,

    @Json(name = "plants")
    val plants: List<Plant>,

    @Json(name = "plant")
    val plant: Plant
)
