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
                val _email = edtEmail.text.toString()
                val _otp = edtVerifiCode2.text.toString()
                val emailOrCode = ForgotPassEnity(_email)
                if(isEnterEmail){
                    viewModel.sendCodeToEmail(emailOrCode)

                }else{
                    checkOtp(_otp)
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
                    verifiCode()
                    binding.errorMess.visibility = View.GONE
                    Log.e("EMAIL_VERIFIED_PASS", "handleEvent 2: ${it}",)
                    Log.e("TAG", "handleEvent: ${viewModel.otp.value}", )
                }
                Constant.MessageAPI.ForgotPass.EMAIL_VERIFIED_FAIL -> {
                    //xử lý khi email sai
                    binding.errorMess.visibility = View.VISIBLE
                    Log.e("EMAIL_VERIFIED_FAIL", "handleEvent 2: ${it}",)
                }
                else -> {
                    Log.e("1", "handleEvent 2: ${it}",)
                }
            }
        }

    }

    private fun checkOtp(otp: String){
        if(viewModel.otp.value == otp){
            findNavController().navigate((R.id.action_forgotPassFragment_to_newPassFragment))
        }else{
            binding.errorMess.text = context?.getString(R.string.VerifiCodeErorrMess)
        }
    }

    override fun bindData() {
        enterEmail()
    }

    fun enterEmail(){
        binding.errorMess.visibility = View.GONE
        binding.timeCountdown.visibility = View.GONE
        binding.inputVerifiCode1.visibility = View.GONE
        binding.txtRequest.setText(R.string.enterEmail)
        isEnterEmail = true
    }

    fun verifiCode(){
        binding.errorMess.visibility = View.GONE
        binding.timeCountdown.visibility = View.VISIBLE
        binding.inputVerifiCode1.visibility = View.VISIBLE
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