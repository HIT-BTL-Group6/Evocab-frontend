package com.example.evocab

import android.content.Intent
import android.os.CountDownTimer
import android.view.View
import com.example.evocab.databinding.ActivityForgotPasswordBinding
import com.example.sourcebase.base.BaseActivity

class ForgotPassword : BaseActivity<ActivityForgotPasswordBinding>(ActivityForgotPasswordBinding::inflate) {
    var isEnterEmail: Boolean = true
    override fun initData() {
        EnterEmail()
    }

    override fun handleEvent() {
        binding.btnSend.setOnClickListener {
            if(isEnterEmail){
                VerifiCode()

            }else{
                startActivity(Intent(this, NewPassword::class.java))
            }
        }
        binding.txtLoginChangeActi.setOnClickListener {
            startActivity(Intent(this, LogIn::class.java))
        }
        binding.txtSignupChangeActi.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
        }
    }

    override fun bindData() {

    }

    fun EnterEmail(){
        binding.errorMess.setVisibility(View.GONE)
        binding.timeCountdown.setVisibility(View.GONE)
        binding.inputVerifiCode.setVisibility(View.GONE)
        binding.txtRequest.setText(R.string.enterEmail)
        isEnterEmail = true
    }

    fun VerifiCode(){
        binding.errorMess.setVisibility(View.GONE)
        binding.timeCountdown.setVisibility(View.VISIBLE)
        binding.inputVerifiCode.setVisibility(View.VISIBLE)
        binding.txtRequest.setText(R.string.enterVerifiCode)
        isEnterEmail = false
        object: CountDownTimer(60000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                var minute = millisUntilFinished/60000
                var second = (millisUntilFinished-minute*60000)/1000
                binding.timeCountdown.text = minute.toString()+":"+ second.toString()
            }
            override fun onFinish() {
                EnterEmail()
            }

        }.start()

    }

}