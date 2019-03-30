package com.example.pc.kotlin.ui.activity

import android.content.Intent
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.pc.kotlin.MainActivity
import com.example.pc.kotlin.R
import com.example.pc.kotlin.ui.adapter.GuidePageAdapter
import com.example.pc.kotlin.ui.base.BaseActivity
import com.example.pc.kotlin.utils.Constant
import com.example.pc.kotlin.utils.PreferencesUtil
import kotlinx.android.synthetic.main.activity_guide.*

class GuideActivity : BaseActivity(), ViewPager.OnPageChangeListener{

//    private var vp: ViewPager ?= null
    private var imageIdArray: IntArray ?= null //图片资源的数组
    private var viewList: MutableList<View> ?= null //图标资源的集合
//    private var vg : ViewGroup ?= null//放置圆点

    //实例化原点View
    private var iv_point: ImageView ?= null
    private var ivPointArray : Array<ImageView?> ?= null

    override fun getLayoutID(): Int {
        return R.layout.activity_guide
    }

    override fun initListener() {
    }

    override fun initView() {
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        guide_ib_start.setOnClickListener{
            PreferencesUtil.saveValue(Constant.splash, true)
            val intent: Intent = Intent(this, MainActivity::class.java)
            intent.putExtra("openAPP", true)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            startActivity(intent)
            finish()
        }

        initViewPager()

        initPoint()
    }

    override fun initData() {
    }

    override fun onPageScrollStateChanged(p0: Int) {
    }

    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
    }

    override fun onPageSelected(p0: Int) {
        //循环设置当前页的标记图
        val length = imageIdArray!!.size
        Log.e("TAG", "---------$p0---$length----")
        for (i in 0 until length){
            if (p0 == i)
                ivPointArray!![p0]!!.setBackgroundResource(R.mipmap.icon_hodgepodge)
            else
                ivPointArray!![i]!!.setBackgroundResource(R.mipmap.icon_bosom)
        }

        //判断是否是最后一页,若是则显示按钮
        if (p0 == imageIdArray!!.size-1)
            guide_ib_start.visibility = View.VISIBLE
        else
            guide_ib_start.visibility = View.GONE
    }

    //加载ViewPager
    private fun initViewPager(){
        //实例化图片资源
        imageIdArray = intArrayOf(R.mipmap.intro_1, R.mipmap.intro_2, R.mipmap.intro_3)
        viewList = ArrayList()

        //循环创建View并加入到集合中
        val len = imageIdArray!!.size
        for (i in 0 until len){
//            for (i in 0..len - 1){
            //new ImageView并设置全屏和图片资源
            val imageView = ImageView(this)
            viewList!!.add(imageView)
        }

        //View集合初始化好后，设置Adapter
        guide_vp.adapter = GuidePageAdapter(viewList)
        guide_vp.offscreenPageLimit = 4

        //设置滑动监听
        guide_vp.setOnPageChangeListener(this)
    }

    //加载底部圆点
    private fun initPoint(){
        //根据Viewpager的item数量实例化数组
        ivPointArray = arrayOfNulls(viewList!!.size)
        //循环新建底部圆点ImageView，将生成的ImageView保存到数组中
        val size = viewList!!.size
        for (i in 0..size-1){
            iv_point = ImageView(this)
            iv_point!!.layoutParams = ViewGroup.LayoutParams(50,50)
            iv_point!!.setPadding(20,0, 20, 150)
            ivPointArray!![i] = iv_point!!
            //第一个页面需要设置为选中状态，这里采用两张不同的图片
            if (i == 0)
                iv_point!!.setBackgroundResource(R.mipmap.icon_hodgepodge)
            else
                iv_point!!.setBackgroundResource(R.mipmap.icon_bosom)
            //将数组中的ImageView加入到ViewGroup
            guide_ll_point.addView(ivPointArray!![i])
        }
    }
}