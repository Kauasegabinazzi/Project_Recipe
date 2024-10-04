package com.example.projectrecipes.ChangePassoword

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.example.projectrecipes.R
import com.example.projectrecipes.mainActivaty.MainActivity

class ChangePassword : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        val changePasswordCard2 = findViewById<Button>(R.id.loginButton)

        changePasswordCard2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}