package com.example.recylerview

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.item_ecom.view.*

class ecomAdapter(val ecomView:ArrayList<ecom>)
    : RecyclerView.Adapter<ecomAdapter.ecomViewHolder>() {

    var onItemClick : ((ecom) -> Unit)? = null

    class ecomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val iv_itemImage = itemView.findViewById<ImageView>(R.id.iv_itemImage)
        val tv_itemHeader = itemView.findViewById<TextView>(R.id.tv_itemHeader)
        val tv_itemDescription = itemView.findViewById<TextView>(R.id.tv_itemDescription)
        val tv_itemPrice = itemView.findViewById<TextView>(R.id.tv_itemPrice)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ecomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ecom,parent,false)
        return ecomViewHolder(view)
    }

    override fun onBindViewHolder(holder: ecomViewHolder, position: Int) {
        val currentItem = ecomView[position]
        holder.iv_itemImage.setImageResource(currentItem.itemImage)
        holder.tv_itemHeader.text = currentItem.header
        holder.tv_itemDescription.text = currentItem.description
        holder.tv_itemPrice.text = currentItem.price

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return ecomView.size
    }
}
