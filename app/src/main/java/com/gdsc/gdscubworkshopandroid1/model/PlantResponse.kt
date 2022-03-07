package com.gdsc.gdscubworkshopandroid1.model

import com.squareup.moshi.Json

data class PlantResponse(
    @field:Json(name = "message")
    val message: String,

    @field:Json(name = "plants")
    val plants: List<Plant>,

    @field:Json(name = "plant")
    val plant: Plant
)
