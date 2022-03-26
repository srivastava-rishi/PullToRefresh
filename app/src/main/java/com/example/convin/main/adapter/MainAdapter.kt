package com.example.convin.main.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.convin.R
import com.example.convin.main.model.CardData

class MainAdapter(
    private var context: Context,
    )  : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list: MutableList<CardData> = mutableListOf()
    var logTag: String ="@MainAdapter"

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val number: TextView = view.findViewById(R.id.tvCardNumber)

        fun onBind(item: CardData, position: Int) {

            number.text = item.number.toString()
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).
        inflate(R.layout.view_card, parent, false)
        return   ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        if (holder is ItemViewHolder) {
            val item = list[position]
            holder.onBind(item,position)
        }else{

        }
    }

    fun update(data: CardData){
         list.add(data)
         notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

}