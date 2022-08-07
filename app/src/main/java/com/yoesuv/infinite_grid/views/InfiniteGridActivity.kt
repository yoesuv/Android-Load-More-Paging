package com.yoesuv.infinite_grid.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.yoesuv.infinite_scroll.R
import com.yoesuv.infinite_scroll.databinding.ActivityInfiniteGridBinding

class InfiniteGridActivity: AppCompatActivity() {

    private lateinit var binding: ActivityInfiniteGridBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_infinite_grid)
        binding.lifecycleOwner = this
    }

}