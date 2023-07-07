package com.example.evocab

import android.content.Intent
import com.example.evocab.databinding.ActivitySignUpBinding
import com.example.sourcebase.base.BaseActivity

class SignUp : BaseActivity<ActivitySignUpBinding>(ActivitySignUpBinding::inflate) {
    override fun initData() {
        binding.txtLoginChangeActi.setOnClickListener {
            startActivity(Intent(this,LogIn::class.java))
        }
    }

    override fun handleEvent() {

    }

    override fun bindData() {

    }

}