package com.example.lotto_mvvm.ui.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lotto_mvvm.databinding.FragmentViewbindingBinding
import com.example.lotto_mvvm.ui.viewmodel.vindModel.ViewBindingViewModel

class ViewBindingFragment : Fragment() {

    private var _binding: FragmentViewbindingBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(ViewBindingViewModel::class.java)
        _binding = FragmentViewbindingBinding.inflate(inflater, container, false)

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}