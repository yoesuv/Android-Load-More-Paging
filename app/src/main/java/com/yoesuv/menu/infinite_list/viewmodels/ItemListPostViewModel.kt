package com.yoesuv.menu.infinite_list.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.yoesuv.menu.infinite_list.models.PostModel

class ItemListPostViewModel(postModel: PostModel): ViewModel() {

    var title: ObservableField<String> = ObservableField(postModel.title)
    var body: ObservableField<String> = ObservableField(postModel.body)

}