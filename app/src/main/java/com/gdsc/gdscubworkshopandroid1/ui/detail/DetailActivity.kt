package com.gdsc.gdscubworkshopandroid1.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.gdsc.gdscubworkshopandroid1.databinding.ActivityDetailBinding
import com.gdsc.gdscubworkshopandroid1.util.Dummy

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "ID"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra(EXTRA_ID, 0)
        val selectedPlant = Dummy.getDetailPlant(id)

        binding.apply {
            Glide.with(this@DetailActivity)
                .load(selectedPlant?.image)
                .into(ivPlant)
            tvPlantName.text = selectedPlant?.name
            tvPlantLatinName.text = selectedPlant?.latinName
            tvDescription.text = selectedPlant?.description
            tvPlace.text = selectedPlant?.location
            tvWatering.text = selectedPlant?.watering
            tvTemperature.text = selectedPlant?.temperature
        }
    }
}