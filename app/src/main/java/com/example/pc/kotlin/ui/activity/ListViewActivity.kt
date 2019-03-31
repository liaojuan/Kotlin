package com.example.pc.kotlin.ui.activity

import com.example.pc.kotlin.R
import com.example.pc.kotlin.ui.adapter.ListViewAdapter
import com.example.pc.kotlin.ui.base.BaseActivity
import com.example.pc.kotlin.ui.contract.ListViewContract
import com.example.pc.kotlin.ui.presenter.ListViewPresenter
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : BaseActivity(), ListViewContract.View {
    private var listViewPresenter: ListViewPresenter ?= null
    var dataList = ArrayList<String>()
    var mAdapter: ListViewAdapter ?= null

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
        for(i in 0..10){
            dataList.add("hello")
        }
        mAdapter = ListViewAdapter(dataList, this.baseContext)
        list_view_lv?.adapter = mAdapter
    }
}