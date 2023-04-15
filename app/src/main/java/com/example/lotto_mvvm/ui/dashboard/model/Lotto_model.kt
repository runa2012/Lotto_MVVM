package com.example.lotto_mvvm.ui.dashboard.model

class Lotto_model {


    var count : Int? = null
    var number1 : ArrayList<Int>? = null

    constructor(count: Int?, number1: ArrayList<Int>?) {
        this.count = count
        this.number1 = number1
    }
}