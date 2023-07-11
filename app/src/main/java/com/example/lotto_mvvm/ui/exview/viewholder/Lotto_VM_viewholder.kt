package com.example.lotto_mvvm.ui.exview.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lotto_mvvm.databinding.ItemLottoBinding
import com.example.lotto_mvvm.model.Lotto_model

class Lotto_VM_viewholder(private val binding : ItemLottoBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind( item : Lotto_model){
        binding.itemLottoCount.text = String.format("%s회 : " , item.count.toString() )
        binding.itemLottoNumber.text = item.number1?.joinToString(" , ")
    }

    companion object {
        fun creates( parent : ViewGroup ) : Lotto_VM_viewholder {
            val binding = ItemLottoBinding.inflate(LayoutInflater.from(parent.context) , parent , false )
            return Lotto_VM_viewholder(binding)
        }
    }

}