package com.example.androidmobiletestapp.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidmobiletestapp.PlanetResponse
import com.example.androidmobiletestapp.databinding.CardPlanetBinding


class PlanetViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = CardPlanetBinding.bind(view)

    fun render(planetModel: PlanetResponse) {
        binding.tvDate.text = planetModel.date
        binding.tvCopyright.text = planetModel.copyright
        binding.tvTitle.text = planetModel.title
        Glide.with(binding.ivPlanet.context).load(planetModel.imageUrl).into(binding.ivPlanet)
        binding.ivPlanet.setOnClickListener {
            Toast.makeText(
                binding.ivPlanet.context,
                planetModel.title,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}