package com.example.pc.kotlin.ui.fragment

import com.example.pc.kotlin.R
import com.example.pc.kotlin.ui.base.BaseFragment

class FirstFragment : BaseFragment() {
    override fun getLayoutResources(): Int {
        return R.layout.fragment_first
    }

    override fun initView() {

    }

    override fun loadData() {
        //懒加载，当前Fragment显示的时候才进行网络请求
        //如果数据不需要每次都刷新，可以先判断数据是否存在
        //数据不存在 -> 进行网络请求    数据存在 -> 什么都不做
    }
}