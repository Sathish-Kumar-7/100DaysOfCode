package com.example.tipcalculator

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.calculateButton.setOnClickListener {
            val tipAmount = calculateTip()
            binding.calculatedTipAmount.visibility = View.VISIBLE
            binding.calculatedTipAmount.text = getString(R.string.tip_amount, NumberFormat.getCurrencyInstance().format(tipAmount))
        }
        setContentView(binding.root)

    }

    private fun calculateTip():Double {
        val editTextValue = binding.costEditText.text.toString()
        val costOfService = if (editTextValue.isNotEmpty()) editTextValue.toDouble() else null
        if (costOfService == null || costOfService.toString().toDouble() == 0.0)
            return 0.0
        val tipInterest = when(binding.radioGroup.checkedRadioButtonId){
            binding.amazingRadioButton.id -> 20
            binding.goodRadioButton.id -> 18
            else -> 15
        }
        val tipAmount = (costOfService.toDouble()/100)*tipInterest
        if (binding.roundUpSwitch.isChecked){
            return roundOfTip(tipAmount)
        }
        return tipAmount
    }

    private fun roundOfTip(tipAmount: Double): Double {
        return ceil(tipAmount)
    }
}