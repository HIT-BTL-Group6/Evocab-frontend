package com.example.evocab.ui.setting

import android.app.Dialog
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.evocab.R
import com.example.evocab.databinding.FragmentSettingBinding
import com.example.evocab.extension.*
import com.example.sourcebase.base.BaseFragment

class SettingFragment : BaseFragment<FragmentSettingBinding>(FragmentSettingBinding::inflate) {
    private val contract = registerForActivityResult(ActivityResultContracts.GetContent()){
        binding.imgAvt.setImageURI(it)
    }
    override val viewModel: SettingViewModel
        get() = ViewModelProvider(this)[SettingViewModel::class.java]

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
            findNavController().navigate(R.id.action_settingFragment_to_flashCardFragment)
        }
        binding.btnSetImg.setOnClickListener{
            contract.launch("image/*")
        }
        binding.btnSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                Toast.makeText(context, R.string.notify_on, Toast.LENGTH_SHORT).show()
                buttonView.setText("Bật")
            }else{
                Toast.makeText(context, R.string.notify_off, Toast.LENGTH_SHORT).show()
                buttonView.setText("Tắt")
            }
        }
    }



    override fun bindData() {

    }


}