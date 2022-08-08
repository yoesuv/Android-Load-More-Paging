package com.yoesuv.menu.infinite_list.adapters

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.yoesuv.menu.infinite_list.adapters.viewholders.ItemListPostViewHolder
import com.yoesuv.menu.infinite_list.models.PostModel
import com.yoesuv.utils.AdapterCallback

class ListPostAdapter: PagingDataAdapter<PostModel, ItemListPostViewHolder>(AdapterCallback.diffPost) {

    override fun onBindViewHolder(holder: ItemListPostViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListPostViewHolder {
        return ItemListPostViewHolder.from(parent)
    }
}