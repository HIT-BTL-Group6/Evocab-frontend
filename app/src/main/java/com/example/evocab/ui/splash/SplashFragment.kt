package com.example.evocab.ui.splash

import android.os.Handler
import android.os.Looper
import androidx.navigation.fragment.findNavController
import com.example.evocab.R
import com.example.evocab.base.BaseViewModel
import com.example.evocab.databinding.FragmentSplashBinding
import com.example.sourcebase.base.BaseFragment


class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    override val viewModel: BaseViewModel
        get() = BaseViewModel()

    override fun destroy() {
        
    }

    override fun initData() {
        
    }

    override fun handleEvent() {
        
    }

    override fun bindData() {
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_logInFragment)

        },2000 )
        binding.lottie.animate().setDuration(2000).setStartDelay(0)
    }


}