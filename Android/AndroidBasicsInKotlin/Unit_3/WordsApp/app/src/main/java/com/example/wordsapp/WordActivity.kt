package com.example.wordsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordsapp.databinding.ActivityWordBinding

class WordActivity : AppCompatActivity() {
    private lateinit var binding:ActivityWordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.adapter = RecyclerViewWordAdapter(this,intent.extras?.getString("letter")?.first()?:' ')
        binding.recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
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
        binding.recyclerView.layoutManager = GridLayoutManager(this,2)
    }

    private fun changeLayoutToVertical() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }
}