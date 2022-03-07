package com.gdsc.gdscubworkshopandroid1.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.gdsc.gdscubworkshopandroid1.data.Repository

class DetailViewModel: ViewModel() {

    private val repository = Repository()

    fun getPlantDetail(id: Int) = repository.getPlantDetail(id).asLiveData()
}