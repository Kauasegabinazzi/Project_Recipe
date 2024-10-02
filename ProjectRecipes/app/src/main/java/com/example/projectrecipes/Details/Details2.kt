package com.example.projectrecipes.Details

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.example.projectrecipes.R

class Details2 : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details2)

        val loginButton: Button = findViewById(R.id.nextButton3)

        loginButton.setOnClickListener {
            val intent = Intent(this, Details3::class.java)
            startActivity(intent)
        }
    }
}