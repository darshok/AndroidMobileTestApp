package com.example.androidmobiletestapp.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmobiletestapp.databinding.ActivityCreateNewPlanetBinding

class FormPlanetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateNewPlanetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateNewPlanetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.topAppBar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnCreatePlanet.setOnClickListener {
            Toast.makeText(this, "Planeta creado", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}