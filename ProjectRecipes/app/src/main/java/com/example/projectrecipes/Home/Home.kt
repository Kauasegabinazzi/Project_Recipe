package com.example.projectrecipes.Home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectrecipes.Exit.Exit
import com.example.projectrecipes.ProductsListAdapter
import com.example.projectrecipes.R
import com.example.projectrecipes.models.Product
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStream

class Home : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Inicializa o RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this) // Define o layout manager

        // Lê o JSON e configura o adapter
        val products = read_json() // Retorna uma lista de Product
        val adapter = ProductsListAdapter(context = this, products = products)
        recyclerView.adapter = adapter

        // Configura o botão para a tela de saída
        val backgroundImage: Button = findViewById(R.id.homeButton)
        backgroundImage.setOnClickListener {
            val intent = Intent(this, Exit::class.java)
            startActivity(intent)
        }
    }

    // Função para ler e processar o JSON
    private fun read_json(): List<Product> {
        var json: String? = null

        try {
            val inputStream: InputStream = assets.open("First.json")
            json = inputStream.bufferedReader().use { it.readText() }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        // Usa Gson para converter o JSON em uma lista de objetos Product
        return if (json != null) {
            val listType = object : TypeToken<List<Product>>() {}.type
            Gson().fromJson(json, listType)
        } else {
            emptyList() // Retorna uma lista vazia se algo deu errado
        }
    }
}
