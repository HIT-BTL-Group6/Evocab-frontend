package com.example.evocab.ui.forgotpass

import android.os.CountDownTimer
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.evocab.R
import com.example.evocab.databinding.FragmentForgotPassBinding
import com.example.sourcebase.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForgotPassFragment : BaseFragment<FragmentForgotPassBinding>(FragmentForgotPassBinding::inflate) {
    var isEnterEmail: Boolean = true
    override val viewModel by viewModel<ForgotPassViewModel>()

    override fun destroy() {
        super.onDestroy()
    }

    override fun initData() {
    }

    override fun handleEvent() {
        binding.btnSend.setOnClickListener {
            if(isEnterEmail){
                VerifiCode()

            }else{
                findNavController().navigate(R.id.action_forgotPassFragment_to_newPassFragment)
            }
        }
        binding.txtLoginChangeActi.setOnClickListener {
            findNavController().navigate(R.id.action_forgotPassFragment_to_logInFragment)
        }
        binding.txtSignupChangeActi.setOnClickListener {
            findNavController().navigate(R.id.action_forgotPassFragment_to_signUpFragment)
        }
    }

    override fun bindData() {
        EnterEmail()
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