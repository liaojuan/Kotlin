package com.example.pc.kotlin.ui.adapter

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup

import com.example.pc.kotlin.R

class GuidePageAdapter(private val viewList: List<View>?) : PagerAdapter() {
    private val mResIds = intArrayOf(R.mipmap.intro_1, R.mipmap.intro_2, R.mipmap.intro_3)

    /**
     * @return 返回页面的个数
     */
    override fun getCount(): Int {
        return viewList?.size ?: 0
    }

    /**
     * 判断对象是否生成界面
     * @param view
     * @param object
     * @return
     */
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    /**
     * 初始化position位置的界面
     * @param container
     * @param position
     * @return
     */

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        //在此设置背景图片，提高加载速度，解决OOM问题
        val view = viewList!![position]
        val count = count
        val params = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
        view.setBackgroundResource(mResIds[position % count])
        view.layoutParams = params
        container.addView(viewList[position])
        return viewList[position]
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(viewList!![position])
    }
}