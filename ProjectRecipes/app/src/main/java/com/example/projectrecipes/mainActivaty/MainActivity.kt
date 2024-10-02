package com.example.projectrecipes.mainActivaty

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projectrecipes.Details.Details
import com.example.projectrecipes.R

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtenha o botão pelo ID
        val loginButton: Button = findViewById(R.id.loginButton)

        // Defina um listener para o clique do botão
        loginButton.setOnClickListener {
            // Crie uma Intent para iniciar a Details activity
            val newProduct = "Example Product"
            val intent = Intent(this, Details::class.java)
            startActivity(intent)
        }
    }
}