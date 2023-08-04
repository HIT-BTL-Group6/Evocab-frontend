package com.example.evocab.ui.profile
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evocab.R
import com.example.evocab.databinding.FragmentProfileBinding
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
            findNavController().navigate(R.id.action_profileFragment_to_homeFragment)

        }
    }

    override fun bindData() {
        val v1: Vocabulary = Vocabulary("1", "mother", "sdsdfs", "Fsfsd", "SDfsd", false, "dfsf")
        val v2: Vocabulary = Vocabulary("2", "father", "sdsdfs", "Fsfsd", "SDfsd", false, "dfsf")
        val v3: Vocabulary = Vocabulary("3", "sister", "sdsdfs", "Fsfsd", "SDfsd", false, "dfsf")
        val friend= listOf(v1, v2, v3)
//        viewModel.get
//        ProfileAdapter.
//        binding.missedAdapter.layoutManager = LinearLayoutManager(context)
//        binding.missedAdapter.adapter = vocabularyAdapter

        //không biết làm :<<<
    }
}