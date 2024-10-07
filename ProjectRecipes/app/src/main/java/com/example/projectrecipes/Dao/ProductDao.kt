package com.example.projectrecipes.Dao

import com.example.projectrecipes.models.Product

class ProductDao {

    private val products = mutableListOf<Product>()

    fun add(product: Product){
        products.add(product);
    }

    fun searchAll() : List<Product>{
        return products.toList()
    }

}