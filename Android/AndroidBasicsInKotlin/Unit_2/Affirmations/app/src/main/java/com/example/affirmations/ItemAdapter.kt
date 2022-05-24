package com.example.affirmations

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.databinding.ListItemBinding
import com.example.affirmations.model.Affirmation

class ItemAdapter (private val context: Context, private val dataset:List<Affirmation>):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
    class ItemViewHolder(val binding:ListItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.itemTitle.text = context.getString(dataset[position].stringResourceId)
        holder.binding.itemImage.setImageResource(dataset[position].imageResourceId)
    }
}