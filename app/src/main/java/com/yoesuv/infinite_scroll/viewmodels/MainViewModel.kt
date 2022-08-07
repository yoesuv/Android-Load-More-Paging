package com.yoesuv.infinite_scroll.viewmodels

import android.view.View
import androidx.lifecycle.ViewModel
import com.yoesuv.infinite_grid.views.InfiniteGridActivity
import com.yoesuv.infinite_list.views.InfiniteListActivity

class MainViewModel: ViewModel() {

    fun onClickPaginationList(view: View) {
        val ctx = view.context
        ctx.startActivity(InfiniteListActivity.getInstance(ctx))
    }

    fun onClickPaginationGrid(view: View) {
        val ctx = view.context
        ctx.startActivity(InfiniteGridActivity.getInstance(ctx))
    }

}