package com.example.wordsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.databinding.ItemLayoutBinding

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
            context.startActivity(
            Intent(context,WordActivity::class.java)
                .putExtra("letter",holder.binding.letterButton.text.toString())
            )
        }

    }
}