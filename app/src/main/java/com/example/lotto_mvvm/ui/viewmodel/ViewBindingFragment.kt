package com.example.lotto_mvvm.ui.viewmodel

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lotto_mvvm.databinding.FragmentViewbindingBinding
import com.example.lotto_mvvm.ui.viewmvvm.vindModel.ViewBindingViewModel

class ViewBindingFragment : Fragment() , View.OnClickListener {

    private var _binding: FragmentViewbindingBinding? = null
    private val binding get() = _binding!!
    var homeViewModel : ViewBindingViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this)[ViewBindingViewModel::class.java]
        _binding = FragmentViewbindingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView: TextView = binding.databLottoCurrentNumber
        homeViewModel?.currentNumber?.observe(viewLifecycleOwner) {
            textView.text = it
        }

        binding.databGetlotto.setOnClickListener(this)
        binding.databLottolist.layoutManager = LinearLayoutManager( requireContext() , LinearLayoutManager.VERTICAL ,false)
        binding.databLottolist.adapter = homeViewModel?.lottolistAdapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        homeViewModel?.startNumber()
    }

}