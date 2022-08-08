package com.yoesuv.utils

import androidx.recyclerview.widget.DiffUtil
import com.yoesuv.menu.infinite_list.models.PostModel

object AdapterCallback {

    val diffPost = object : DiffUtil.ItemCallback<PostModel>() {
        override fun areItemsTheSame(oldItem: PostModel, newItem: PostModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PostModel, newItem: PostModel): Boolean {
            return oldItem == newItem
        }
    }

}