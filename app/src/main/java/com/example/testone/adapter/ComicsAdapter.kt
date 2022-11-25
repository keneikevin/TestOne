package com.pieme.wallet.adapter

/*
 * Copyright (c) 2022. Pietech limited, Pieme Project
 */


import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.testone.R
import com.example.testone.databinding.ItemTransactionsBinding
import com.example.testone.domain.mappers.CharacterInfo
import com.pieme.wallet.ui.ComicsFragmentDirections

class ComicsAdapter: RecyclerView.Adapter<ComicsAdapter.MainViewHolder>() {
    class MainViewHolder(val binding: ItemTransactionsBinding) : RecyclerView.ViewHolder(binding.root) {
    }
    var data = mutableListOf<CharacterInfo>()
    fun setDataList(data: List<CharacterInfo>) {
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
        holder.binding.itemTransactionImage.setOnClickListener {

            val directions=ComicsFragmentDirections.actionHomeFragmentToDetailFragment(data)
            it.findNavController().navigate(directions)
        }
//        Glide.with(holder.itemView).setDefaultRequestOptions(RequestOptions()
//            .placeholder(R.drawable.person)
//            .dontAnimate()
//            .error(R.drawable.person)
//            .diskCacheStrategy(DiskCacheStrategy.DATA))
//            .load((data.thumbnail?.path ?:"" ) +"."+ (data.thumbnail?.extension ?:"" )).into(holder.binding.itemTransactionImage)

    }


    override fun getItemCount(): Int {
        return data.size
    }
}