package com.yoesuv.menu.infinite_list.adapters

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.yoesuv.menu.infinite_list.adapters.viewholders.LoadMoreViewHolder

class LoadMoreStateAdapter : LoadStateAdapter<LoadMoreViewHolder>() {
    override fun onBindViewHolder(holder: LoadMoreViewHolder, loadState: LoadState) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadMoreViewHolder {
        return LoadMoreViewHolder.from(parent)
    }
}