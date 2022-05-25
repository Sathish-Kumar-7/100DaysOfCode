package com.example.wordsapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.databinding.ItemLayoutBinding

class RecyclerViewWordAdapter(private val context: Context, private val char: Char) :RecyclerView.Adapter<RecyclerViewWordAdapter.RecyclerViewWordViewHolder>(){
    inner class RecyclerViewWordViewHolder(val binding: ItemLayoutBinding):RecyclerView.ViewHolder(binding.root)

    lateinit var fileredList:List<String>

    init {
        val words = context.resources.getStringArray(R.array.words)
        fileredList = words.asList().filter {
            it.startsWith(char,ignoreCase = true)
        }.sorted()
    }
    companion object {
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewWordViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RecyclerViewWordViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return fileredList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewWordViewHolder, position: Int) {
        val word = fileredList[position]
        holder.binding.letterButton.text = word
        holder.binding.letterButton.setOnClickListener {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("$SEARCH_PREFIX$word")
                )
            )
        }
    }
}