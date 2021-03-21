package com.mogere.variants

import android.os.Bundle
import android.text.Editable
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

//        viewModel.variations.observe(this, Observer { newWord ->
//            Toast.makeText(this, newWord, Toast.LENGTH_SHORT).show()
//        })
//
//
//        viewModel.price.observe(this, Observer { newWord ->
//            Toast.makeText(this, newWord, Toast.LENGTH_SHORT).show()
//        })



    }

//    private fun populateSpinner() {
//       var spinner = binding.variationSpinner
//        ArrayAdapter.createFromResource(
//                this,
//                R.array.variation_types,
//                android.R.layout.simple_spinner_item
//        ).also{ adapter ->
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            spinner.adapter = adapter
//        }
//    }


}