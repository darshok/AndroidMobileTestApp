package com.example.androidmobiletestapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.androidmobiletestapp.databinding.ImageDialogBinding

class ImageDialogFragment: DialogFragment() {

    private lateinit var planetImage: ImageView
    private var _binding: ImageDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = ImageDialogBinding.inflate(inflater, container, false)
        planetImage = binding.ivPlanet

        val bundle = arguments
        val imageUrl = bundle!!.getString("imageUrl")

        Glide.with(binding.ivPlanet.context).load(imageUrl).into(binding.ivPlanet)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}