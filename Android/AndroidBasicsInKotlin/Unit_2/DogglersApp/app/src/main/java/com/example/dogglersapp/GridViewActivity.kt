package com.example.dogglersapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.dogglersapp.data.DataSource
import com.example.dogglersapp.databinding.ActivityGridViewBinding
import com.example.dogglersapp.recyclerviewadapters.RecyclerViewGridAdapter

class GridViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGridViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGridViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.gridRecyclerView.adapter = RecyclerViewGridAdapter(this,DataSource.dogs)
        binding.gridRecyclerView.layoutManager = GridLayoutManager(this,2)
        binding.gridRecyclerView.setHasFixedSize(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}