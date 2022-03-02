package com.gdsc.gdscubworkshopandroid1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import com.gdsc.gdscubworkshopandroid1.ui.prediction.PredictionActivity
import com.gdsc.gdscubworkshopandroid1.R
import com.gdsc.gdscubworkshopandroid1.adapter.PlantAdapter
import com.gdsc.gdscubworkshopandroid1.databinding.ActivityMainBinding
import com.gdsc.gdscubworkshopandroid1.util.Dummy

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var plantAdapter: PlantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        plantAdapter = PlantAdapter()
        plantAdapter.setAllData(Dummy.getAllPlants())

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