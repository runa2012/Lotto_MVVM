package com.example.lotto_mvvm.ui.viewmvvm.vindModel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lotto_mvvm.model.Lotto_model
import com.example.lotto_mvvm.type.EnumViewType
import com.example.lotto_mvvm.ui.exview.adapter.lotto_VM_adapter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewBindingViewModel : ViewModel() {

    private val _currentNumber = MutableLiveData<String>().apply {
        value = ""
    }
    val currentNumber: LiveData<String> = _currentNumber
    private var count : Int = 0
    private val _randomNumberList = HashSet<Int>()
    private val _notNumberList = HashSet<Int>()
    private val _numberList : MutableStateFlow<List<Lotto_model>> = MutableStateFlow(listOf())
    val numberList : StateFlow<List<Lotto_model>> = _numberList
    val lottolistAdapter : lotto_VM_adapter by lazy { lotto_VM_adapter(_numberList, EnumViewType.LOTTOITEM ) }

    @SuppressLint("NotifyDataSetChanged")
    fun startNumber(){
        count++
        val valuearray = HashSet<Int>()
        _currentNumber.value = ""
        while ( valuearray.size < 6){
            val random = ( Math.random() * 45 + 1 ).toInt()
            valuearray.add(random)
        }

        viewModelScope.launch {
            _currentNumber.value = valuearray.toString()
        }

        _randomNumberList.addAll(valuearray)

        val data = Lotto_model( count , valuearray )
        _numberList.value += data

        lottolistAdapter.notifyDataSetChanged()
    }

    fun getNotNumber(){
        count++
        val valuearray = HashSet<Int>()
        _currentNumber.value = ""
        while ( valuearray.size < 6){
            val random = ( Math.random() * 45 + 1 ).toInt()
            if ( !_randomNumberList.contains(random)){
                valuearray.add(random)
            }
        }

        viewModelScope.launch {
            _currentNumber.value = valuearray.toString()
        }

        val data = Lotto_model( count , valuearray )
        _numberList.value += data

        lottolistAdapter.notifyDataSetChanged()
    }

    fun getIsNumber(){
        count++
        val valuearray = HashSet<Int>()
        _currentNumber.value = ""
        while ( valuearray.size < 6){
            val random = ( Math.random() * 45 + 1 ).toInt()
            if ( _randomNumberList.contains(random) || _notNumberList.contains(random )){
                valuearray.add(random)
            }
        }

        viewModelScope.launch {
            _currentNumber.value = valuearray.toString()
        }

        val data = Lotto_model( count , valuearray )
        _numberList.value += data

        lottolistAdapter.notifyDataSetChanged()
    }

}