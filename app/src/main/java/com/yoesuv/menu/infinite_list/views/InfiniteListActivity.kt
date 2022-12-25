package com.yoesuv.menu.infinite_list.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.yoesuv.menu.infinite_list.adapters.ListPostAdapter
import com.yoesuv.utils.adapters.LoadMoreStateAdapter
import com.yoesuv.menu.infinite_list.viewmodels.InfiniteListViewModel
import com.yoesuv.menu.infinite_scroll.R
import com.yoesuv.menu.infinite_scroll.databinding.ActivityInfiniteListBinding
import kotlinx.coroutines.launch

class InfiniteListActivity: AppCompatActivity() {

    companion object {
        fun getInstance(context: Context): Intent {
            return Intent(context, InfiniteListActivity::class.java)
        }
    }

    private lateinit var binding: ActivityInfiniteListBinding
    private lateinit var viewModel: InfiniteListViewModel
    private lateinit var listPostAdapter: ListPostAdapter
    private lateinit var loadMoreAdapter: LoadMoreStateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_infinite_list)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this)[InfiniteListViewModel::class.java]
        binding.list = viewModel

        setupToolbar()
        setupRecyclerView()
        setupPaging()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressedDispatcher.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupToolbar() {
        supportActionBar?.setTitle(R.string.button_pagination_list)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupRecyclerView() {
        listPostAdapter = ListPostAdapter()
        loadMoreAdapter = LoadMoreStateAdapter()
        binding.rvInfiniteList.adapter = listPostAdapter.withLoadStateFooter(loadMoreAdapter)
    }

    private fun setupPaging() {
        lifecycleScope.launch {
            viewModel.loadPostPaginationData().collect {
                listPostAdapter.submitData(it)
            }
        }
    }

}