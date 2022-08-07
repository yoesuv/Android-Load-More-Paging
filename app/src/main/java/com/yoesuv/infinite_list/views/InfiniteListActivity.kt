package com.yoesuv.infinite_list.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.yoesuv.infinite_scroll.R
import com.yoesuv.infinite_scroll.databinding.ActivityInfiniteListBinding

class InfiniteListActivity: AppCompatActivity() {

    private lateinit var binding: ActivityInfiniteListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_infinite_list)
        binding.lifecycleOwner = this
    }

}