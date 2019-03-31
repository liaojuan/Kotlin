package com.example.pc.kotlin.ui.presenter

import com.example.pc.kotlin.ui.activity.LoginActivity
import com.example.pc.kotlin.ui.contract.LoginContract

class LoginPresenter(private val loginActivity: LoginActivity) : LoginContract.Presenter {
    override fun intentsUtils() {//针对跳转
        loginActivity.intentsUtils()
    }

    override fun clean() {
        loginActivity.doClean()
    }

    override fun doLogin(username: String, password: String) {
        if ("wangjitao" == username && "123" == password) {
            loginActivity.loginResult(true, "user:$username,pass:$password")
        } else {
            loginActivity.loginResult(false, "user:$username,pass:$password")
        }
    }
}

