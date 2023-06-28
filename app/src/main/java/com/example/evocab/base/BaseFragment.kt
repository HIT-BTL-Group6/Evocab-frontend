package com.example.sourcebase.base

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
//import com.example.sourcebase.ultils.extension.start

abstract class BaseFragment<VB: ViewBinding>(
    private val BindingInflater: (LayoutInflater) -> VB
): Fragment() {
    private var _binding: VB? = null
    protected val binding get() = _binding as VB
    protected abstract val viewModel: BaseViewModel
    private val dialog by lazy{context?.let { Dialog(it) }}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BindingInflater(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*viewModel.isLoading.observe(viewLifecycleOwner) {
            if (it) {
                dialog?.start(false)
            } else {
                dialog?.dismiss()
            }
        }*/
        handleEvent()
        bindData()
        destroy()
    }
    abstract fun destroy()
    abstract fun initData()
    abstract fun handleEvent()
    abstract fun bindData()
}