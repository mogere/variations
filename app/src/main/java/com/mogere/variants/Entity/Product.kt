package com.mogere.variants.Entity

data class Product(var id: Long,
                   var name:String,
                   var sizes:Map<String, Int>,
                   var flavor: Map<String, Int>) {
}