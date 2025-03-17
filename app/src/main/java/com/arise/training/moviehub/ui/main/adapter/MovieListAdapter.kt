package com.arise.training.moviehub.ui.main.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arise.training.moviehub.R
import com.arise.training.moviehub.databinding.ItemMovieBinding
import com.arise.training.moviehub.databinding.ItemPosterLargeBinding
import com.arise.training.moviehub.domain.Movie
import timber.log.Timber

class MovieListAdapter: ListAdapter<Movie, MovieListAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Timber.d("testapp onCreateViewHolder")
        return ViewHolder(
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Timber.d("testapp onBindViewHolder $position")
        holder.onBind(getItem(position))
    }

    class ViewHolder(val binding: ItemMovieBinding)
        : RecyclerView.ViewHolder(binding.root) {

            fun onBind(item: Movie) {
                Timber.d("testapp before bind ${binding.movieNameTv.text}")
                binding.moviePosterImv.setBackgroundResource(R.color.inactive_menu)
                binding.movieNameTv.text = item.title
                Timber.d("testapp after bind ${binding.movieNameTv.text}")
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