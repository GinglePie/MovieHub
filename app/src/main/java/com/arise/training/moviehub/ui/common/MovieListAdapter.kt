package com.arise.training.moviehub.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arise.training.moviehub.R
import com.arise.training.moviehub.databinding.ItemMovieBinding
import com.arise.training.moviehub.domain.Movie
import com.bumptech.glide.Glide
import timber.log.Timber

class MovieListAdapter : ListAdapter<Movie, MovieListAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Timber.d("testapp onCreateViewHolder")
        return ViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Timber.d("testapp onBindViewHolder $position")
        holder.onBind(item = getItem(position))
    }

    class ViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Movie) {
            Timber.d("testapp before onBind ${binding.tileTv.text}")
            binding.tileTv.text = item.title
            Glide.with(binding.root.context)
                .load(item.posterUrl)
                .centerCrop()
                .placeholder(R.drawable.shape_radius_16)
                .error(R.drawable.shape_image_error)
                .into(binding.posterImv)
//            binding.posterImv.setBackgroundResource(R.drawable.poster)
            Timber.d("testapp after onBind ${binding.tileTv.text}")
        }

    }

    class DiffCallback: DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

    }

}