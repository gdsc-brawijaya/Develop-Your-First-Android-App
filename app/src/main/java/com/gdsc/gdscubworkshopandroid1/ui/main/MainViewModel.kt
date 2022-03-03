package com.gdsc.gdscubworkshopandroid1.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.gdsc.gdscubworkshopandroid1.data.Repository

class MainViewModel: ViewModel() {

    private val repository = Repository()

    fun getAllPlants() = repository.getAllPlants().asLiveData()
}