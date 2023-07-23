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
import androidx.core.animation.addListener
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
        binding.btnReport.setOnClickListener {
            dialog?.openDlReport()
        }
        binding.btnMenu.setOnClickListener {
            showPopupMenu(it)
        }
        binding.flashcard.setOnClickListener {
            FlipCard()
        }
        binding.btnEdit.setOnClickListener {
            dialog?.openDlNoted()
        }
        binding.speaker1.setOnClickListener {
            Toast.makeText(context, "Đã chạm speaker US", Toast.LENGTH_SHORT).show()
        }
        binding.speaker2.setOnClickListener {
            Toast.makeText(context, "Đã chạm speaker UK", Toast.LENGTH_SHORT).show()
        }
    }

    override fun bindData() {
        FrontFlashCard()
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
                    FrontFlashCard()
                }
                isFrontVisible = !isFrontVisible
                o2.start()
            }
        })
        o1.start()
        o1.setDuration(1000)
    }
    fun FrontFlashCard(){
        binding.cardView3.setVisibility(View.GONE)
        binding.explainVocabVienamese.setVisibility(View.GONE)
        binding.vocabNameMeaning.setVisibility(View.GONE)
        binding.cardView2.setVisibility(View.VISIBLE)
        binding.vocabName.setVisibility(View.VISIBLE)
        binding.explainVocab.setVisibility(View.VISIBLE)
        binding.txtUk.setVisibility(View.VISIBLE)
        binding.txtUs.setVisibility(View.VISIBLE)
        binding.UkPronounce.setVisibility(View.VISIBLE)
        binding.UsPronounce.setVisibility(View.VISIBLE)
        binding.speaker1.setVisibility(View.VISIBLE)
        binding.speaker2.setVisibility(View.VISIBLE)
    }
    fun BackFlashCard(){
        binding.cardView3.setVisibility(View.VISIBLE)
        binding.explainVocabVienamese.setVisibility(View.VISIBLE)
        binding.vocabNameMeaning.setVisibility(View.VISIBLE)
        binding.cardView2.setVisibility(View.INVISIBLE)
        binding.vocabName.setVisibility(View.INVISIBLE)
        binding.explainVocab.setVisibility(View.INVISIBLE)
        binding.txtUk.setVisibility(View.INVISIBLE)
        binding.txtUs.setVisibility(View.INVISIBLE)
        binding.UkPronounce.setVisibility(View.INVISIBLE)
        binding.UsPronounce.setVisibility(View.INVISIBLE)
        binding.speaker1.setVisibility(View.INVISIBLE)
        binding.speaker2.setVisibility(View.INVISIBLE)
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