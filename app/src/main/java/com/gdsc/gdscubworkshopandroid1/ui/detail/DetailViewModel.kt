package com.gdsc.gdscubworkshopandroid1.ui.detail

import androidx.lifecycle.ViewModel
import com.gdsc.gdscubworkshopandroid1.data.remote.ApiService
import com.gdsc.gdscubworkshopandroid1.data.remote.RetrofitService
import com.gdsc.gdscubworkshopandroid1.model.PlantResponse
import com.gdsc.gdscubworkshopandroid1.util.ResponseCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel: ViewModel() {

    private var api: ApiService = RetrofitService.build()

    fun getPlantDetail(id: Int, callback: ResponseCallback) {
        callback.onLoading()
        api.getPlantDetail(id).enqueue(object : Callback<PlantResponse> {
            override fun onResponse(call: Call<PlantResponse>, response: Response<PlantResponse>) {
                callback.onSuccess(response.body()?.plant)
            }

            override fun onFailure(call: Call<PlantResponse>, t: Throwable) {
                callback.onFailed("Something went wrong: $t")
            }

        })
    }
}