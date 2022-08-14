package com.yoesuv.menu.infinite_grid.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.yoesuv.menu.infinite_list.models.PostModel

class ItemGridPostViewModel(postModel: PostModel): ViewModel() {

    var title: ObservableField<String> = ObservableField(postModel.title)

}