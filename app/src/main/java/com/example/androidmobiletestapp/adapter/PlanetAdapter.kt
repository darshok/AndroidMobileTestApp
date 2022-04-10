package com.example.androidmobiletestapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmobiletestapp.PlanetResponse
import com.example.androidmobiletestapp.R

class PlanetAdapter(private val planetList:List<PlanetResponse>): RecyclerView.Adapter<PlanetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PlanetViewHolder(layoutInflater.inflate(R.layout.card_planet, parent, false))
    }

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        val item = planetList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return planetList.size
    }
}