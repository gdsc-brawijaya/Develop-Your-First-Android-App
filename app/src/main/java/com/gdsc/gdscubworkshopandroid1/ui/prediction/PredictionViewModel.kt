package com.gdsc.gdscubworkshopandroid1.ui.prediction

import androidx.lifecycle.ViewModel
import com.gdsc.gdscubworkshopandroid1.data.remote.RetrofitService
import com.gdsc.gdscubworkshopandroid1.model.prediction.PredictionPost
import com.gdsc.gdscubworkshopandroid1.model.prediction.PredictionResponse
import com.gdsc.gdscubworkshopandroid1.util.ResponseCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PredictionViewModel : ViewModel() {

    private val api = RetrofitService.build()

    fun getPrediction(body: PredictionPost, callback: ResponseCallback) {
        callback.onLoading()
        api.getPrediction(body).enqueue(object : Callback<PredictionResponse> {
            override fun onResponse(
                call: Call<PredictionResponse>,
                response: Response<PredictionResponse>
            ) {
                response.body()?.let { callback.onSuccess(it) }
            }

            override fun onFailure(call: Call<PredictionResponse>, t: Throwable) {
                callback.onFailed("Something went wrong: $t")
            }

        })
    }
}