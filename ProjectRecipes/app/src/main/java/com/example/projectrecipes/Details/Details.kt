package com.example.projectrecipes.Details

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projectrecipes.R

class Details : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val loginButton: Button = findViewById(R.id.nextButton)

        loginButton.setOnClickListener {
            val intent = Intent(this, Details2::class.java)
            startActivity(intent)
        }
    }
}