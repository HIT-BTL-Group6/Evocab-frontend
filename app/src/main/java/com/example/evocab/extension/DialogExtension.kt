package com.example.evocab.extension

import android.app.DatePickerDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.WindowManager
import com.example.evocab.databinding.DlAnimationOkBinding
import com.example.evocab.databinding.DlChangeDateBinding
import com.example.evocab.databinding.DlChangeEmailBinding
import com.example.evocab.databinding.DlChangePasswordlBinding
import com.example.evocab.databinding.DlChangeUserBinding
import com.example.evocab.databinding.DlLoadingBinding
import com.example.evocab.databinding.DlNotedBinding
import com.example.evocab.databinding.DlReportBinding
import com.example.evocab.databinding.DlSuccessfulTopicBinding
import java.util.Calendar

fun Dialog.start(stopFlag: Boolean = false) {
    val marginY = -170
    val binding = DlLoadingBinding.inflate(layoutInflater)
    setContentView(binding.root)
    window?.apply {
        setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        attributes.apply {
            y = marginY
            gravity = Gravity.CENTER
        }
    }
    show()
    setCancelable(stopFlag)
}
fun Dialog.openDlChangeUser(stopFlag: Boolean = false) {
    val marginY = -100
    val binding = DlChangeUserBinding.inflate(layoutInflater)
    setContentView(binding.root)
    window?.apply {
        setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        attributes.apply {
            y = marginY
            gravity = Gravity.CENTER
        }
    }
    binding.btnOk.setOnClickListener {
        val dialog = context?.let { it1 -> Dialog(it1) }
        dialog?.openDlOk(true)
        this.dismiss()

    }
    binding.btnCencal.setOnClickListener {
        this.dismiss()
    }
    setCancelable(stopFlag)
    show()
}

fun Dialog.openDlChangeEmail(stopFlag: Boolean = false) {
    val marginY = -100
    val binding = DlChangeEmailBinding.inflate(layoutInflater)
    setContentView(binding.root)
    window?.apply {
        setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        attributes.apply {
            y = marginY
            gravity = Gravity.CENTER
        }
    }
    binding.btnOk.setOnClickListener {
        val dialog = context?.let { it1 -> Dialog(it1) }
        dialog?.openDlOk(true)
        this.dismiss()
    }
    binding.btnCencal.setOnClickListener {
        this.dismiss()
    }
    setCancelable(stopFlag)
    show()
}

fun Dialog.openDlCongrate(stopFlag: Boolean = false) {
    val marginY = -100
    val binding = DlSuccessfulTopicBinding.inflate(layoutInflater)
    setContentView(binding.root)
    window?.apply {
        setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        attributes.apply {
            y = marginY
            gravity = Gravity.CENTER
        }
    }
    binding.txtvCongratNameTopic.setOnClickListener {
        val dialog = context?.let { it1 -> Dialog(it1) }
        dialog?.openDlOk(true)
        this.dismiss()
    }
    binding.txtvChangeActiToHome.setOnClickListener {

        this.dismiss()
    }
    setCancelable(stopFlag)
    show()
}

fun Dialog.openDlChangePassword(stopFlag: Boolean = false) {
    val marginY = -100
    val binding = DlChangePasswordlBinding.inflate(layoutInflater)
    setContentView(binding.root)
    window?.apply {
        setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        attributes.apply {
            y = marginY
            gravity = Gravity.CENTER
        }
    }
    binding.btnOk.setOnClickListener {
        val dialog = context?.let { it1 -> Dialog(it1) }
        dialog?.openDlOk(true)
        this.dismiss()
    }
    binding.btnCencal.setOnClickListener {
        this.dismiss()
    }
    setCancelable(stopFlag)
    show()
}

fun Dialog.openDlChangeDate(stopFlag: Boolean = false) {
    val marginY = -100
    val binding = DlChangeDateBinding.inflate(layoutInflater)
    setContentView(binding.root)
    window?.apply {
        setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        attributes.apply {
            y = marginY
            gravity = Gravity.CENTER
        }
    }
    binding.txtDate.setOnClickListener {
        val Cal = Calendar.getInstance()
        val y = Cal.get(Calendar.YEAR)
        val m = Cal.get(Calendar.MONTH)
        val d = Cal.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(context, DatePickerDialog.OnDateSetListener { view, year,  month, myDay ->
            binding.txtDate.setText(""+myDay+" / "+month+" / "+year)
        }, y, m, d)
        dpd.show()
    }
    binding.btnOk.setOnClickListener {
        val dialog = context?.let { it1 -> Dialog(it1) }
        dialog?.openDlOk(true)
        this.dismiss()
    }
    binding.btnCencal.setOnClickListener {
        this.dismiss()
    }
    setCancelable(stopFlag)
    show()
}


fun Dialog.openDlOk(stopFlag: Boolean = false) {
    val binding = DlAnimationOkBinding.inflate(layoutInflater)
    setContentView(binding.root)
    window?.apply {
        setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        attributes.apply {
            gravity = Gravity.CENTER
        }
    }
    Handler(Looper.getMainLooper()).postDelayed({
        this.dismiss()
    },1700 )
    binding.lottie.animate().setDuration(1700).setStartDelay(0)

    setCancelable(stopFlag)
    show()
}
fun Dialog.openDlReport(stopFlag: Boolean = false) {
    val binding = DlReportBinding.inflate(layoutInflater)
    setContentView(binding.root)
    window?.apply {
        setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        attributes.apply {
            gravity = Gravity.CENTER
        }
    }
    binding.btnCencal.setOnClickListener {
        this.dismiss()
    }
    binding.btnOk.setOnClickListener {
        this.dismiss()
    }

    setCancelable(stopFlag)
    show()
}
fun Dialog.openDlNoted(stopFlag: Boolean = false) {
    val binding = DlNotedBinding.inflate(layoutInflater)
    setContentView(binding.root)
    window?.apply {
        setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        attributes.apply {
            gravity = Gravity.CENTER
        }
    }
    binding.btnCencal.setOnClickListener {
        this.dismiss()
    }
    binding.btnOk.setOnClickListener {
        val dialog = context?.let { it1 -> Dialog(it1) }
        dialog?.openDlOk(true)
        this.dismiss()
    }
    setCancelable(stopFlag)
    show()
}
