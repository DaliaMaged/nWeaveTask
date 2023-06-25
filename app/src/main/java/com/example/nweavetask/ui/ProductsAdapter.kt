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
import com.example.domain.entities.ProductResponse
import com.example.nweavetask.R

class ProductsAdapter(val onClick: (Int) -> Unit) :
    ListAdapter<ProductResponse, ProductsAdapter.ProductsItemViewHolder>(ProductsDiffUtil()) {
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

        fun bind(item: ProductResponse) {
            Glide.with(itemView.context).load(item.products.imageUrl).into(productImage)
            productName.text = item.products.name
            productPrice.text = "${item.products.price}$"
            productDescription.text = item.products.description
        }
    }

    class ProductsDiffUtil : DiffUtil.ItemCallback<ProductResponse>() {
        override fun areItemsTheSame(
            oldItem: ProductResponse,
            newItem: ProductResponse
        ): Boolean {
            return oldItem.products.id == newItem.products.id
        }

        override fun areContentsTheSame(
            oldItem: ProductResponse,
            newItem: ProductResponse
        ): Boolean {
            return oldItem == newItem
        }
    }
}