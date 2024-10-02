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

        val arrayList = ArrayList<NumbersView?>()


        // add all the values from 1 to 15 to the arrayList
        // the items are of the type NumbersView
        arrayList.add(NumbersView(R.drawable.image2, "1", "One"))
        arrayList.add(NumbersView(R.drawable.image2, "2", "Two"))
        arrayList.add(NumbersView(R.drawable.image2, "3", "Three"))
        arrayList.add(NumbersView(R.drawable.image2, "4", "Four"))
        arrayList.add(NumbersView(R.drawable.image2, "5", "Five"))
        arrayList.add(NumbersView(R.drawable.image2, "6", "Six"))
        arrayList.add(NumbersView(R.drawable.image2, "7", "Seven"))
        arrayList.add(NumbersView(R.drawable.image2, "8", "Eight"))
        arrayList.add(NumbersView(R.drawable.image2, "9", "Nine"))
        arrayList.add(NumbersView(R.drawable.image2, "10", "Ten"))
        arrayList.add(NumbersView(R.drawable.image2, "11", "Eleven"))
        arrayList.add(NumbersView(R.drawable.image2, "12", "Twelve"))
        arrayList.add(NumbersView(R.drawable.image2, "13", "Thirteen"))
        arrayList.add(NumbersView(R.drawable.image2, "14", "Fourteen"))
        arrayList.add(NumbersView(R.drawable.image2, "15", "Fifteen"))


        // Now create the instance of the NumebrsViewAdapter and pass
        // the context and arrayList created above
        val numbersArrayAdapter = NumbersViewAdapter(this, arrayList)


        // create the instance of the ListView to set the numbersViewAdapter
        val numbersListView = findViewById<ListView>(R.id.listView)


        // set the numbersViewAdapter for ListView
        numbersListView.adapter = numbersArrayAdapter
    }
}