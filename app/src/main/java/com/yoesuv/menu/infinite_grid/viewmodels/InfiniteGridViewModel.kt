package com.yoesuv.menu.infinite_grid.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.yoesuv.menu.infinite_list.models.PostModel
import com.yoesuv.menu.infinite_list.paging.PostDataSource
import kotlinx.coroutines.flow.Flow

class InfiniteGridViewModel: ViewModel() {

    private val theConfig = PagingConfig(
        pageSize = 20,
        enablePlaceholders = false,
        initialLoadSize = 20,
        prefetchDistance = 5
    )

    fun loadPostPaginationData(): Flow<PagingData<PostModel>> {
        return Pager(
            config = theConfig,
            pagingSourceFactory = {
                PostDataSource()
            }
        ).flow.cachedIn(viewModelScope)
    }

}