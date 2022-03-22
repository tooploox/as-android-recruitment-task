package com.tooploox.androidrecruitmenttask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tooploox.androidrecruitmenttask.databinding.SongsListItemBinding

class SongsListAdapter : ListAdapter<Song, SongsListAdapter.SongViewHolder>(SongDiffCallback()) {

    private lateinit var binding: SongsListItemBinding

    inner class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(song: Song) {
            binding.tvTitle.text = song.title
            binding.tvArtist.text = song.artist
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        binding = SongsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SongViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}

class SongDiffCallback : DiffUtil.ItemCallback<Song>() {
    override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean {
        return oldItem == newItem
    }
}
