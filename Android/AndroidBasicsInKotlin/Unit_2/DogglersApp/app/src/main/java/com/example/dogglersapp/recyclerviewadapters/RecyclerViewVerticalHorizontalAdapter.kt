package com.example.dogglersapp.recyclerviewadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglersapp.R
import com.example.dogglersapp.databinding.VhItemLayoutBinding
import com.example.dogglersapp.model.Dog

class RecyclerViewVerticalHorizontalAdapter(private val context:Context, private val list: List<Dog>) :RecyclerView.Adapter<RecyclerViewVerticalHorizontalAdapter.VerticalHorizontalRecyclerViewVH>(){
    inner class VerticalHorizontalRecyclerViewVH(val binding: VhItemLayoutBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalHorizontalRecyclerViewVH {
        val binding = VhItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return VerticalHorizontalRecyclerViewVH(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VerticalHorizontalRecyclerViewVH, position: Int) {
        holder.binding.imageViewVH.setImageResource(list[position].imageResourceId)
        holder.binding.titleTextViewVH.text = list[position].name
        holder.binding.ageTextViewVH.text = context.getString(R.string.agetext,list[position].age)
        holder.binding.hobbiesTextViewVH.text = context.getString(R.string.hobbiestext,list[position].hobbies)
    }
}