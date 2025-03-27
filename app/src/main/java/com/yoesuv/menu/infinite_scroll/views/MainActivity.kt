package com.yoesuv.menu.infinite_scroll.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.yoesuv.menu.infinite_scroll.R
import com.yoesuv.menu.infinite_scroll.databinding.ActivityMainBinding
import com.yoesuv.menu.infinite_scroll.viewmodels.MainViewModel
import com.yoesuv.utils.Utility

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit  var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Utility.isVanillaIceCreamAndUp()) {
            enableEdgeToEdge()
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.main = viewModel
        binding.lifecycleOwner = this

        setupToolbar()

        if (Utility.isVanillaIceCreamAndUp()) {
            Utility.insetsPadding(
                binding.toolbarMain,
                top = true,
                color = getColor(R.color.teal_500)
            )
            Utility.insetsPadding(binding.clMain, bottom = true)
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbarMain)
    }

}