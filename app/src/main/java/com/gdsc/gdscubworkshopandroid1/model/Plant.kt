package com.gdsc.gdscubworkshopandroid1.model

import com.squareup.moshi.Json

data class Plant(
    @field:Json(name = "id")
    val id: Int = 0,

    @field:Json(name = "name")
    val name: String = "",

    @field:Json(name = "latin_name")
    val latinName: String = "",

    @field:Json(name = "description")
    val description: String = "",

    @field:Json(name = "watering")
    val watering: String = "",

    @field:Json(name = "temperature")
    val temperature: String = "",

    @field:Json(name = "place")
    val location: String = "",

    @field:Json(name = "image")
    val image: String = "",
)
