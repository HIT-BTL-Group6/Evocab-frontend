package com.example.evocab.ui.profile
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evocab.R
import com.example.evocab.databinding.FragmentProfileBinding
import com.example.evocab.model.Friend
import com.example.evocab.model.Vocabulary
import com.example.evocab.ui.missed.ListAdapterVocabMissed
import com.example.sourcebase.base.BaseFragment

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    private val friendAdapter by lazy {
        ProfileAdapter{{}}
    }
    override val viewModel: ProfileViewModel
        get() = ViewModelProvider(this)[ProfileViewModel::class.java]

    override fun destroy() {
        super.onDestroy()
    }

    override fun initData() {
    }

    override fun handleEvent() {
        binding.imgProfileBack.setOnClickListener {
            findNavController().navigate(R.id.pro)
        }
        binding.imgProfileSettings.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment2_to_settingFragment)
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

        //không biết làm :<<<
    }
}