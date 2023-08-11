package com.example.evocab.ui.login

import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.atom.android.lebo.utils.extensions.getPass
import com.atom.android.lebo.utils.extensions.getUSerName
import com.example.evocab.R
import com.example.evocab.databinding.FragmentLogInBinding
import com.example.evocab.model.LoginEnity
import com.example.evocab.utils.constant.Constant
import com.example.sourcebase.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TAG="LoginFragment"

class LogInFragment() : BaseFragment<FragmentLogInBinding>(FragmentLogInBinding::inflate, ) {
    override val viewModel by viewModel<LoginViewModel>()
    private var isWillRememverLogin: Boolean = false
    var userName1: String = ""
    var password1: String = ""


    override fun destroy() {
        super.onDestroy()
    }

    override fun initData() {
//        viewModel.apply {
//            loginState.observe(viewLifecycleOwner) {
//                context?.showToast(it.toString())
////                activityViewModel.getUser()
////                activityViewModel.registerTokenNotification()
//                if (findNavController().popBackStack().not()) {
//                    findNavController().navigate(R.id.action_logInFragment_to_homeFragment)
//                }
//            }
//        }

    }

    override fun handleEvent() {
        binding.btnLogin.setOnClickListener {
            val userName: String = binding.edtUser.text.toString()
            val password: String = binding.edtPass.text.toString()
            val userRequest = LoginEnity(userName, password)
            viewModel.loginByPass(userRequest, isWillRememverLogin)
        }
        logIn()
        binding.txtSignupChangeActi.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_signUpFragment)
            viewModel.apply {
                Log.e(TAG, "handleEvent token: ${loginState.value}", )
            }
        }
        binding.txtForgotPassChangeActi.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_forgotPassFragment)
        }
        binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
            isWillRememverLogin = isChecked
            Log.e(TAG, "handleEvent: ${isWillRememverLogin}", )
        }
    }

    override fun bindData() {
        //checkLogin()
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            requireActivity().finishAffinity() // Đóng tất cả các Activity trong ứng dụng
        }



    }

    fun logIn(){
        viewModel.messageError.observe(viewLifecycleOwner){
            Log.e(TAG, "handleEvent omg: ${it}", )
            when (it){
                Constant.MessageAPI.LOGIN_ERROR
                ->{
                    binding.inputPass.setBackgroundResource(R.drawable.bg_input_error)
                    binding.inputUsername.setBackgroundResource(R.drawable.bg_input_error)
                    binding.passwErrorMess.text = context?.getString(R.string.pass_error_mess)
                    binding.usernameErrorMess.text = context?.getString(R.string.username_error_mess)
                    Log.e(TAG, "handleEvent 1: ${it}", )
                    Log.e(TAG, "handleEvent 2: ${it}", )
                }
                Constant.MessageAPI.LOGIN_SUCCESSFUL -> {
                    binding.passwErrorMess.text = ""
                    binding.usernameErrorMess.text = ""
                    Toast.makeText(context, "Đăng nhập thành công", Toast.LENGTH_SHORT).show()
                    if(userName1 == ""){
                        findNavController().navigate(R.id.action_logInFragment_to_homeFragment)
                    }else{
                        findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
                    }

                }
                else -> {Log.e(TAG, "handleEvent 3: ${it}", )}
            }

        }
    }

    fun checkLogin(){
        userName1 = viewModel.getUsername
        password1 = viewModel.getPass
        Log.e(TAG, "checkLogin: username shar ${userName1} ", )
        Log.e(TAG, "checkLogin: pass shar ${password1} ", )
        if(userName1 != "" && password1 != ""){
            val userRequest = LoginEnity(userName1, password1)
            viewModel.loginByPass(userRequest, isWillRememverLogin)
            logIn()
        }

    }



}