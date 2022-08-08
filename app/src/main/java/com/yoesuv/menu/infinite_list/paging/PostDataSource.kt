package com.yoesuv.menu.infinite_list.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.yoesuv.menu.infinite_list.models.PostModel
import com.yoesuv.networks.RestApiPost
import com.yoesuv.networks.ServiceFactory

class PostDataSource: PagingSource<Int, PostModel>() {

    private val restApi = ServiceFactory.getApiService(RestApiPost::class.java)

    override fun getRefreshKey(state: PagingState<Int, PostModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PostModel> {
        try {
            val nextPageNumber = params.key ?: 1
            val response = restApi.getListPropertyMaster(nextPageNumber, 20)
            val theData = response.body()
            return LoadResult.Page(
                data = theData?.toList() ?: mutableListOf(),
                prevKey = null,
                nextKey =  if (theData.isNullOrEmpty()) null else nextPageNumber + 1
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}