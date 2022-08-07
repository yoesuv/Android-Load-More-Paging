package com.yoesuv.infinite_grid.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.yoesuv.infinite_scroll.R
import com.yoesuv.infinite_scroll.databinding.ActivityInfiniteGridBinding

class InfiniteGridActivity: AppCompatActivity() {

    companion object {
        fun getInstance(context: Context): Intent {
            return Intent(context, InfiniteGridActivity::class.java)
        }
    }

    private lateinit var binding: ActivityInfiniteGridBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_infinite_grid)
        binding.lifecycleOwner = this

        setupToolbar()
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

}