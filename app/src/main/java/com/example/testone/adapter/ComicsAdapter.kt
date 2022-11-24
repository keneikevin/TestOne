package com.pieme.wallet.adapter

/*
 * Copyright (c) 2022. Pietech limited, Pieme Project
 */


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.testone.R
import com.example.testone.data.remote.response.comics.Result
import com.example.testone.databinding.ItemTransactionsBinding

class ComicsAdapter: RecyclerView.Adapter<ComicsAdapter.MainViewHolder>() {
    class MainViewHolder(val binding: ItemTransactionsBinding) : RecyclerView.ViewHolder(binding.root) {
    }
    var data = mutableListOf<Result>()
    fun setDataList(data: List<Result>) {
        this.data = data.toMutableList()

        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTransactionsBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val data = data[position]


        holder.binding.success.text = data.title

        Glide.with(holder.itemView).setDefaultRequestOptions(RequestOptions()
            .placeholder(R.drawable.person)
            .dontAnimate()
            .error(R.drawable.person)
            .diskCacheStrategy(DiskCacheStrategy.DATA))
            .load((data.thumbnail?.path ?:"" ) +"."+ (data.thumbnail?.extension ?:"" )).into(holder.binding.itemTransactionImage)

    }


    override fun getItemCount(): Int {
        return data.size
    }
}