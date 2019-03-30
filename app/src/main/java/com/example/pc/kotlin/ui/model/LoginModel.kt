package com.example.pc.kotlin.ui.model

import com.example.pc.kotlin.ui.contract.LoginContract

class LoginModel : LoginContract.Model{
    var username : String ?= null
    var password : String ?= null
}
