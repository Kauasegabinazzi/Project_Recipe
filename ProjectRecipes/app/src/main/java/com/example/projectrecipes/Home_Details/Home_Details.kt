package com.example.projectrecipes.Home_Details

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.projectrecipes.Home.Home
import com.example.projectrecipes.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader

data class Recipe(
    val recipe_name: String,
    val description: String,
    val ingredients: List<String>,
    val method: String
)

class Home_Details : Activity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_details)

        // Receber o nome
       val recipeName = intent.getStringExtra("product_name")

        // busca a receita
        val recipes = loadRecipesFromJson()
       val recipe = recipes.find { it.recipe_name == recipeName }

        // alimenta os dados
        if (recipe != null) {
            findViewById<TextView>(R.id.recipe_name).text = recipe.recipe_name
            findViewById<TextView>(R.id.description_receive).text = recipe.description
            findViewById<TextView>(R.id.method_title).text = "Modo de Preparo"
            findViewById<TextView>(R.id.mode_prepare).text = recipe.method

            // adiciona a lista de ingredientes
            val ingredientsLayout = findViewById<LinearLayout>(R.id.ingredients_list)
            recipe.ingredients.forEach { ingredient ->
                val ingredientTextView = TextView(this).apply {
                    text = "- $ingredient"
                    textSize = 16f
                    setTextColor(resources.getColor(R.color.orange, theme))
                }
                ingredientsLayout.addView(ingredientTextView)
            }
        }

        val loginButton: Button = findViewById(R.id.nextButton7)

        loginButton.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }

    // pega o JSON
    private fun loadRecipesFromJson(): List<Recipe> {
        val inputStream = assets.open("Second.json")
        val reader = BufferedReader(InputStreamReader(inputStream))
        val json = reader.readText()
        reader.close()

        val type = object : TypeToken<List<Recipe>>() {}.type
        return Gson().fromJson(json, type)
    }
}
