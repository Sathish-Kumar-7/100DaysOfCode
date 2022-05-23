package com.example.lemonadeapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var lemonTextView:TextView
    private lateinit var lemonImageView: ImageView
    private lateinit var actionTextList:List<String>
    private lateinit var actionImageList:List<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lemonTextView = findViewById(R.id.lemonActionTextView)
        lemonImageView = findViewById(R.id.lemonImageView)
        actionTextList = listOf(
            "Click To Select A Lemon !",
            "Click To Juice The Lemon !",
            "Click To Drink Your Lemonade !",
            "Click To Start Again !"
        )
        lemonTextView.text =actionTextList.first()
        actionImageList = listOf(
            R.drawable.lemon_tree,
            R.drawable.lemon_squeeze,
            R.drawable.lemon_drink,
            R.drawable.lemon_restart
        )
        lemonImageView.setImageResource(actionImageList.first())
        lemonImageView.setOnClickListener {
            nextState()
        }
    }

    private fun nextState() {
        val index = (actionTextList.indexOf(lemonTextView.text.toString())+1) %4
        lemonTextView.text = actionTextList[index]
        lemonImageView.setImageResource(actionImageList[index])
    }
}