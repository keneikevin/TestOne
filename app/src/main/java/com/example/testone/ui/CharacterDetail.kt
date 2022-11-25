package com.example.testone.ui


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.testone.R
import com.example.testone.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetail: Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding

    private val args:CharacterDetailArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDetailBinding.bind(view)
        binding.description.text = args.detail.description
        binding.textView.text = args.detail.title
        Glide.with(this.requireContext())
                    .load((args.detail.thumbnaill?.path ?:"" ) +"."+ (args.detail.thumbnaill?.extension ?:"" ))
            .into(binding.bigImage)


    }



}



