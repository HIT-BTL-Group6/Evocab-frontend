package com.example.evocab.ui.profile
import android.util.Log
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.atom.android.lebo.utils.extensions.getNameTopic
import com.example.evocab.R
import com.example.evocab.databinding.FragmentProfileBinding
import com.example.evocab.model.Friend
import com.example.evocab.model.Vocabulary
import com.example.evocab.ui.home.HomeFragment
import com.example.evocab.ui.home.TAG
import com.example.evocab.ui.missed.ListAdapterVocabMissed
import com.example.evocab.utils.constant.Constant
import com.example.sourcebase.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    private val friendAdapter by lazy {
        ProfileAdapter{{}}
    }
    override val viewModel by viewModel<ProfileViewModel>()

    override fun destroy() {
        super.onDestroy()
    }

    override fun initData() {
    }

    override fun handleEvent() {
        binding.imgProfileBack.setOnClickListener {
            //findNavController().navigate(R.id.pro)
        }
        binding.imgProfileSettings.setOnClickListener {
            val bundle = bundleOf(HomeFragment.EXTRAS_USER to viewModel.getResults.value)
            findNavController().navigate(R.id.action_profileFragment2_to_settingFragment, bundle)
        }
    }

    override fun bindData() {
        val v1: Friend = Friend(1, "mother", "sdsdfs")
        val v2: Friend = Friend(2, "father", "sdsdfs")
        val v3: Friend = Friend(3, "sister", "sdsdfs")
        val v4: Friend = Friend(3, "sister", "sdsdfs")
        val v5: Friend = Friend(3, "sister", "sdsdfs")
        val v6: Friend = Friend(3, "sister", "sdsdfs")
        val v7: Friend = Friend(3, "sister", "sdsdfs")
        val v8: Friend = Friend(3, "sister", "sdsdfs")
        val v9: Friend = Friend(3, "sister", "sdsdfs")
        val v10: Friend = Friend(3, "sister", "sdsdfs")
        val friends= listOf(v1, v2, v3, v4,v5,v6,v7,v8,v9,v10)
        friendAdapter.submitList(friends)
        binding.listFriend.layoutManager = LinearLayoutManager(context)
        binding.listFriend.adapter = friendAdapter

        viewModel.apply {
            getInforUser()
            messageError.observe(viewLifecycleOwner){
                Log.e(TAG, "bindData: Message là ${it}", )
                when(it){
                    Constant.MessageAPI.GetUser.GET_USER_INFRO_SUCCESSFUL ->{
                        binding.txtUserName.text = getResults.value?.username
                        binding.txtEmail.text = getResults.value?.email
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

        //không biết làm :<<<
    }
}