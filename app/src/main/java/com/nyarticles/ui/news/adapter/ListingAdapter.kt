package com.nyarticles.ui.news.adapter

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.data.remote.models.NewsArticle
import com.nyarticles.R
import com.nyarticles.databinding.RowListingsBinding
import com.nyarticles.ui.base.adapter.BaseAdapter
import com.nyarticles.utils.BindingAdapters

class ListingAdapter(private val newArticleClickCallback: ((NewsArticle) -> Unit)?) :
    BaseAdapter<NewsArticle, RowListingsBinding>(NewsArticlesDiffCallback) {
    var imageOptions: RequestOptions = RequestOptions()
        .placeholder(R.drawable.img_loading_pics)
        .error(R.drawable.img_loading_pics)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .priority(Priority.HIGH)

    companion object {
        val NewsArticlesDiffCallback = object : DiffUtil.ItemCallback<NewsArticle>() {
            override fun areItemsTheSame(oldItem: NewsArticle, newItem: NewsArticle): Boolean {
                return oldItem.id == newItem.id
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: NewsArticle, newItem: NewsArticle): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    override fun createBinding(parent: ViewGroup): RowListingsBinding {
        val binding = DataBindingUtil.inflate<RowListingsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.row_listings,
            parent,
            false
        )
        binding.root.setOnClickListener {
            binding.newsArticle?.let {
                newArticleClickCallback?.invoke(it)
            }
        }
        return binding
    }

    override fun bind(binding: RowListingsBinding, item: NewsArticle) {
        binding.newsArticle = item
        item.media?.takeIf { it.isNotEmpty() }.let {
            it?.get(0)?.mediaMetadata?.get(0)?.url?.let { imgUrl ->
                BindingAdapters.showPhoto(binding.thumbIv, imgUrl)
            }
        }
    }
}