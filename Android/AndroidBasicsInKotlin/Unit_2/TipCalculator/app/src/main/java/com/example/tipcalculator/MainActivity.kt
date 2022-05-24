package com.example.tipcalculator

import android.content.Context
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
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
        binding.costEditText.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode)
        }
        return tipAmount
    }

    private fun roundOfTip(tipAmount: Double): Double {
        return ceil(tipAmount)
    }
    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}