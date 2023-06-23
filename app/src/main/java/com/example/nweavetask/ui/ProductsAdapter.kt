package com.example.nweavetask.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entities.Product
import com.example.nweavetask.R

class ProductsAdapter(val onClick: (Int) -> Unit) :
    ListAdapter<Product, ProductsAdapter.ProductsItemViewHolder>(ProductsDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsItemViewHolder =
        ProductsItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_item_layout, parent, false)
        )

    override fun onBindViewHolder(holder: ProductsItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.productImage.setOnClickListener {
            onClick(holder.adapterPosition)
        }
    }

    inner class ProductsItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productImage: ImageView = view.findViewById(R.id.product_iv)
        private val productPrice: TextView = view.findViewById(R.id.product_price_tv)
        private val productName: TextView = view.findViewById(R.id.product_name_tv)
        private val productDescription: TextView = view.findViewById(R.id.product_decription_tv)

        fun bind(item: Product) {
            Glide.with(itemView.context).load(item.imageUrl).into(productImage)
            productName.text = item.name
            productPrice.text = item.price
            productDescription.text = item.description

        }
    }

    class ProductsDiffUtil : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(
            oldItem: Product,
            newItem: Product
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Product,
            newItem: Product
        ): Boolean {
            return oldItem == newItem
        }
    }
}