package com.example.evocab.ui.setting

import android.app.Dialog
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.example.evocab.R
import com.example.evocab.databinding.FragmentSettingBinding
import com.example.evocab.extension.openDlChangeDate
import com.example.evocab.extension.openDlChangeEmail
import com.example.evocab.extension.openDlChangePassword
import com.example.evocab.extension.openDlChangeUser
import com.example.sourcebase.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TAG = "SettingFragment"
class SettingFragment : BaseFragment<FragmentSettingBinding>(FragmentSettingBinding::inflate) {
    private val contract = registerForActivityResult(ActivityResultContracts.GetContent()) {
        binding.imgAvt.setImageURI(it)
    }
    override val viewModel by viewModel<SettingViewModel>()

    override fun destroy() {
        super.onDestroy()
    }

    override fun initData() {
        viewModel.searchByName("vyvanhung")
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
        viewModel.searchResults.observe(this){

            Log.e(TAG, "bindData: ${it.toString()}", )
        }
    }


}