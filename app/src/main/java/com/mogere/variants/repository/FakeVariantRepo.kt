package com.mogere.variants.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mogere.variants.Entity.Product

object FakeVariantRepo {

    val products: List<Product> = listOf(Product(1234, "Omo Washing Powder", 132.00),
            Product(123, "Geisha Washing Powder", 130.00))


    var _currentProduct = MutableLiveData<Product>()

    val currentProduct : LiveData<Product>
        get()= _currentProduct

    init {
        _currentProduct.value = products.first()
    }


    fun sendVariants(newProduct: Product){

    }
}