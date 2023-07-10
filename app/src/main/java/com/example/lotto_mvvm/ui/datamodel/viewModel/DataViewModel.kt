package com.example.lotto_mvvm.ui.datamodel.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.lotto_mvvm.ui.datamodel.adapter.lotto_adapter
import com.example.lotto_mvvm.model.Lotto_model
import com.example.lotto_mvvm.type.EnumViewType
import com.example.lotto_mvvm.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DataViewModel : BaseViewModel() {

    private val _numberList : MutableStateFlow<List<Lotto_model>> = MutableStateFlow(listOf())
    val numberList : StateFlow<List<Lotto_model>> = _numberList.asStateFlow()

    val lottolistAdapter : lotto_adapter by lazy { lotto_adapter( _numberList , EnumViewType.LOTTOITEM ) }
    var currentNumber = MutableStateFlow<String>("")
    private var count : Int = 0

    @SuppressLint("NotifyDataSetChanged")
    fun startNumber(){
        count++
        val valuearray = ArrayList<Int>()
        currentNumber.value = ""
        while ( valuearray.size < 6){
            val random = ( Math.random() * 45 + 1 ).toInt()
            if ( !valuearray.contains(random)){
                viewModelScope.launch {
                    currentNumber.emit("${currentNumber.value} $random")
                }
                valuearray.add(random)
            }
        }

        val data = Lotto_model( count , valuearray )
        _numberList.value += data
        lottolistAdapter.notifyDataSetChanged()
    }

}