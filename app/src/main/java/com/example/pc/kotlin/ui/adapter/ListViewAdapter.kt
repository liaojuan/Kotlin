package com.example.pc.kotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.pc.kotlin.R
import kotlinx.android.synthetic.main.list_view_item.view.*

class ListViewAdapter(list: List<String>, mContext: Context) : BaseAdapter() {

    var itemList: List<String> ?= null
    var mViewHolder: MyViewHolder ?= null
//    lateinit var mContext: Context
    var mContext: Context

    init {
        itemList = list
        this.mContext = mContext
    }

    //https://blog.csdn.net/u012489412/article/details/82386112 listview
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var mConvertView = convertView
        if (convertView == null){
            mConvertView = LayoutInflater.from(mContext).inflate(R.layout.list_view_item, null)
            mViewHolder = MyViewHolder(mConvertView)
            mConvertView!!.tag = mViewHolder
        }else{
            mViewHolder = convertView.getTag() as MyViewHolder
        }
        mViewHolder!!.mContentTv!!.text = itemList!![position]
        return mConvertView!!
    }

    override fun getItem(position: Int): Any {
        return itemList!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return itemList?.size ?: 0
    }

    inner class MyViewHolder(view: View){
        var mContentTv:TextView?=null

        init {
            mContentTv = view.list_item_content_txt
        }

    }
}