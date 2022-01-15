package com.example.kotlinnews.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinnews.R
import com.example.kotlinnews.databinding.ItemListDataBinding
import com.example.kotlinnews.models.NewsResponse

open class NewsAdapter(private val children: List<NewsResponse.Data.Children>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    var  context:Context?=null
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding :ItemListDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_list_data, parent, false
        )
        context = parent.context
        return ViewHolder(binding)


    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.tvTitle.text=children.get(position).data.subreddit
        holder.binding.tvBody.text=children.get(position).data.selftext
      //  Glide.with(Activity()).load(children.get(position).data.media_metadata.npfqmkwwegb81.m).into(holder.
     //   binding.ivImage)

        holder.itemView.setOnClickListener {




 //           var _data=children.get(position).data;
//            val bundle = Bundle()
//            bundle.putString("title",_data.subreddit)
//            bundle.putString("bode", _data.selftext)

//            val transaction =activity.supportFragmentManager.beginTransaction()
//            val newsDetailsFragment = NewsDetailsFragment()
////            transaction.replace(R.id.relativeLayout, newsDetailsFragment)
//            transaction.addToBackStack(null)
//            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//            transaction.commit()
////            val intent = Intent(context, NewsDetailsFragment::class.java)
////                intent.putExtra("title",_data.subreddit)
////                intent.putExtra("bode", _data.selftext)
//////                intent.putExtra("imgUrl", _data.media_metadata.npfqmkwwegb81.m)
////                context?.startActivity(intent)

            Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show()
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return children.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(var binding: ItemListDataBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}