package com.example.evocab.ui.main

import androidx.core.view.isVisible
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController

import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.evocab.R
import com.example.evocab.databinding.ActivityMainBinding
import com.example.evocab.model.User
import com.example.sourcebase.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    val _setUser = MutableLiveData<User>()  //có thể thay đổi dữ liệu
    val getUser: LiveData<User> get() = _setUser
    private val navController by lazy { findNavController(R.id.nav_host_fragment_activity_main) }

    override fun initData() {

    }

    override fun handleEvent() {


    }

    override fun bindData() {
        setupWithNavController(binding.navView, navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> setNavigationVisible(true)
                R.id.flashCardFragment ->setNavigationVisible(true)
                R.id.profileFragment ->setNavigationVisible(true)
                R.id.settingFragment ->setNavigationVisible(true)
                R.id.classroomFragment -> setNavigationVisible(true)
                R.id.writeMeaningFragment -> setNavigationVisible(true)

                else -> setNavigationVisible()
            }
        }
    }

    private fun setNavigationVisible(isVisible: Boolean = false) {
        binding.navView.isVisible = isVisible
    }

}