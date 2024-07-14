package com.yoesuv.menu.infinite_scroll.viewmodels

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.yoesuv.menu.infinite_grid.views.InfiniteGridActivity
import com.yoesuv.menu.infinite_list.views.InfiniteListActivity

class MainViewModel: ViewModel() {

    fun onClickPaginationList(activity: Activity) {
        activity.startActivity(InfiniteListActivity.getInstance(activity))
    }

    fun onClickPaginationGrid(activity: Activity) {
        activity.startActivity(InfiniteGridActivity.getInstance(activity))
    }

}