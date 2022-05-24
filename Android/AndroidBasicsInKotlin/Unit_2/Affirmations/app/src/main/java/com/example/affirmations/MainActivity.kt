package com.example.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.affirmations.data.Datasource
import com.example.affirmations.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dataSet = Datasource().loadAffirmations()
        binding.recyclerView.adapter = ItemAdapter(this,dataSet)
        binding.recyclerView.setHasFixedSize(true)
    }
}