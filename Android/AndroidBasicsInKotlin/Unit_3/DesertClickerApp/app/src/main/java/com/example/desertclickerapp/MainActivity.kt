package com.example.desertclickerapp

import android.content.ActivityNotFoundException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import com.example.desertclickerapp.databinding.ActivityMainBinding

const val KEY_REVENUE = "revenue_key"
const val KEY_DESSERT_SOLD = "dessert_sold_key"
const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    data class Dessert(val imageId: Int, val price: Int, val startProductionAmount: Int)
    private var revenue = 0
    private var dessertsSold = 0
    private val allDesserts = listOf(
        Dessert(R.drawable.cupcake, 5, 0),
        Dessert(R.drawable.donut, 10, 5),
        Dessert(R.drawable.eclair, 15, 20),
        Dessert(R.drawable.froyo, 30, 50),
        Dessert(R.drawable.gingerbread, 50, 100),
        Dessert(R.drawable.honeycomb, 100, 200),
        Dessert(R.drawable.icecreamsandwich, 500, 500),
        Dessert(R.drawable.jellybean, 1000, 1000),
        Dessert(R.drawable.kitkat, 2000, 2000),
        Dessert(R.drawable.lollipop, 3000, 4000),
        Dessert(R.drawable.marshmallow, 4000, 8000),
        Dessert(R.drawable.nougat, 5000, 16000),
        Dessert(R.drawable.oreo, 6000, 20000)
    )
    var currentDesert = allDesserts.first()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate Called")
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.dessertButton.setOnClickListener {
            onDessertClicked()
        }
        binding.revenue = revenue
        binding.amountSold = dessertsSold
        setContentView(binding.root)

    }

    private fun onDessertClicked() {
        revenue+=currentDesert.price
        dessertsSold++
        binding.revenue = revenue
        binding.amountSold = dessertsSold
        showCurrentDesert()
    }

    private fun showCurrentDesert() {
        var newDessert = allDesserts.first()
        for(dessert in allDesserts){
            if (dessertsSold >= dessert.startProductionAmount)
                newDessert = dessert
            else
                break
        }
        if (currentDesert != newDessert){
            currentDesert = newDessert
            binding.dessertButton.setImageResource(newDessert.imageId)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart Called")
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState Called")
        outState.putInt(KEY_REVENUE, revenue)
        outState.putInt(KEY_DESSERT_SOLD, dessertsSold)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.share_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share_icon -> onShare()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun onShare() {
        val shareIntent = ShareCompat.IntentBuilder.from(
            this
        ).setText(getString(R.string.share_text, dessertsSold, revenue))
            .setType("text/plain")
            .intent
        try {
            startActivity(shareIntent)
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(this, getString(R.string.sharing_not_available),
                Toast.LENGTH_LONG).show()
        }
    }
}