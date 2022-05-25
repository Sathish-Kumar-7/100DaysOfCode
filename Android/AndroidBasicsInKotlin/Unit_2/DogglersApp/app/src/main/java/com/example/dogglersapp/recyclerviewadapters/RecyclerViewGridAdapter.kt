package com.example.dogglersapp.recyclerviewadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglersapp.R
import com.example.dogglersapp.databinding.GItemLayoutBinding
import com.example.dogglersapp.databinding.VhItemLayoutBinding
import com.example.dogglersapp.model.Dog

class RecyclerViewGridAdapter(private val context: Context,private val list:List<Dog>) :
    RecyclerView.Adapter<RecyclerViewGridAdapter.GridRecyclerViewVH>(){
        inner class GridRecyclerViewVH(val binding: GItemLayoutBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridRecyclerViewVH {
        val binding = GItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return GridRecyclerViewVH(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: GridRecyclerViewVH, position: Int) {
        holder.binding.imageViewG.setImageResource(list[position].imageResourceId)
        holder.binding.titleTextViewG.text = list[position].name
        holder.binding.ageTextViewG.text = context.getString(R.string.agetext,list[position].age)
        holder.binding.hobbiesTextViewG.text = context.getString(R.string.hobbiestext,list[position].hobbies)
    }
}