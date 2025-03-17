package com.arise.training.moviehub.ui.main.home.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arise.training.moviehub.R
import com.arise.training.moviehub.databinding.ItemPosterLargeBinding
import com.arise.training.moviehub.domain.Movie

class PosterLargeListAdapter: ListAdapter<Movie, PosterLargeListAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPosterLargeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class ViewHolder(val binding: ItemPosterLargeBinding)
        : RecyclerView.ViewHolder(binding.root) {

            fun onBind(item: Movie) {
                binding.posterImv.setBackgroundResource(R.color.inactive_menu)
            }
    }

    class DiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

    }
}