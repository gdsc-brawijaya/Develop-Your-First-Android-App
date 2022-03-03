package com.gdsc.gdscubworkshopandroid1.ui.prediction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gdsc.gdscubworkshopandroid1.data.remote.RetrofitService
import com.gdsc.gdscubworkshopandroid1.model.prediction.PredictionBody
import com.gdsc.gdscubworkshopandroid1.model.prediction.PredictionResponse
import com.gdsc.gdscubworkshopandroid1.util.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PredictionViewModel : ViewModel() {

    private val api = RetrofitService.build()
    private val _prediction: MutableLiveData<Resource<PredictionResponse>> = MutableLiveData()

    fun getPrediction(body: PredictionBody): LiveData<Resource<PredictionResponse>> {
        _prediction.value = Resource.Loading()
        api.getPrediction(body).enqueue(object : Callback<PredictionResponse> {
            override fun onResponse(
                call: Call<PredictionResponse>,
                response: Response<PredictionResponse>
            ) {
                _prediction.value = Resource.Success(response.body())
            }

            override fun onFailure(call: Call<PredictionResponse>, t: Throwable) {
                _prediction.value = Resource.Error("Something went wrong: $t")
            }

        })

        return _prediction
    }
}