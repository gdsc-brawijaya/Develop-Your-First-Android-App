package com.gdsc.gdscubworkshopandroid1.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gdsc.gdscubworkshopandroid1.data.remote.ApiService
import com.gdsc.gdscubworkshopandroid1.data.remote.RetrofitService
import com.gdsc.gdscubworkshopandroid1.model.Plant
import com.gdsc.gdscubworkshopandroid1.model.PlantResponse
import com.gdsc.gdscubworkshopandroid1.util.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel: ViewModel() {

    private var api: ApiService = RetrofitService.build()
    private val _plant: MutableLiveData<Resource<Plant>> = MutableLiveData()

    fun getPlantDetail(id: Int): LiveData<Resource<Plant>> {
        _plant.value = Resource.Loading()
        api.getPlantDetail(id).enqueue(object : Callback<PlantResponse> {
            override fun onResponse(call: Call<PlantResponse>, response: Response<PlantResponse>) {
                _plant.value = Resource.Success(response.body()?.plant)
            }

            override fun onFailure(call: Call<PlantResponse>, t: Throwable) {
                _plant.value = Resource.Error("Something went wrong: $t")
            }

        })

        return _plant
    }
}