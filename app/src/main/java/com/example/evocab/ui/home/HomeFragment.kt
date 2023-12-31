package com.example.evocab.ui.home

import android.app.Dialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.atom.android.lebo.utils.extensions.getNameTopic
import com.example.evocab.R
import com.example.evocab.base.BaseViewModel
import com.example.evocab.databinding.FragmentHomeBinding
import com.example.evocab.extension.openShowImg
import com.example.evocab.ui.setting.SettingFragment
import com.example.evocab.utils.constant.Constant
import com.example.sourcebase.base.BaseFragment
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel


const val TAG = "HomeFragment"

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate, ) {
    //private lateinit var userViewModel: BaseViewModel
    override val viewModel by viewModel<HomeViewModel>()
    private val sharedPreferences = get<SharedPreferences>()

    override fun destroy() {
        super.onDestroy()
    }

    override fun initData() {


    }

    companion object{
        const val EXTRAS_USER = "EXTRAS_USER"
    }
    override fun handleEvent() {
        val dialog = context?.let { it1 -> Dialog(it1) }
        //Log.e(TAG, "handleEvent: user là ${viewModel.getResults.value}", )
        binding.apply {
            btnSettings.setOnClickListener {
                val bundle = bundleOf(EXTRAS_USER to viewModel.getResults.value)
                findNavController().navigate(R.id.action_homeFragment_to_settingFragment, bundle)
            }
            flMissed.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_missedFragment)
            }
            btnFlashcard.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_flashCardFragment)
            }
            flClassroom.setOnClickListener {
                //findNavController().navigate(R.id.)
            }
            flTest.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_examFragment)
            }
            flTopic.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_topicFragment)
            }
            flRemembered.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_missedFragment)
            }
            flPractice.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_practiceFragment)
            }
            imvUserAvt.setOnClickListener {
                dialog?.openShowImg()
            }
        }

    }
    override fun bindData() {
        binding.tvTopicName.text = sharedPreferences.getNameTopic()
        Log.e(TAG, "bindData: ${sharedPreferences.getNameTopic()}", )
        viewModel.apply {
            getInforUser()
            messageError.observe(viewLifecycleOwner){
                Log.e(TAG, "bindData: Message là ${it}", )
                when(it){
                    Constant.MessageAPI.GetUser.GET_USER_INFRO_SUCCESSFUL ->{
                        binding.username.text = getResults.value?.username
                        Log.e(TAG, "bindData: Thành công", )
                    }
                    Constant.MessageAPI.GetUser.GET_USER_INFRO_BAD -> {
                        Log.e(TAG, "bindData: Thất bại do token sai, đăng nhập lỗi", )
                    }
                    else -> {
                        Log.e(TAG, "bindData: Thất bại do không cái gì đó", )
                    }
                }
            }
        }
    }
}