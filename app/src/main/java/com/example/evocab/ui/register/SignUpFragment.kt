package com.example.evocab.ui.register

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.evocab.R
import com.example.evocab.databinding.FragmentSignUpBinding
import com.example.evocab.model.RegisterEnity
import com.example.evocab.utils.constant.Constant
import com.example.sourcebase.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


private const val TAG = "RegisterFragment"
class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {
    override val viewModel by viewModel<SignupViewModel>()

    override fun destroy() {
        super.onDestroy()
    }

    override fun initData() {

    }

    override fun handleEvent() {

        binding.apply {
             btnSignup.setOnClickListener {
                val userName: String = edtUser.text.toString()
                val pass: String = edtPass.text.toString()
                val email: String = edtEmail.text.toString()
                 if(checkPass(pass) && checkEmail(email) && checkUser(userName)) {
                     val registerUser = RegisterEnity(userName, pass, email)
                     viewModel.registerByEmail(registerUser)
                 }
            }
            txtLoginChangeActi.setOnClickListener {
                findNavController().navigate(R.id.action_signUpFragment_to_logInFragment)
            }
            viewModel.messageError.observe(viewLifecycleOwner) { error ->
                when (error) {
                    Constant.MessageAPI.EMAIL_ALREADY -> {
                        binding.emailErrorMess.text = context?.getString(R.string.email_ALready)
                        binding.usernameErrorMess.text = ""
                    }
                    Constant.MessageAPI.USERNAME_ALREADY -> {
                        binding.usernameErrorMess.text = context?.getString(R.string.username_already)
                        binding.emailErrorMess.text = ""
                    }
                    else -> {
                        binding.emailErrorMess.text = ""
                        binding.usernameErrorMess.text = ""
                        Toast.makeText(context, "Đăng ký thành công", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    override fun bindData() {
        binding.passwErrorMess.text =""
        binding.emailErrorMess.text =""
        binding.usernameErrorMess.text =""
    }

    private fun checkPass(pass: String): Boolean{
        val passwordRegex = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}$")
        if(!pass.matches(passwordRegex)){
            binding.passwErrorMess.text = context?.getString(R.string.pass_format)
            return false
        }
        else{
            binding.passwErrorMess.text =""
        }
        return true
    }
    private fun checkEmail(email: String): Boolean{
        val emailRegex = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
        if(!email.matches(emailRegex)){
            binding.emailErrorMess.text = context?.getString(R.string.email_format)
        }
        else{
            binding.emailErrorMess.text = ""
        }
        return binding.emailErrorMess.text ==""
    }
    private fun checkUser(user: String): Boolean{
        val usernameRegex = Regex("^[a-zA-Z0-9._-]{3,}$")
        if(!user.matches(usernameRegex)){
            binding.usernameErrorMess.text = context?.getString(R.string.username_format)
        }
        else{
            binding.usernameErrorMess.text = ""
        }
        return binding.usernameErrorMess.text ==""
    }

}