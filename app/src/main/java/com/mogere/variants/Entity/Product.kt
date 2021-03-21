package com.mogere.variants.Entity

data class Product(var id: Long,
                   var name:String,
                   var basePrice: Double
                  ) {

    var size = mutableMapOf<String, Double>()
}