package com.example.evocab.ui.forgotpass

import android.annotation.SuppressLint
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.evocab.R
import com.example.evocab.databinding.FragmentForgotPassBinding
import com.example.evocab.model.ForgotPassEnity
import com.example.evocab.utils.constant.Constant
import com.example.sourcebase.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForgotPassFragment : BaseFragment<FragmentForgotPassBinding>(FragmentForgotPassBinding::inflate) {
    private var isEnterEmail: Boolean = true
    override val viewModel by viewModel<ForgotPassViewModel>()

    override fun destroy() {

    }

    override fun initData() {
    }

    override fun handleEvent() {
        binding.apply {
            btnSend.setOnClickListener {
                val _emailOrCode = edtVerifiCode.text.toString()
                val emailOrCode = ForgotPassEnity(_emailOrCode)
                if(isEnterEmail){
                    viewModel.sendCodeToEmail(emailOrCode)
                    verifiCode()
                }else{
                    if(_emailOrCode == viewModel.otp.value){
                        findNavController().navigate(R.id.action_forgotPassFragment_to_newPassFragment)
                    }

                }
            }
            txtLoginChangeActi.setOnClickListener {
                findNavController().navigate(R.id.action_forgotPassFragment_to_logInFragment)
            }
            txtSignupChangeActi.setOnClickListener {
                findNavController().navigate(R.id.action_forgotPassFragment_to_signUpFragment)
            }
        }
        viewModel.messageError.observe(viewLifecycleOwner) {
            when (it) {
                Constant.MessageAPI.ForgotPass.EMAIL_VERIFIED_PASS
                -> {
                    //xử lý khi email đúng và đã gửi otp
                    Log.e("EMAIL_VERIFIED_PASS", "handleEvent 2: ${it}",)
                }
                Constant.MessageAPI.ForgotPass.EMAIL_VERIFIED_FAIL -> {
                    //xử lý khi email sai
                    Log.e("EMAIL_VERIFIED_FAIL", "handleEvent 2: ${it}",)
                }
                else -> {
                    Log.e("1", "handleEvent 2: ${it}",)
                }
            }
        }

    }

    override fun bindData() {
        enterEmail()
    }

    fun enterEmail(){
        binding.errorMess.visibility = View.GONE
        binding.timeCountdown.visibility = View.GONE
        binding.inputVerifiCode.visibility = View.GONE
        binding.txtRequest.setText(R.string.enterEmail)
        isEnterEmail = true
    }

    fun verifiCode(){
        binding.errorMess.visibility = View.GONE
        binding.timeCountdown.visibility = View.VISIBLE
        binding.inputVerifiCode.visibility = View.VISIBLE
        binding.txtRequest.setText(R.string.enterVerifiCode)
        isEnterEmail = false
        object: CountDownTimer(60000, 1000){
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                val minute = millisUntilFinished/60000
                val second = (millisUntilFinished-minute*60000)/1000
                binding.timeCountdown.text = "$minute:$second"
            }
            override fun onFinish() {
                enterEmail()
            }
        }.start()

    }

}