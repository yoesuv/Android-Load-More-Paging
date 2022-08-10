package com.yoesuv.menu.infinite_grid.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.yoesuv.menu.infinite_grid.adapters.GridPostAdapter
import com.yoesuv.menu.infinite_grid.viewmodels.InfiniteGridViewModel
import com.yoesuv.menu.infinite_list.adapters.LoadMoreStateAdapter
import com.yoesuv.menu.infinite_scroll.R
import com.yoesuv.menu.infinite_scroll.databinding.ActivityInfiniteGridBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class InfiniteGridActivity: AppCompatActivity() {

    companion object {
        fun getInstance(context: Context): Intent {
            return Intent(context, InfiniteGridActivity::class.java)
        }
    }

    private lateinit var binding: ActivityInfiniteGridBinding
    private lateinit var viewModel: InfiniteGridViewModel
    private lateinit var gridPostAdapter: GridPostAdapter
    private lateinit var loadMoreAdapter: LoadMoreStateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_infinite_grid)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this)[InfiniteGridViewModel::class.java]
        binding.grid = viewModel

        setupToolbar()
        setupRecyclerView()
        setupPaging()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupToolbar() {
        supportActionBar?.setTitle(R.string.button_pagination_grid)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupRecyclerView() {
        gridPostAdapter = GridPostAdapter()
        loadMoreAdapter = LoadMoreStateAdapter()
        binding.rvInfiniteGrid.adapter = gridPostAdapter.withLoadStateFooter(loadMoreAdapter)
    }

    private fun setupPaging() {
        lifecycleScope.launch {
            viewModel.loadPostPaginationData().collect {
                gridPostAdapter.submitData(it)
            }
        }
    }

}