package com.example.evocab.ui.profile
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.evocab.R
import com.example.evocab.databinding.FragmentProfileBinding
import com.example.sourcebase.base.BaseFragment

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    override val viewModel: ProfileViewModel
        get() = ViewModelProvider(this)[ProfileViewModel::class.java]

    override fun destroy() {
        super.onDestroy()
    }

    override fun initData() {
    }

    override fun handleEvent() {
        binding.imgProfileBack.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_homeFragment)

        }
    }

    override fun bindData() {
    }
}