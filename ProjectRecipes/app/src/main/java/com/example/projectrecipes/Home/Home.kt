package com.example.projectrecipes.Home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
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
    private lateinit var adapter: ProductsListAdapter
    private lateinit var originalProducts: List<Product> // Lista completa de produtos

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Inicializa o RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Lê o JSON e configura o adapter
        originalProducts = read_json() // Lista completa
        adapter = ProductsListAdapter(this, originalProducts) // Inicializa o adapter
        recyclerView.adapter = adapter

        // Configura a pesquisa
        val searchEditText: EditText = findViewById(R.id.searchEditText)
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val query = s.toString().lowercase()
                val filteredProducts = originalProducts.filter {
                    it.name.lowercase().contains(query) || it.description.lowercase().contains(query)
                }
                adapter.updateList(filteredProducts) // Atualiza a lista no adapter
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

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
