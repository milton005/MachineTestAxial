package com.pado.machinetest.UI.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pado.machinetest.Data.Models.Products.DataItem

import com.pado.machinetest.R
import kotlinx.android.synthetic.main.product_item_row.view.*

import javax.inject.Inject


class ProductAdapter @Inject constructor():ListAdapter<DataItem,ProductAdapter.ViewHolder>(ProductAdapter.DiffCallback()) {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val v=LayoutInflater.from(parent.context).inflate(R.layout.product_item_row,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val  item=getItem(position)
       holder.itemView.textRate.text=item.name


    }



    class DiffCallback : DiffUtil.ItemCallback<DataItem>() {

        override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem.id == newItem.id
        }

    }
}