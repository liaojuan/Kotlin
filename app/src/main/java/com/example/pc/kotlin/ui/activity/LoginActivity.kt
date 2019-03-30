package com.example.pc.kotlin.ui.activity

import android.view.View
import com.example.pc.kotlin.R
import com.example.pc.kotlin.ui.base.BaseActivity
import com.example.pc.kotlin.ui.contract.LoginContract

class LoginActivity: BaseActivity() ,LoginContract.View, View.OnClickListener{

    override fun onClick(v: View?) {

    }

    override fun doClean() {

    }

    override fun loginResult(isSuccess: Boolean, messing: String) {
    }

    override fun getLayoutID(): Int {
        return R.layout.activity_login
    }

    override fun initListener() {
    }

    override fun initView() {
    }

    override fun initData() {
    }
}