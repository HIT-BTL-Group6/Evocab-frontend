package com.example.evocab.ui.setting

import android.app.Dialog
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.evocab.R
import com.example.evocab.base.BaseViewModel
import com.example.evocab.databinding.FragmentSettingBinding
import com.example.evocab.extension.openDlChangeDate
import com.example.evocab.extension.openDlChangeEmail
import com.example.evocab.extension.openDlChangePassword
import com.example.evocab.extension.openDlChangeUser
import com.example.evocab.model.User
import com.example.evocab.ui.home.HomeFragment
import com.example.evocab.ui.home.HomeViewModel
import com.example.sourcebase.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TAG = "SettingFragment"
class SettingFragment : BaseFragment<FragmentSettingBinding>(FragmentSettingBinding::inflate) {

    private lateinit var user1: User
    private val contract = registerForActivityResult(ActivityResultContracts.GetContent()) {
        binding.imgAvt.setImageURI(it)
    }
    override val viewModel by viewModel<SettingViewModel>()

    override fun destroy() {
        super.onDestroy()
    }

    override fun initData() {

    }

    override fun handleEvent() {
        val dialog = context?.let { it1 -> Dialog(it1) }
        binding.changeUser.setOnClickListener {
            dialog?.openDlChangeUser()
        }
        binding.changeEmail.setOnClickListener {
            dialog?.openDlChangeEmail()
        }
        binding.changePass.setOnClickListener {
            dialog?.openDlChangePassword()
        }
        binding.changeDate.setOnClickListener {
            dialog?.openDlChangeDate()
        }
        binding.txtLogout.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_settingFragment)
        }
        binding.btnSetImg.setOnClickListener {
            contract.launch("image/*")
        }
        binding.btnSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(context, R.string.notify_on, Toast.LENGTH_SHORT).show()
                buttonView.setText("Bật")
            } else {
                Toast.makeText(context, R.string.notify_off, Toast.LENGTH_SHORT).show()
                buttonView.setText("Tắt")
            }
        }
    }



    override fun bindData() {
        user1 = (arguments?.getParcelable(HomeFragment.EXTRAS_USER) as? User)!!
        Log.e("SettingFragment", "kiểm tra dữ liệu sau khi lấy: ${user1}", )
        if (user1 != null) {
            binding.apply {
                txtUser.text = user1.username
                txtEmail.text = user1.email
//                txtDate.text =
                //txtPass.text =
            }
//            viewModel.searchResults.observe(this){
//
//                Log.e(TAG, "bindData: ${it.toString()}", )
//            }
        }else{
        }

    }


}