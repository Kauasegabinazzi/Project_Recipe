package com.example.projectrecipes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectrecipes.models.Product

class ProductsListAdapter(private val context: Context, private val products: List<Product>) : RecyclerView.Adapter<ProductsListAdapter.ViewHolders>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsListAdapter.ViewHolders {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.produto_item,parent,false )
        return ViewHolders(view)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductsListAdapter.ViewHolders, position: Int) {
        val product = products[position]
        holder.vincula(product)
    }

    class ViewHolders(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(product: Product) {
            val name = itemView.findViewById<TextView>(R.id.name)
            name.text = product.name
            val description = itemView.findViewById<TextView>(R.id.descricao)
            description.text = product.description
        }
    }

}