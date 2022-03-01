package com.gdsc.gdscubworkshopandroid1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.gdsc.gdscubworkshopandroid1.databinding.ActivityMainBinding

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
}