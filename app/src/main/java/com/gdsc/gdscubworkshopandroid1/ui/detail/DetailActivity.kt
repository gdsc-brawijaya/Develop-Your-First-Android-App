package com.gdsc.gdscubworkshopandroid1.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.gdsc.gdsctoast.GDSCToast
import com.gdsc.gdsctoast.util.ToastType
import com.gdsc.gdscubworkshopandroid1.databinding.ActivityDetailBinding
import com.gdsc.gdscubworkshopandroid1.model.Plant
import com.gdsc.gdscubworkshopandroid1.model.prediction.PredictionResponse
import com.gdsc.gdscubworkshopandroid1.util.Resource
import com.gdsc.gdscubworkshopandroid1.util.ResponseCallback

class DetailActivity : AppCompatActivity(), ResponseCallback {

    companion object {
        const val EXTRA_ID = "ID"
    }

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

       viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        val id = intent.getIntExtra(EXTRA_ID, 0)
        viewModel.getPlantDetail(id).observe(this) {
            when (it) {
                is Resource.Loading -> onLoading()
                is Resource.Success -> onSuccess(it.data)
                is Resource.Error -> onFailed(it.message!!)
            }
        }

    }

    override fun onLoading() {
        binding.pbDetail.visibility = View.VISIBLE
    }

    override fun onSuccess(plant: Plant?) {
        binding.pbDetail.visibility = View.INVISIBLE
        Log.d("Plant Detail", plant.toString())
        binding.apply {
            Glide.with(this@DetailActivity)
                .load(plant?.image)
                .into(ivPlant)
            tvPlantName.text = plant?.name
            tvPlantLatinName.text = plant?.latinName
            tvDescription.text = plant?.description
            tvPlace.text = plant?.location
            tvWatering.text = plant?.watering
            tvTemperature.text = plant?.temperature
        }
    }

    override fun onSuccess(list: List<Plant>) {

    }

    override fun onSuccess(prediction: PredictionResponse) {

    }

    override fun onFailed(message: String) {
        binding.pbDetail.visibility = View.VISIBLE
        GDSCToast.showAnyToast(this) {
            it.apply {
                text = message
                toastType = ToastType.ERROR
            }
        }
    }
}