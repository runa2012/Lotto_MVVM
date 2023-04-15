package com.example.lotto_mvvm.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lotto_mvvm.R
import com.example.lotto_mvvm.databinding.FragmentDatabindingBinding
import com.example.lotto_mvvm.ui.dashboard.viewModel.DataViewModel

class DataBindingFragment : Fragment() {

    private var _binding: FragmentDatabindingBinding? = null
    private val binding get() = _binding!!
    lateinit var dataViewModel : DataViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        _binding = DataBindingUtil.setContentView( requireActivity() , R.layout.fragment_databinding )
        _binding = DataBindingUtil.inflate(inflater , R.layout.fragment_databinding ,container, false)
        dataViewModel = DataViewModel()
        _binding?.datamodel = dataViewModel
        _binding?.lifecycleOwner = requireActivity()

        _binding?.databLottolist?.layoutManager = LinearLayoutManager( requireContext() , LinearLayoutManager.VERTICAL , false )
        _binding?.databLottolist?.adapter = dataViewModel.lottolistAdapter

        _binding?.executePendingBindings()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}