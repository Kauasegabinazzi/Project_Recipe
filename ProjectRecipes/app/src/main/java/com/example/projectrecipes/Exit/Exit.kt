package com.example.projectrecipes.Exit

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import com.example.projectrecipes.ChangePassoword.ChangePassword
import com.example.projectrecipes.R
import com.example.projectrecipes.mainActivaty.MainActivity

class Exit : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exit)

        val changePasswordCard = findViewById<EditText>(R.id.senha)

        changePasswordCard.setOnClickListener {
            val intent = Intent(this, ChangePassword::class.java)
            startActivity(intent)
        }

        val changePasswordCard2 = findViewById<EditText>(R.id.sair)

        changePasswordCard2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}