package com.mogere.variants

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mogere.variants.databinding.ActivityMainBinding
import com.mogere.variants.viewModel.VariantViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: VariantViewModel
    private lateinit var binding: ActivityMainBinding
    lateinit var variantEntered: String
    var variantPrice: Double = 0.0
    lateinit var variationList: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(VariantViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.variantViewModel = viewModel

        viewModel.variations.observe(this, Observer { newWord ->
            Toast.makeText(this, newWord, Toast.LENGTH_SHORT).show()
        })

        viewModel.variationList.observe(this, Observer { newWord ->
            Toast.makeText(this, newWord, Toast.LENGTH_SHORT).show()
        })
        viewModel.price.observe(this, Observer { newWord ->
            Toast.makeText(this, newWord, Toast.LENGTH_SHORT).show()
        })

        populateSpinner()

//        variantEntered = binding.variations.toString()
//        //variantPrice = binding.price.toString().toDouble()
//        variationList = binding.editTextVariationList.toString()



    }

    private fun populateSpinner() {
       var spinner = binding.variationSpinner
        ArrayAdapter.createFromResource(
                this,
                R.array.variation_types,
                android.R.layout.simple_spinner_item
        ).also{ adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}