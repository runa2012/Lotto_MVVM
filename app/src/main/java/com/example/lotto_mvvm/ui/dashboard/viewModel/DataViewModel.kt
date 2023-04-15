package com.example.lotto_mvvm.ui.dashboard.viewModel

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.example.lotto_mvvm.ui.dashboard.adapter.lotto_adapter
import com.example.lotto_mvvm.ui.dashboard.model.Lotto_model
import com.example.lotto_mvvm.ui.type.EnumViewType

class DataViewModel : BaseObservable() {

    var array : ArrayList<Lotto_model> = ArrayList()
    var lottolistAdapter : lotto_adapter = lotto_adapter(array, EnumViewType.LOTTOITEM )
    var currentNumber  = MutableLiveData<String>() //: String = ""
    private var count : Int = 0

    fun startNumber(){
        count++

        val valuearray = ArrayList<Int>()
        currentNumber.value = ""
        while ( valuearray.size < 6){
            val random = ( Math.random() * 45 + 1 ).toInt()
            if ( !valuearray.contains(random)){
                currentNumber.value += " $random"
                valuearray.add(random)
            }
        }

        val data = Lotto_model( count , valuearray )
        array.add(data)

        lottolistAdapter.notifyDataSetChanged()

//        notifyChange()
    }



}