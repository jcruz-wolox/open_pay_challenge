package com.example.openpay_challenge.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.openpay_challenge.R

abstract class BaseFragment<T : ViewBinding> : Fragment() {

    var baseViewModel: BaseViewModel? = null
    val binding get() = _binding!!
    private var _binding: T? = null

    protected open fun setUp(arguments: Bundle?) = Unit

    abstract fun getViewModel(): BaseViewModel

    protected open fun initView() = Unit

    abstract fun getBindingView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): T

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        baseViewModel = getViewModel()
        setUp(arguments)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getBindingView(inflater, container, savedInstanceState)
        initView()
        return binding.root
    }

    fun showPermissionRationale() {
        val alertBuilder = AlertDialog.Builder(requireContext())
        alertBuilder.setTitle(R.string.rationale_title)
        alertBuilder.setMessage(R.string.rationale_description)
        alertBuilder.setPositiveButton(R.string.ok) { dialog, _ ->
            dialog.dismiss()
        }
        alertBuilder.setCancelable(false)
        alertBuilder.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}




