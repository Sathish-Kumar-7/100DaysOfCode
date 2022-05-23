package com.example.dicerollerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        findViewById<Button>(R.id.rollButton).setOnClickListener {
//            findViewById<TextView>(R.id.diceNumberTextView).text =
//                (Math.random() * 6 + 1).toInt().toString()
//        }
        findViewById<Button>(R.id.rollButton).setOnClickListener {
            rollDice()
        }
    }
    private fun rollDice(){
        findViewById<ImageView>(R.id.diceImage).setImageResource(
            when((1..6).random()){
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else -> R.drawable.dice_1
            }
        )
    }
}