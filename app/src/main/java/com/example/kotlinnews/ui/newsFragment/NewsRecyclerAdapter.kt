package com.example.kotlinnews.ui.newsFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinnews.databinding.ItemListDataBinding
import com.example.kotlinnews.models.NewsResponse.Data.Children

class NewsRecyclerAdapter (val listener:(Children)->Unit) :
    ListAdapter<Children,NewsRecyclerAdapter.ViewHolder>(ChildrenDiffUtil()) {


    inner class ViewHolder(val binding:ItemListDataBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Children)
        {
            binding.apply {
                tvTitle.text=item.data.subreddit
                tvBody.text=item.data.selftext
                itemView.setOnClickListener {
                    listener.invoke(item)
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemListDataBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =holder.bind(currentList[position])


    private class ChildrenDiffUtil: DiffUtil.ItemCallback<Children>()
    {
        override fun areItemsTheSame(
            oldItem: Children,
            newItem: Children
        ): Boolean {
            TODO("Not yet implemented")
            return oldItem.data.subreddit==newItem.data.subreddit &&
                    oldItem.data.selftext==newItem.data.selftext

        }
        override fun areContentsTheSame(
            oldItem: Children,
            newItem: Children
        ): Boolean {
            TODO("Not yet implemented")
            return oldItem.data.subreddit==newItem.data.subreddit &&
                    oldItem.data.selftext==newItem.data.selftext
        }

    }


    }