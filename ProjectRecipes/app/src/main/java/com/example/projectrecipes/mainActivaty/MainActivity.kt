package com.example.projectrecipes.mainActivaty

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.projectrecipes.Details.Details
import com.example.projectrecipes.ProductsListAdapter
import com.example.projectrecipes.R
import com.example.projectrecipes.models.Product

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton: Button = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            val intent = Intent(this, Details::class.java)
            startActivity(intent)
        }


    }
}