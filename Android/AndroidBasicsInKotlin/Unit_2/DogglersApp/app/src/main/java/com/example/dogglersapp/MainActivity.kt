package com.example.dogglersapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dogglersapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.verticalButton.setOnClickListener {
            startActivity(Intent(this,VerticalViewActivity::class.java))
        }
        binding.horizontalButton.setOnClickListener {
            startActivity(Intent(this,HorizontalViewActivity::class.java))
        }
        binding.gridButton.setOnClickListener {
            startActivity(Intent(this,GridViewActivity::class.java))
        }
        setContentView(binding.root)

    }
}