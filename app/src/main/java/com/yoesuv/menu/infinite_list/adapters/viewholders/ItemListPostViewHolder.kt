package com.yoesuv.menu.infinite_list.adapters.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yoesuv.menu.infinite_list.models.PostModel
import com.yoesuv.menu.infinite_list.viewmodels.ItemListPostViewModel
import com.yoesuv.menu.infinite_scroll.databinding.ItemListPostBinding

class ItemListPostViewHolder(val binding: ItemListPostBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(postModel: PostModel) {
        binding.post = ItemListPostViewModel(postModel)
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): ItemListPostViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemListPostBinding.inflate(inflater, parent, false)
            return ItemListPostViewHolder(binding)
        }
    }

}