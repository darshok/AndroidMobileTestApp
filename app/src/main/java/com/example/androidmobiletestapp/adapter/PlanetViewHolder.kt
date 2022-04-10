package com.example.androidmobiletestapp.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidmobiletestapp.PlanetResponse
import com.example.androidmobiletestapp.databinding.CardPlanetBinding


class PlanetViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = CardPlanetBinding.bind(view)
    private val date = binding.tvDate
    private val copyright = binding.tvCopyright
    private val title = binding.tvTitle
    private val planetImage = binding.ivPlanet

    fun render(planetModel: PlanetResponse) {
        date.text = planetModel.date
        copyright.text = planetModel.copyright
        title.text = planetModel.title
        Glide.with(planetImage.context).load(planetModel.imageUrl).into(planetImage)
    }
}