package com.example.pc.kotlin.ui.presenter

import com.example.pc.kotlin.ui.activity.LoginActivity
import com.example.pc.kotlin.ui.contract.LoginContract

class LoginPresenter(private val loginActivity: LoginActivity) : LoginContract.Presenter {
    override fun clean() {
//        loginActivity.
    }

    override fun doLogin(username: String, password: String) {
    }
}


//class TestMvpPresenter(private val testMvpActivity: TestMvpActivity) : TestMvpContract.Presenter {
//
//    override fun clean() {
//        testMvpActivity.doClean()
//    }
//
//    override fun doLogin(username: String, password: String) {
//        if ("wangjitao" == username && "123" == password) {
//            testMvpActivity.loginResult(true, "user:$username,pass:$password")
//        } else {
//            testMvpActivity.loginResult(false, "user:$username,pass:$password")
//        }
//    }
//}