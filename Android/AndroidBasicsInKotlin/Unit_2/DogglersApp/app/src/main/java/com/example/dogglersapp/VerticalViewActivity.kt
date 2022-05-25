package com.example.dogglersapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogglersapp.data.DataSource
import com.example.dogglersapp.databinding.ActivityVerticalViewBinding
import com.example.dogglersapp.recyclerviewadapters.RecyclerViewVerticalHorizontalAdapter

class VerticalViewActivity : AppCompatActivity() {
    private lateinit var binding:ActivityVerticalViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerticalViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.verticalRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.verticalRecyclerView.adapter = RecyclerViewVerticalHorizontalAdapter(this,DataSource.dogs)
        binding.verticalRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.verticalRecyclerView.setHasFixedSize(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}