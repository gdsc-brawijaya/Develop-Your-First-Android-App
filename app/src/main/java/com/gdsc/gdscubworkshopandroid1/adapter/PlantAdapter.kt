package com.gdsc.gdscubworkshopandroid1.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gdsc.gdscubworkshopandroid1.ui.detail.DetailActivity
import com.gdsc.gdscubworkshopandroid1.model.Plant
import com.gdsc.gdscubworkshopandroid1.databinding.ItemListBinding

class PlantAdapter: RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {

    private val listOfPlant = ArrayList<Plant>()

    fun setAllData(list: List<Plant>) {
        listOfPlant.apply {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }

    inner class PlantViewHolder(private val view: ItemListBinding): RecyclerView.ViewHolder(view.root) {
        fun bind(plant: Plant) {
            Glide.with(itemView.context)
                .load(plant.image)
                .into(view.ivPlant)

            view.apply {
                tvName.text = plant.name
                tvLatinName.text = plant.latinName
            }

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_ID, plant.id)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlantViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        holder.bind(listOfPlant[position])
    }

    override fun getItemCount(): Int {
        return listOfPlant.size
    }
}