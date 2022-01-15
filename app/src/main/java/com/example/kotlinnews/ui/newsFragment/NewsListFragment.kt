package com.example.kotlinnews.ui.newsFragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.kotlinnews.R
import com.example.kotlinnews.databinding.FragmentNewsListBinding
import com.example.myapplication.utils.Resource

class NewsListFragment:Fragment(R.layout.fragment_news_list) {
    lateinit var viewModel: NewsListViewModel
    lateinit var binding: FragmentNewsListBinding
    lateinit var adapter: NewsRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewsListViewModel::class.java)
        binding = FragmentNewsListBinding.bind(view)
        /* adapter = NewsRecyclerAdapter(listOf(),object : NewsRecyclerAdapter.OnItemClick{
             override fun onClick(item: String) {

             }
         })*/
//        adapter = NewsRecyclerAdapter(listOf(),this){name->
//            onRecyclerClick(name)
//        }

        adapter = NewsRecyclerAdapter { dataChildren ->
            val action = NewsListFragmentDirections.actionNewsListFragmentToNewsDetailsFragment(
                dataChildren.data.subreddit,
            dataChildren.data.selftext)
            findNavController().navigate(action)

        }

        binding.fragmentNewsListRvListData.adapter = adapter

        subscribeToLiveData()
    }


    private fun subscribeToLiveData() {
        viewModel.newsLiveData.observe(viewLifecycleOwner){resource->

            when(resource.status){
                Resource.Status.LOADING->{
                    binding.progressBar.visibility=View.VISIBLE
                }
                Resource.Status.SUCCESS->{
                    binding.progressBar.visibility=View.INVISIBLE
                    val data = resource.data
                    if (data != null)
//                        adapter.changeData(data.data.children)
                        adapter.submitList(data!!.data.children)
                    else
                        Toast.makeText(activity, "", Toast.LENGTH_SHORT).show()
                }
                Resource.Status.ERROR->{
                    binding.progressBar.visibility=View.INVISIBLE
                    Toast.makeText(activity, "error ${resource.message}", Toast.LENGTH_SHORT).show()

                }
            }

        }
    }

//    override fun onClick(item: String) {
//        binding.textView.text = item
//    }
}