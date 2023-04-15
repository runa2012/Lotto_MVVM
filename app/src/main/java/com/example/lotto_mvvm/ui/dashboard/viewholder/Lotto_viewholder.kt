package com.example.lotto_mvvm.ui.dashboard.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lotto_mvvm.databinding.ItemLottoBinding
import com.example.lotto_mvvm.ui.dashboard.model.Lotto_model

class Lotto_viewholder( private val binding : ItemLottoBinding) : RecyclerView.ViewHolder(binding.root) {


    fun bind( item : Lotto_model){

        binding.itemLottoCount.text = String.format("%s회 : " , item.count.toString() )

        binding.itemLottoNumber.text = item.number1?.joinToString(" , ")

    }


    companion object factory {

        fun creates( parent : ViewGroup ) : Lotto_viewholder {
            var binding = ItemLottoBinding.inflate(LayoutInflater.from(parent.context) , parent , false )
            return Lotto_viewholder(binding)
        }

    }


}