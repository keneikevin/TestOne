package com.pieme.wallet.adapter

/*
 * Copyright (c) 2022. Pietech limited, Pieme Project
 */


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testone.data.remote.response.comics.Result
import com.example.testone.databinding.ItemTransactionsBinding

class ComicsAdapter: RecyclerView.Adapter<ComicsAdapter.MainViewHolder>() {
    class MainViewHolder(val binding: ItemTransactionsBinding) : RecyclerView.ViewHolder(binding.root) {
    }
    var data = mutableListOf<Result>()
    var images = mutableListOf<String>()
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


        //  holder.binding.textView3.text = decimal.toString()
        holder.binding.success.text = data.title
      //  Log.d("alaa",data.images.get(0).path)


//        val path = data.images[0].path.toString()
//        val extension = data.images[0].extension.toString()
//        val tag = "$path"+"."+"$extension"
//
//     Log.d("tag",tag)
//        val options = RequestOptions()
//            .placeholder(R.drawable.person)
//            .error(R.drawable.person)
//        Glide.with(holder.itemView.context)
//            .load("$path+"."+"$extension")
//            .apply(options)
//            .into(holder.binding.itemTransactionImage)

    }


    override fun getItemCount(): Int {
        return data.size
    }
}