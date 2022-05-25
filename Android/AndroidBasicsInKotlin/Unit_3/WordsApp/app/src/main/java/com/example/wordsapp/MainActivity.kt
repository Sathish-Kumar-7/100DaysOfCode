package com.example.wordsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.wordsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.recyclerView.adapter = RecyclerViewLetterAdapter(this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_change_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.layoutChanger) {
            if (item.title.equals("Grid")){
                item.icon = getDrawable(R.drawable.ic_linear_vertical)
                item.title= "Vertical"
                changeLayoutToGrid()
            }else{
                item.icon = getDrawable(R.drawable.ic_grid_view)
                item.title = "Grid"
                changeLayoutToVertical()
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun changeLayoutToGrid() {
        binding.recyclerView.layoutManager = GridLayoutManager(this,4)
    }

    private fun changeLayoutToVertical() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }
}