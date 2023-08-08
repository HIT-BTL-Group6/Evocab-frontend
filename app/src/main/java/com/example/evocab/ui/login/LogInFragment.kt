package com.example.evocab.ui.login

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.evocab.R
import com.example.evocab.databinding.FragmentLogInBinding
import com.example.evocab.extension.showToast
import com.example.evocab.model.UserRequestLogin
import com.example.evocab.utils.constant.Constant
import com.example.sourcebase.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TAG="LoginFragment"

class LogInFragment : BaseFragment<FragmentLogInBinding>(FragmentLogInBinding::inflate) {
    var isLogin : Boolean = false
    override val viewModel by viewModel<LoginViewModel>()
    //private val activityViewModel by activityViewModel<MainViewModel>()

    override fun destroy() {
        super.onDestroy()
    }

    override fun initData() {
        viewModel.apply {
//            loginState.observe(viewLifecycleOwner) {
//                context?.showToast(it.toString())
////                activityViewModel.getUser()
////                activityViewModel.registerTokenNotification()
//                if (findNavController().popBackStack().not()) {
//                    findNavController().navigate(R.id.action_logInFragment_to_homeFragment)
//                }
//            }
        }

    }

    override fun handleEvent() {
        binding.btnLogin.setOnClickListener {
            val userName: String = binding.edtUser.text.toString()
            val password: String = binding.edtPass.text.toString()
            val userRequest = UserRequestLogin(userName, password)
            viewModel.loginByPass(userRequest)
            viewModel.messsageError.observe(this){
                Log.e(TAG, "handleEvent: ${it}", )
                when (it){
                    Constant.Error.LOGIN_ERROR
                        ->{
                            binding.inputPass.setBackgroundResource(R.drawable.bg_input_error)
                            binding.inputUsername.setBackgroundResource(R.drawable.bg_input_error)
                            binding.passwErrorMess.text = context?.getString(R.string.pass_error_mess)
                            binding.usernameErrorMess.text = context?.getString(R.string.username_error_mess)
                        Log.e(TAG, "handleEvent: ${it}", )
                        Log.e(TAG, "handleEvent: ${it}", )
                        }
                    else -> {
                        binding.inputPass.setBackgroundResource(R.drawable.bg_input)
                        binding.inputUsername.setBackgroundResource(R.drawable.bg_input)
                        binding.passwErrorMess.text = ""
                        binding.usernameErrorMess.text = ""
                        findNavController().navigate(R.id.action_logInFragment_to_homeFragment)
                    }
                }

            }
        }
        binding.txtSignupChangeActi.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_signUpFragment)
        }
        binding.txtForgotPassChangeActi.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_forgotPassFragment)
        }
        binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
            viewModel.apply {
                if (isChecked) {
                    isLogin = true
                } else {
                    isLogin = false
                }
            }

        }
    }

    override fun bindData() {

    }




}