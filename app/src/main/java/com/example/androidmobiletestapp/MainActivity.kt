package com.example.androidmobiletestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidmobiletestapp.adapter.PlanetAdapter
import com.example.androidmobiletestapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PlanetAdapter
    private val planetImages = mutableListOf<PlanetResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = PlanetAdapter(planetImages) { planetResponse -> onItemClicked(planetResponse) }
        binding.rvPlanets.layoutManager = LinearLayoutManager(this)
        binding.rvPlanets.adapter = adapter
        searchByCount("100")
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/planetary/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchByCount(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java)
                .getPlanetsByCount("apod?api_key=DEMO_KEY&count=$query")
            val planetsArray = call.body()
            runOnUiThread {
                if (call.isSuccessful && planetsArray != null) {
                    planetImages.clear()
                    for (planet in planetsArray) {
                        val imageUrl = planet.imageUrl ?: ""
                        val date = planet.date ?: ""
                        val copyright = planet.copyright ?: ""
                        val title = planet.title ?: ""
                        planetImages.add(PlanetResponse(date, copyright, title, imageUrl))
                    }
                    adapter.notifyDataSetChanged()
                } else {
                    showError()
                }
            }
        }
    }

    private fun showError() {
        Toast.makeText(this, "Error getting planets", Toast.LENGTH_SHORT).show()
    }

    private fun onItemClicked(planetResponse: PlanetResponse) {
        Toast.makeText(this, planetResponse.title, Toast.LENGTH_SHORT).show()
    }
}