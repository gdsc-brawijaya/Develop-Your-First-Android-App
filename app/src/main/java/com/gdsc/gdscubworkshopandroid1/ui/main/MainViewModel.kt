package com.gdsc.gdscubworkshopandroid1.ui.main

import com.gdsc.gdscubworkshopandroid1.model.PlantResponse
import retrofit2.Call
import retrofit2.Response
import androidx.lifecycle.ViewModel
import com.gdsc.gdscubworkshopandroid1.data.remote.ApiService
import com.gdsc.gdscubworkshopandroid1.data.remote.RetrofitService
import com.gdsc.gdscubworkshopandroid1.model.Plant
import com.gdsc.gdscubworkshopandroid1.util.ResponseCallback
import retrofit2.Callback

class MainViewModel: ViewModel() {

    private var api: ApiService = RetrofitService.build()

    fun getAllPlants(callback: ResponseCallback) {
        callback.onLoading()
        api.getAllPlants().enqueue(object : Callback<PlantResponse> {
            override fun onResponse(call: Call<PlantResponse>, response: Response<PlantResponse>) {
                response.body()?.plants?.let { callback.onSuccess(it) }
            }

            override fun onFailure(call: Call<PlantResponse>, t: Throwable) {
                callback.onFailed("Something went wrong : $t")
            }

        })
    }
}