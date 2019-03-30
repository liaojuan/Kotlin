package com.example.pc.kotlin.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutID())
        initView()
    }

    //获取布局
    protected abstract fun getLayoutID(): Int
    //点击事件
    abstract fun initListener()
    //初始化数据
    abstract fun initView()
    //加载数据
    abstract fun initData()
}