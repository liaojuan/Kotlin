package com.example.pc.kotlin.ui.contract

interface ListViewContract {
    interface Model

    interface View{
        fun doIitemClick()
    }

    interface Presenter{
        fun doIitemClick()
    }
}
