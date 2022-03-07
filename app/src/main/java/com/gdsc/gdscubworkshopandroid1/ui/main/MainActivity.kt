package com.gdsc.gdscubworkshopandroid1.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.gdsc.gdscubworkshopandroid1.ui.prediction.PredictionActivity
import com.gdsc.gdscubworkshopandroid1.R
import com.gdsc.gdscubworkshopandroid1.adapter.PlantAdapter
import com.gdsc.gdscubworkshopandroid1.databinding.ActivityMainBinding
import com.gdsc.gdscubworkshopandroid1.model.Plant
import com.gdsc.gdscubworkshopandroid1.model.predict.PredictionResponse
import com.gdsc.gdscubworkshopandroid1.util.Resource
import com.gdsc.gdscubworkshopandroid1.util.ResponseCallback

class MainActivity : AppCompatActivity(), ResponseCallback {
    private lateinit var binding: ActivityMainBinding
    private lateinit var plantAdapter: PlantAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        plantAdapter = PlantAdapter()
        viewModel.getAllPlants().observe(this) { resource ->
            when(resource) {
                is Resource.Loading -> onLoading()
                is Resource.Success -> resource.data?.let { onSuccess(it) }
                is Resource.Error -> resource.message?.let { onFailed(it) }
            }
        }

        binding.rvPlants.apply {
            adapter = plantAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.predict_menu -> {
                val intent = Intent(this, PredictionActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onLoading() {
        binding.pbMain.visibility = View.VISIBLE
    }

    override fun onSuccess(plants: List<Plant>) {
        binding.pbMain.visibility = View.INVISIBLE
        plantAdapter.setAllData(plants)
    }

    override fun onSuccess(plant: Plant) {
        TODO("Not yet implemented")
    }

    override fun onSuccess(prediction: PredictionResponse) {
        TODO("Not yet implemented")
    }

    override fun onFailed(message: String) {
        binding.pbMain.visibility = View.INVISIBLE
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}