package com.gdsc.gdscubworkshopandroid1.ui.detail

import androidx.lifecycle.ViewModel
import com.gdsc.gdscubworkshopandroid1.util.Dummy

class DetailViewModel: ViewModel() {

    fun getPlantDetail(id: Int) = Dummy.getDetailPlant(id)
}