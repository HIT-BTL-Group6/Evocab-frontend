package com.example.evocab.ui.setting

import android.app.Dialog
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.atom.android.lebo.utils.extensions.destroyPassword
import com.atom.android.lebo.utils.extensions.destroyTokenLogin
import com.atom.android.lebo.utils.extensions.destroyUsername
import com.example.evocab.R
import com.example.evocab.databinding.FragmentSettingBinding
import com.example.evocab.extension.openDlChangeDate
import com.example.evocab.extension.openDlChangeEmail
import com.example.evocab.extension.openDlChangePassword
import com.example.evocab.extension.openDlChangeUser
import com.example.evocab.model.User
import com.example.evocab.model.UserCanChange
import com.example.evocab.ui.home.HomeFragment
import com.example.sourcebase.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TAG = "SettingFragment"
class SettingFragment() : BaseFragment<FragmentSettingBinding>(FragmentSettingBinding::inflate) {

    private val contract = registerForActivityResult(ActivityResultContracts.GetContent()) {
        binding.imgAvt.setImageURI(it)
    }

    override val viewModel by viewModel<SettingViewModel>()

    override fun destroy() {
        super.onDestroy()
    }

    override fun initData() {
        viewModel.getUserForSetting()
        Log.e(TAG, "initData: khởi tạo 1", )
    }

    override fun handleEvent() {
        //var nameUser= (arguments?.getParcelable(HomeFragment.EXTRAS_USER) as? User)

        val dialog = context?.let { it1 -> Dialog(it1) }
        binding.changeUser.setOnClickListener {
            var nameUser= (arguments?.getParcelable(HomeFragment.EXTRAS_USER) as? User)
            dialog?.openDlChangeUser(false, binding.txtUser.text.toString()){ name ->
                binding.txtUser.text = name
                val userChange = UserCanChange(null, name.toString())
                if (nameUser != null) {
                    nameUser.id?.let { it1 -> viewModel.changeUserFor(it1, userChange) }
                }

            }

        }
        binding.changeEmail.setOnClickListener {
            var nameUser= (arguments?.getParcelable(HomeFragment.EXTRAS_USER) as? User)
            dialog?.openDlChangeEmail(false, binding.txtEmail.text.toString()){ name ->
                binding.txtEmail.text = name
                val userChange = UserCanChange(name.toString(), null)
                if (nameUser != null) {
                    nameUser.id?.let { it1 -> viewModel.changeUserFor(it1, userChange) }
                }
            }
        }
        binding.changePass.setOnClickListener {
            dialog?.openDlChangePassword()
        }
        binding.changeDate.setOnClickListener {
            dialog?.openDlChangeDate()
        }
        binding.txtLogout.setOnClickListener {
            findNavController().navigate(R.id.action_settingFragment_to_logInFragment)
        }
        binding.btnSetImg.setOnClickListener {
            contract.launch("image/*")
        }
        binding.imgBack.setOnClickListener {
            viewModel.logOut()
            findNavController().navigate(R.id.action_settingFragment_to_homeFragment)
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
        val user1 = (arguments?.getParcelable(HomeFragment.EXTRAS_USER) as? User)
        Log.e("SettingFragment", "kiểm tra dữ liệu sau khi lấy: ${user1}", )
        if (user1 != null) {
            binding.apply {
                txtUser.text = user1.username
                txtEmail.text = user1.email
//                txtDate.text =
                //txtPass.text =
            }
        }
    }


}