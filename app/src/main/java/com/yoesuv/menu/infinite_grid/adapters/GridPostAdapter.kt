package com.yoesuv.menu.infinite_grid.adapters

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.yoesuv.menu.infinite_grid.adapters.viewholders.ItemGridPostViewHolder
import com.yoesuv.menu.infinite_list.models.PostModel
import com.yoesuv.utils.AdapterCallback

class GridPostAdapter: PagingDataAdapter<PostModel, ItemGridPostViewHolder>(AdapterCallback.diffPost) {

    override fun onBindViewHolder(holder: ItemGridPostViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemGridPostViewHolder {
        return ItemGridPostViewHolder.from(parent)
    }

}