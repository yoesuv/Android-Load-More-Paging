package com.yoesuv.utils

import android.app.Activity
import androidx.databinding.BindingAdapter
import com.google.android.material.button.MaterialButton
import com.yoesuv.menu.infinite_scroll.viewmodels.MainViewModel

@BindingAdapter("onPaginationListClick")
fun setOnPaginationListClick(button: MaterialButton, viewModel: MainViewModel) {
    button.setOnClickListener {
        viewModel.onClickPaginationList(button.context as Activity)
    }
}

@BindingAdapter("onPaginationGridClick")
fun setOnPaginationGridClick(button: MaterialButton, viewModel: MainViewModel) {
    button.setOnClickListener {
        viewModel.onClickPaginationGrid(button.context as Activity)
    }
}