package com.yoesuv.menu.infinite_grid.adapters.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yoesuv.menu.infinite_grid.viewmodels.ItemGridPostViewModel
import com.yoesuv.menu.infinite_list.models.PostModel
import com.yoesuv.menu.infinite_scroll.databinding.ItemGridPostBinding

class ItemGridPostViewHolder(val binding: ItemGridPostBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(postModel: PostModel) {
        binding.post = ItemGridPostViewModel(postModel)
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): ItemGridPostViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemGridPostBinding.inflate(inflater, parent, false)
            return ItemGridPostViewHolder(binding)
        }
    }

}