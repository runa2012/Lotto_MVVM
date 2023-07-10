package com.example.lotto_mvvm.ui.datamodel

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lotto_mvvm.R
import com.example.lotto_mvvm.databinding.FragmentDatabindingBinding
import com.example.lotto_mvvm.base.BaseFragment
import com.example.lotto_mvvm.ui.datamodel.viewModel.DataViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class DataBindingFragment : BaseFragment<FragmentDatabindingBinding, DataViewModel, >( R.layout.fragment_databinding) {

    override val viewModel: DataViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.databLottolist.adapter = viewModel.lottolistAdapter
        binding.databGetlotto.setOnClickListener { viewModel.startNumber() }

        CoroutineScope(Main).launch {
            viewModel.currentNumber.collect{
                binding.databLottoCurrentNumber.text = it
            }
        }

    }
}