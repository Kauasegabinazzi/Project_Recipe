package com.example.projectrecipes.Home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.projectrecipes.Exit.Exit
import com.example.projectrecipes.ProductsListAdapter
import com.example.projectrecipes.R
import com.example.projectrecipes.models.Product


class Home : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var reclyclerView = findViewById<RecyclerView>(R.id.recycler)
        reclyclerView.adapter = ProductsListAdapter(context = this, products = listOf(
            Product(name = "teste", description = "teste desc",),
            Product(name = "teste2", description = "teste2 desc"),
            Product(name = "teste3", description = "teste3 desc",)
        ))

        val backgroundImage: Button = findViewById(R.id.homeButton)

        backgroundImage.setOnClickListener {
            val intent = Intent(this, Exit::class.java)
            startActivity(intent)
        }
    }
}