package com.example.pc.kotlin.ui.activity

import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.pc.kotlin.R
import com.example.pc.kotlin.ui.base.BaseActivity
import com.example.pc.kotlin.ui.contract.LoginContract
import com.example.pc.kotlin.ui.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: BaseActivity() ,LoginContract.View, View.OnClickListener{

    private var loginPresenter: LoginPresenter ?= null

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.button_clean -> {
                loginPresenter!!.clean()
            }
            R.id.button_login ->{
                loginPresenter!!.doLogin(editText_user!!.text.toString(), editText_pass!!.text.toString())
                Toast.makeText(this, "登陆成功：$editText_user", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun doClean() {
        editText_user.text = null
        editText_pass.text = null
    }

    override fun loginResult(isSuccess: Boolean, messing: String) {
        if (isSuccess) {
        Toast.makeText(this, "登陆成功：$messing", Toast.LENGTH_SHORT).show()
    } else {
        Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show()
    }
    }

    override fun getLayoutID(): Int {
        return R.layout.activity_login
    }

    override fun initListener() {
    }

    override fun initView() {

        loginPresenter = LoginPresenter(this)
        button_login.setOnClickListener(this)
        button_clean.setOnClickListener(this)
    }

    override fun initData() {
    }
}



