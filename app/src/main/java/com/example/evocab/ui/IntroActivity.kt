package com.example.evocab.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.evocab.MainActivity
import com.example.evocab.R
import com.example.evocab.databinding.ActivityIntroBinding
import com.example.sourcebase.base.BaseActivity

class IntroActivity : BaseActivity<ActivityIntroBinding>(ActivityIntroBinding::inflate) {
    override fun initData() {

    }

    override fun handleEvent() {
    }

    override fun bindData() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
        },2000 )

        binding.lottie.animate().setDuration(2000).setStartDelay(0)
//        binding.view.animate().setDuration(2000).rotationY(360f).setStartDelay(0)

    }
}