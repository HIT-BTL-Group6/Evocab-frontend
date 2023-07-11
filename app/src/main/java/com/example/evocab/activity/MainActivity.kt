package com.example.evocab.activity

import androidx.core.view.isVisible
import androidx.navigation.findNavController

import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.evocab.R
import com.example.evocab.databinding.ActivityMainBinding
import com.example.sourcebase.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {


    private val navController by lazy { findNavController(R.id.nav_host_fragment_activity_main) }

    override fun initData() {

    }

    override fun handleEvent() {

    }

    override fun bindData() {
        setupWithNavController(binding.navView, navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
//                R.id.logInFragment -> setNavigationVisible(true)

                else -> setNavigationVisible()
            }
        }
    }

    private fun setNavigationVisible(isVisible: Boolean = false) {
        binding.navView.isVisible = isVisible
    }

}