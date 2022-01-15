package com.example.kotlinnews.ui.newsDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.kotlinnews.R
import com.example.kotlinnews.databinding.FragmentNewsDetailsBinding
import com.example.kotlinnews.ui.newsDetails.NewsDetailsFragmentArgs

class NewsDetailsFragment : Fragment(R.layout.fragment_news_details) {
    val args: NewsDetailsFragmentArgs by navArgs()
    lateinit var binding: FragmentNewsDetailsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsDetailsBinding.bind(view)
        binding.fragmentNewsDetailsTvTitle.text = args.title
        binding.fragmentNewsDetailsTvBode.text = args.bode


    }

}