package com.example.projectrecipes.Home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.projectrecipes.Exit.Exit
import com.example.projectrecipes.ProductsListAdapter
import com.example.projectrecipes.R
import com.example.projectrecipes.models.Product
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream


class Home : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        read_json()

//        var reclyclerView = findViewById<RecyclerView>(R.id.recycler)
//        reclyclerView.adapter = ProductsListAdapter(
//            context = this, products = listOf(
//                Product(name = "teste", description = "teste desc"),
//                Product(name = "teste2", description = "teste2 desc"),
//                Product(name = "teste3", description = "teste3 desc"),
//                Product(name = "teste4", description = "teste4 desc"),
//                Product(name = "teste5", description = "teste6 desc"),
//                Product(name = "teste6", description = "teste7 desc")
//
//            )
//        )

//        val backgroundImage: Button = findViewById(R.id.homeButton)
//
//        backgroundImage.setOnClickListener {
//            val intent = Intent(this, Exit::class.java)
//            startActivity(intent)
//        }
    }

    fun read_json(){
        var json : String? = null

        try{
            val inputStream: InputStream = assets.open("First.json")
            json = inputStream.bufferedReader().use { it.readText() }


        }
        catch (e : IOException){

        }

    }
}