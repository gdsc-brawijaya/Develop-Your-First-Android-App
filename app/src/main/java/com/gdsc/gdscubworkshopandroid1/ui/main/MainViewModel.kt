package com.gdsc.gdscubworkshopandroid1.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gdsc.gdscubworkshopandroid1.model.PlantResponse
import retrofit2.Call
import retrofit2.Response
import androidx.lifecycle.ViewModel
import com.gdsc.gdscubworkshopandroid1.data.remote.ApiService
import com.gdsc.gdscubworkshopandroid1.data.remote.RetrofitService
import com.gdsc.gdscubworkshopandroid1.model.Plant
import com.gdsc.gdscubworkshopandroid1.util.Resource
import retrofit2.Callback

class MainViewModel: ViewModel() {

    private var api: ApiService = RetrofitService.build()
    private val _plants: MutableLiveData<Resource<List<Plant>>> = MutableLiveData()

    fun getAllPlants(): LiveData<Resource<List<Plant>>> {
        _plants.value = Resource.Loading()
        api.getAllPlants().enqueue(object : Callback<PlantResponse> {
            override fun onResponse(call: Call<PlantResponse>, response: Response<PlantResponse>) {
                _plants.value = Resource.Success(response.body()?.plants)
            }

            override fun onFailure(call: Call<PlantResponse>, t: Throwable) {
                _plants.value = Resource.Error("Something went wrong: $t")
            }

        })

        return _plants
    }
}