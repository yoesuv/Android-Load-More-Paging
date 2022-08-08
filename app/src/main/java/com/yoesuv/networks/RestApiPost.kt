package com.yoesuv.networks

import com.yoesuv.menu.infinite_list.models.PostModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApiPost {

    // https://jsonplaceholder.typicode.com/posts?_page=5&_limit=20
    @GET("post")
    suspend fun getListPropertyMaster(
        @Query("_page") page: Int,
        @Query("_limit") limit: Int
    ): Response<List<PostModel>>

}