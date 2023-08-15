package com.example.evocab.ui.flashcard

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.util.Log
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.PopupMenu
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.atom.android.lebo.utils.extensions.getIdTopic
import com.atom.android.lebo.utils.extensions.getStatus
import com.atom.android.lebo.utils.extensions.saveStatusTopic
import com.example.evocab.R
import com.example.evocab.databinding.FragmentFlashCardBinding
import com.example.evocab.extension.*
import com.example.evocab.model.Word
import com.example.sourcebase.base.BaseFragment
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel

const val TAG ="FlashCardFragment"
class FlashCardFragment : BaseFragment<FragmentFlashCardBinding>(FragmentFlashCardBinding::inflate) {

    private val mediaPlayer = MediaPlayer()
    override val viewModel by viewModel<FlashCardViewModel>()
    private var _listVocabLocal = MutableLiveData<List<Word>>()
    private val listVocabLocal: LiveData<List<Word>> get() = _listVocabLocal
    private var list : List<Word> = mutableListOf()
    private val sharedPreferences = get<SharedPreferences>()
    private var idInList: Int = 0



    override fun destroy() {

    }

    override fun initData() {
        val idTopic = sharedPreferences.getIdTopic()
        if (idTopic != null) {
            viewModel.getAllVocabInTopic(idTopic)
        }
    }

    override fun handleEvent() {
        val dialog = context?.let { it1 -> Dialog(it1) }
        binding.contrainsLReport.setOnClickListener {
            dialog?.openDlReport()
        }
        binding.btnMenu.setOnClickListener {
            showPopupMenu(it)
        }
        binding.flashcard.setOnClickListener {
            flipCard()
        }
        binding.btnEdit.setOnClickListener {
            dialog?.openDlNoted()
        }
        binding.speaker1.setOnClickListener {
            mediaPlayer.start()
        }
        binding.speaker2.setOnClickListener {
            mediaPlayer.start()
        }
        binding.imgBackTo.setOnClickListener {
            findNavController().navigate(R.id.action_flashCardFragment_to_homeFragment)
        }
        binding.imgMissed.setOnClickListener {
            if(idInList < listVocabLocal.value?.size!!){
                val idWord = listVocabLocal.value?.get(idInList)?.id.toString()
                viewModel.get1Vocab(idWord)
                frontFlashCard()
                pasteWord()
                listVocabLocal.value?.let {
                    binding.numberCard.text = "${idInList+1}/${it.size}"
                    binding.progressBarLoading.progress = ((idInList+1)*1.0/it.size*100).toInt()
                    binding.valueOfProgressbar.text = "${((idInList+1)*1.0/it.size*100).toInt()}%"

                    val status: Double = idInList.toDouble()
                    sharedPreferences.saveStatusTopic(status.toString(), binding.nameTopic.text.toString())

                }?:kotlin.run {

                }
                idInList++
            }else{
                dialog?.openDlCongrate(false, binding.nameTopic.text.toString())
            }

            //xử lý chuyển sang từ tiếp theo trong listVocabLocal
        }
        binding.imgRemembered.setOnClickListener {
            if(idInList < listVocabLocal.value?.size!!){
                val idWord = listVocabLocal.value?.get(idInList)?.id.toString()
                viewModel.get1Vocab(idWord)
                frontFlashCard()
                pasteWord()
                updateLayoutWhenChangeCard()
                idInList++
            }else{
                dialog?.openDlCongrate(false, binding.nameTopic.text.toString())
            }
        }

    }

    @SuppressLint("SetTextI18n")
    fun updateLayoutWhenChangeCard(){
        listVocabLocal.value?.let {
            binding.numberCard.text = "${idInList+1}/${it.size}"
            binding.progressBarLoading.progress = ((idInList+1)*1.0/it.size*100).toInt()
            binding.valueOfProgressbar.text = "${((idInList+1)*1.0/it.size*100).toInt()}%"

            val status: Double = idInList.toDouble()
            sharedPreferences.saveStatusTopic(status.toString(), binding.nameTopic.text.toString())
        }?:kotlin.run {

        }
    }

