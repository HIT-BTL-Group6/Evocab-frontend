package com.example.evocab.ui.flashcard

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.app.Dialog
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.PopupMenu
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.evocab.R
import com.example.evocab.databinding.FragmentFlashCardBinding
import com.example.evocab.extension.openDlNoted
import com.example.evocab.extension.openDlReport
import com.example.sourcebase.base.BaseFragment

class FlashCardFragment : BaseFragment<FragmentFlashCardBinding>(FragmentFlashCardBinding::inflate) {
    override val viewModel: FlashCardViewModel
        get() = ViewModelProvider(this)[FlashCardViewModel::class.java]

    override fun destroy() {

    }

    override fun initData() {

    }

    override fun handleEvent() {
        val dialog = context?.let { it1 -> Dialog(it1) }
        binding.apply {
            btnReport.setOnClickListener {
                dialog?.openDlReport()
            }
            btnMenu.setOnClickListener {
                showPopupMenu(it)
            }
            flashcard.setOnClickListener {
                FlipCard()
            }
            btnEdit.setOnClickListener {
                dialog?.openDlNoted()
            }
            speaker1.setOnClickListener {
                Toast.makeText(context, "Đã chạm speaker US", Toast.LENGTH_SHORT).show()
            }
            speaker2.setOnClickListener {
                Toast.makeText(context, "Đã chạm speaker UK", Toast.LENGTH_SHORT).show()
            }
            imgBack.setOnClickListener {
                findNavController().navigate(R.id.action_flashCardFragment_to_homeFragment)
            }
        }



    }

    override fun bindData() {
        frontFlashCard()
    }
    private var isFrontVisible = true
    private fun FlipCard(){
        val o1= ObjectAnimator.ofFloat(binding.flashcard, "scaleX", 1f, 0f)
        val o2= ObjectAnimator.ofFloat(binding.flashcard, "scaleX", 0f, 1f)
        o1.interpolator = DecelerateInterpolator()
        o2.interpolator = AccelerateInterpolator()
        o1.addListener(object : AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                if (isFrontVisible) {
                    BackFlashCard()
                } else {
                    frontFlashCard()
                }
                isFrontVisible = !isFrontVisible
                o2.start()
            }
        })
        o1.start()
        o1.setDuration(1000)
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
    fun BackFlashCard(){
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
                R.id.missed -> {
                    findNavController().navigate(R.id.action_flashCardFragment_to_missedFragment)
                    true
                }
                R.id.remembered -> {
                    // Xử lý khi người dùng chọn Item 2
                    findNavController().navigate(R.id.action_flashCardFragment_to_missedFragment)
                    true
                }
                R.id.new_vocabulary -> {
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