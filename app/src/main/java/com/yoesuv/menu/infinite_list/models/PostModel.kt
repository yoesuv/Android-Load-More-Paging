package com.yoesuv.menu.infinite_list.models


import androidx.annotation.Keep

@Keep
data class PostModel(
    val userId: Int?,
    val id: Int?,
    val title: String?,
    val body: String?
)