package com.example.projectrecipes.mainActivaty

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.projectrecipes.Details.Details
import com.example.projectrecipes.R
import com.google.firebase.auth.FirebaseAuth

class MainActivity : Activity() {

    // Inicializar FirebaseAuth
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialize o FirebaseAuth
        auth = FirebaseAuth.getInstance()

        // Referência aos elementos da UI
        val loginButton: Button = findViewById(R.id.loginButton)
        val usernameEditText: EditText = findViewById(R.id.usernameEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)

        // Configurar o click listener para o botão de login
        loginButton.setOnClickListener {
            val email = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            // Validar campos
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Autenticação do Firebase
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Login bem-sucedido
                        val intent = Intent(this, Details::class.java)
                        startActivity(intent)
                        finish()  // Opcional: para finalizar a activity de login
                    } else {
                        // Se falhar, exibe uma mensagem de erro
                        Toast.makeText(this, "Falha no login: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}
