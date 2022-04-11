package com.example.androidmobiletestapp.adapter

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidmobiletestapp.R
import com.example.androidmobiletestapp.activity.FormPlanetActivity
import com.example.androidmobiletestapp.data.PlanetResponse
import com.example.androidmobiletestapp.databinding.CardPlanetBinding


class PlanetViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = CardPlanetBinding.bind(view)

    fun render(planetModel: PlanetResponse, onClickListener: (PlanetResponse) -> Unit) {
        binding.tvDate.text = planetModel.date
        binding.tvCopyright.text = planetModel.copyright
        binding.tvTitle.text = planetModel.title
        Glide.with(binding.ivPlanet.context).load(planetModel.imageUrl).into(binding.ivPlanet)

        binding.ivPlanet.setOnClickListener {
            onClickListener(planetModel)
        }

        binding.btnEditPlanet.setOnClickListener {
            createFormPlanetActivity(planetModel)
        }
    }

    private fun createFormPlanetActivity(planetModel: PlanetResponse) {
        val intent = Intent(binding.btnEditPlanet.context, FormPlanetActivity::class.java)
        intent.putExtra("planetCopyright", planetModel.copyright)
        intent.putExtra("planetDate", planetModel.date)
        intent.putExtra("planetTitle", planetModel.title)
        intent.putExtra("planetImageUrl", planetModel.imageUrl)
        intent.putExtra("topAppBar", binding.btnEditPlanet.context.getString(R.string.edit_planet_app_bar))
        binding.btnEditPlanet.context.startActivity(intent)
    }
}