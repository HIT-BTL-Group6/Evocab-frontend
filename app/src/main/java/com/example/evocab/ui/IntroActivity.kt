package com.example.evocab.ui

import android.content.Intent
import android.os.Handler
import android.os.Looper
import com.example.evocab.LogIn
import com.example.evocab.databinding.ActivityIntroBinding
import com.example.sourcebase.base.BaseActivity

class IntroActivity : BaseActivity<ActivityIntroBinding>(ActivityIntroBinding::inflate) {
    override fun initData() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this,LogIn::class.java))
        },2000 )
        binding.lottie.animate().setDuration(2000).setStartDelay(0)

    }

    override fun handleEvent() {
    }

    override fun bindData() {
    }
}