package com.example.lotto_mvvm.ui.dashboard.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lotto_mvvm.ui.dashboard.model.Lotto_model
import com.example.lotto_mvvm.ui.dashboard.viewholder.Lotto_viewholder
import com.example.lotto_mvvm.ui.type.EnumViewType

class lotto_adapter(private val array : ArrayList<Lotto_model>, private val viewType : EnumViewType) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        when ( viewType ){
            1 -> {
                return Lotto_viewholder.creates(parent)
            }
            else -> {
                throw Exception("")
            }
        }
    }

    override fun getItemCount() = array.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val data = array[position]

        when ( holder ){

            is Lotto_viewholder -> {
               holder.bind(data)
            }
        }

    }

    override fun getItemViewType(position: Int): Int {

        when ( viewType ){

            EnumViewType.LOTTOITEM -> {
                return 1
            }
        }
    }

}