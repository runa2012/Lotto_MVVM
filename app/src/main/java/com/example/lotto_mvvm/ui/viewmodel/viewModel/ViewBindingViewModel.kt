package com.example.lotto_mvvm.ui.viewmvvm.vindModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lotto_mvvm.type.EnumViewType
import com.example.lotto_mvvm.ui.dashboard.adapter.lotto_adapter
import com.example.lotto_mvvm.ui.dashboard.model.Lotto_model

class ViewBindingViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = ""
    }
    val text: LiveData<String> = _text
    private var count : Int = 0
    var array : ArrayList<Lotto_model> = ArrayList()
    var lottolistAdapter : lotto_adapter = lotto_adapter(array, EnumViewType.LOTTOITEM )

    fun startNumber(){
        count++

        val valuearray = ArrayList<Int>()
        _text.value = ""
        for ( i in 0 until  6){
            var random = ( Math.random() * 45 + 1 ).toInt()
            _text.value += " $random"
            valuearray.add(random)
        }

        val data = Lotto_model( count , valuearray )
        array.add(data)

        lottolistAdapter.notifyDataSetChanged()

    }




}