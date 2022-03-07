package com.gdsc.gdscubworkshopandroid1.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.gdsc.gdscubworkshopandroid1.databinding.ActivityDetailBinding
import com.gdsc.gdscubworkshopandroid1.model.Plant
import com.gdsc.gdscubworkshopandroid1.model.predict.PredictionResponse
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
        viewModel.getPlantDetail(id).observe(this) { resource ->
            when(resource) {
                is Resource.Loading -> onLoading()
                is Resource.Success -> resource.data?.let { onSuccess(it) }
                is Resource.Error -> resource.message?.let { onFailed(it) }
            }
        }

    }

    override fun onLoading() {
        binding.pbDetail.visibility = View.VISIBLE
    }

    override fun onSuccess(plants: List<Plant>) {
        TODO("Not yet implemented")
    }

    override fun onSuccess(plant: Plant) {
        binding.pbDetail.visibility = View.INVISIBLE

        binding.apply {
            Glide.with(this@DetailActivity)
                .load(plant.image)
                .into(ivPlant)
            tvPlantName.text = plant.name
            tvPlantLatinName.text = plant.latinName
            tvDescription.text = plant.description
            tvPlace.text = plant.location
            tvWatering.text = plant.watering
            tvTemperature.text = plant.temperature
        }
    }

    override fun onSuccess(prediction: PredictionResponse) {
        TODO("Not yet implemented")
    }

    override fun onFailed(message: String) {
        binding.pbDetail.visibility = View.INVISIBLE
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}