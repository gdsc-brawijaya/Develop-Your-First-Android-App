package com.gdsc.gdscubworkshopandroid1.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.gdsc.gdscubworkshopandroid1.ui.prediction.PredictionActivity
import com.gdsc.gdscubworkshopandroid1.R
import com.gdsc.gdscubworkshopandroid1.adapter.PlantAdapter
import com.gdsc.gdscubworkshopandroid1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var plantAdapter: PlantAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        plantAdapter = PlantAdapter()
        plantAdapter.setAllData(viewModel.getAllPlants())

        binding.rvPlant.apply {
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
                return true
            }
        }
        return super.onOptionsItemSelected(item);
    }
}