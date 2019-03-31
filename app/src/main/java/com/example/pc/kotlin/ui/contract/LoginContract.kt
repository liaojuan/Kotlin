package com.example.pc.kotlin.ui.contract

interface LoginContract {
    interface Model

    interface View{
        fun doClean()

        fun loginResult(isSuccess: Boolean, messing: String)

        fun intentsUtils()
    }

    interface Presenter{
        fun clean()

        fun doLogin(username: String, password: String)

        fun intentsUtils()
    }
}
