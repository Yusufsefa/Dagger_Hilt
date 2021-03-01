package com.yyusufsefa.dependencyinjection.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yyusufsefa.dependencyinjection.data.model.Movie
import com.yyusufsefa.dependencyinjection.data.model.MovieItemViewState
import com.yyusufsefa.dependencyinjection.databinding.ItemMovieBinding

class MovieAdapter : ListAdapter<Movie, MovieAdapter.MovieViewHolder>(DiffCallBack) {

    private var onItemClickListener: ((Movie) -> Unit)? = null

    fun setOnItemClickListener(onItemClickListener: ((Movie) -> Unit)) {
        this.onItemClickListener = onItemClickListener
    }

    class MovieViewHolder(private val movieBinding: ItemMovieBinding) :
        RecyclerView.ViewHolder(movieBinding.root) {

        fun bind(movie: Movie, onItemClickListener: (Movie) -> Unit) {

            movieBinding.apply {
                this.itemViewState = MovieItemViewState(movie)
                root.setOnClickListener { onItemClickListener.invoke(movie) }
            }
        }

    }

    companion object {
        val DiffCallBack = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem.Title == newItem.Title

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) =
        holder.bind(getItem(position), onItemClickListener!!)

}