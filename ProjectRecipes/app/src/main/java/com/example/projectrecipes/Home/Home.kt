package com.example.projectrecipes.Home

import NumbersView
import NumbersViewAdapter
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import com.example.projectrecipes.Exit.Exit
import com.example.projectrecipes.R


class Home : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val backgroundImage: Button = findViewById(R.id.homeButton)

        backgroundImage.setOnClickListener {
            val intent = Intent(this, Exit::class.java)
            startActivity(intent)
        }
    }
}