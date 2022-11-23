/*
 * Copyright (c) 2022. Pietech limited, Pieme Project
 */

package com.pieme.wallet.ui


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testone.R
import com.example.testone.databinding.FragmentTransactionsBinding
import com.example.testone.domain.HomeViewModel
import com.example.testone.util.Status
import com.pieme.wallet.adapter.ComicsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ComicsFragment : Fragment(R.layout.fragment_transactions){

    lateinit var binding: FragmentTransactionsBinding
    lateinit var viewModel: HomeViewModel
    val adapter = ComicsAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        binding = FragmentTransactionsBinding.bind(view)
        subscribetobservers()
        viewModel.getComics()
        viewModel.getComicDetails()


        binding.comicsRv.adapter = adapter
        binding.comicsRv.layoutManager = LinearLayoutManager(requireContext())


        viewModel.comics.observe(requireActivity(), Observer {
            Log.d("baba", it.toString())

            it.let { it1 -> adapter.setDataList(it1) }
        if(it.isNullOrEmpty())
            binding.empty.visibility = View.VISIBLE
        else binding.empty.visibility = View.GONE
        }
        )


    }

    private fun subscribetobservers(){
        viewModel.comicStatus.observe(viewLifecycleOwner) { result ->
            result?.let {
                when (result.status) {
                    Status.SUCCESS -> {

                        lifecycleScope.launch {
                            Log.d("Itvalue", it.toString())
                            }

                        binding.comicsRv.isVisible = true
                    }
                    Status.ERROR -> {

                        binding.comicsRv.isVisible = true
                    }
                    Status.LOADING -> {
                        binding.empty.visibility = View.GONE
                        binding.comicsRv.isVisible = false
                    }
                }
            }
        }
    }
}
