package com.example.dogglersapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.dogglersapp.data.DataSource
import com.example.dogglersapp.databinding.ActivityHorizontalViewBinding
import com.example.dogglersapp.recyclerviewadapters.RecyclerViewVerticalHorizontalAdapter

class HorizontalViewActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHorizontalViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHorizontalViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.horizontalRecyclerView.adapter = RecyclerViewVerticalHorizontalAdapter(this,DataSource.dogs)
        binding.horizontalRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.horizontalRecyclerView.setHasFixedSize(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}