package com.yoesuv.menu.infinite_list.adapters.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yoesuv.infinite_scroll.databinding.ItemLoadMoreBinding

class LoadMoreViewHolder(binding: ItemLoadMoreBinding): RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup): LoadMoreViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemLoadMoreBinding.inflate(inflater)
            return LoadMoreViewHolder(binding)
        }
    }

}