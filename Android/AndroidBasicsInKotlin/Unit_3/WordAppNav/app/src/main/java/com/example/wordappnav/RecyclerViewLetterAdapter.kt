package com.example.wordappnav

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.wordappnav.databinding.ItemLayoutBinding

class RecyclerViewLetterAdapter(private val context: Context):RecyclerView.Adapter<RecyclerViewLetterAdapter.RecyclerViewLetterViewHolder>() {
    private val list = ('A'..'Z').toList()

    inner class RecyclerViewLetterViewHolder(val binding: ItemLayoutBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewLetterViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RecyclerViewLetterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerViewLetterViewHolder, position: Int) {
        holder.binding.letterButton.text = list[position].toString()
        holder.binding.letterButton.setOnClickListener {
            val action = LetterFragmentDirections.actionLetterFragmentToWordFragment(
                holder.binding.letterButton.text.toString()
            )
            holder.itemView.findNavController().navigate(action)

        }

    }
}