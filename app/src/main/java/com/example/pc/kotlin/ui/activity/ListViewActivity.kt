package com.example.pc.kotlin.ui.activity

import com.example.pc.kotlin.R
import com.example.pc.kotlin.ui.base.BaseActivity
import com.example.pc.kotlin.ui.contract.ListViewContract
import com.example.pc.kotlin.ui.presenter.ListViewPresenter
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : BaseActivity(), ListViewContract.View {
    private var listViewPresenter: ListViewPresenter ?= null

    override fun doIitemClick() {
    }

    override fun getLayoutID(): Int {
        return R.layout.activity_list_view
    }

    override fun initListener() {
    }

    override fun initView() {
        listViewPresenter = ListViewPresenter()
    }

    override fun initData() {
    }
}