    override fun bindData() {
        updateLayoutWhenChangeCard()
        getListWord()


        viewModel.listVocab.observe(viewLifecycleOwner){
            if(listVocabLocal!=null){
                val idWord = listVocabLocal.value?.get(idInList)?.id.toString()
                viewModel.get1Vocab(idWord)
                binding.progressBarLoading.progress = ((idInList+1)*1.0/it.size*100).toInt()
                binding.valueOfProgressbar.text = "${((idInList+1)*1.0/it.size*100).toInt()}%"
            }
        }


        Log.e(TAG, "bindData: ${viewModel.word.value}", )
        frontFlashCard()
        pasteWord()
    }

    private fun getListWord(){
        viewModel.listVocab.observe(viewLifecycleOwner){
            if(it!=null){
                _listVocabLocal.value = it
                Log.e(TAG, "getListWord thành công: ${it}", )
            }else{
                Log.e(TAG, "getListWord lỗi: ${it}", )
            }
        }
    }
    private var isFrontVisible = true
    private fun flipCard(){
        val o1= ObjectAnimator.ofFloat(binding.flashcard, "scaleX", 1f, 0f)
        val o2= ObjectAnimator.ofFloat(binding.flashcard, "scaleX", 0f, 1f)
        o1.interpolator = DecelerateInterpolator()
        o2.interpolator = AccelerateInterpolator()
        o1.addListener(object : AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                if (isFrontVisible) {
                    backFlashCard()
                } else {
                    frontFlashCard()
                }
                isFrontVisible = !isFrontVisible
                o2.start()
            }
        })
        o1.start()
        o1.setDuration(500)
    }
    private fun pasteWord(){
        viewModel.word.observe(viewLifecycleOwner){
            Log.e(TAG, "pasteWord: ${it}", )
            if(it!=null){
                binding.apply {
                    it.image?.let { it1 -> imgVocabulary.loadImageOnServer(it1) }
                    it.image?.let { it1 -> imgVocabulary1.loadImageOnServer(it1) }
                    it.sound?.let { it1 -> mediaPlayer.loadSound(it1) }
                    vocabName.text = it.word
                    vocabNameMeaning.text = it.vietnamese
                    explainVocab.text = it.example
                    UsPronounce.text = it.pronunciation
                    UkPronounce.text = it.pronunciation
                    nameTopic.text = it.nameTopic
                }
            }else{
                Log.e(TAG, "pasteWord: Lỗi từ", )
            }
        }
    }
    fun frontFlashCard(){
        binding.cardView3.visibility = View.GONE
        binding.explainVocabVienamese.visibility = View.GONE
        binding.vocabNameMeaning.visibility = View.GONE
        binding.cardView2.visibility = View.VISIBLE
        binding.vocabName.visibility = View.VISIBLE
        binding.explainVocab.visibility = View.VISIBLE
        binding.txtUk.visibility = View.VISIBLE
        binding.txtUs.visibility = View.VISIBLE
        binding.UkPronounce.visibility = View.VISIBLE
        binding.UsPronounce.visibility = View.VISIBLE
        binding.speaker1.visibility = View.VISIBLE
        binding.speaker2.visibility = View.VISIBLE
    }
    fun backFlashCard(){
        binding.cardView3.visibility = View.VISIBLE
        binding.explainVocabVienamese.visibility = View.VISIBLE
        binding.vocabNameMeaning.visibility = View.VISIBLE
        binding.cardView2.visibility = View.INVISIBLE
        binding.vocabName.visibility = View.INVISIBLE
        binding.explainVocab.visibility = View.INVISIBLE
        binding.txtUk.visibility = View.INVISIBLE
        binding.txtUs.visibility = View.INVISIBLE
        binding.UkPronounce.visibility = View.INVISIBLE
        binding.UsPronounce.visibility = View.INVISIBLE
        binding.speaker1.visibility = View.INVISIBLE
        binding.speaker2.visibility = View.INVISIBLE
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(context, view)
        popupMenu.inflate(R.menu.menu_type_vocabulary)

        popupMenu.setOnMenuItemClickListener {it->
            when (it.itemId) {
                R.id.img_missed -> {
                    findNavController().navigate(R.id.action_homeFragment_to_flashCardFragment)
                    true
                }
                R.id.img_remembered -> {
                    // Xử lý khi người dùng chọn Item 2
                    findNavController().navigate(R.id.action_flashCardFragment_to_homeFragment)
                    true
                }
                R.id.flashCardFragment -> {
                    // Xử lý khi người dùng chọn Item 3
                    true
                }
                // Xử lý các item khác (nếu cần)
                else -> false
            }
        }

        // Hiển thị Popup Menu
        popupMenu.show()
    }




}