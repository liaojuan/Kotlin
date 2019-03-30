package com.example.pc.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import com.example.pc.kotlin.ui.fragment.FirstFragment
import com.example.pc.kotlin.ui.fragment.SecondFragment
import com.example.pc.kotlin.ui.fragment.ThreeFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class MainActivity : AppCompatActivity() {
    private var firstFragment: FirstFragment ?= null
    private var secondFragment: SecondFragment ?= null
    private var threeFragment: ThreeFragment ?= null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**设置ActionBar
        *不使用toolbar自带的标题
       */
        toolbar.title = ""
        setSupportActionBar(toolbar)
        //显示Home图标
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        //设置ToolBar标题，使用TestView显示
        tv_bar_title.text = "Item1"

        //设置Drawerlayout的开关,并且和Home图标联动
        val mToggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, 0, 0)
        drawer_layout.addDrawerListener(mToggle)
        //同步drawerlayout的状态
        mToggle.syncState()

        setListener()

        initFragment(savedInstanceState)
    }

    private fun initFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState != null){
            //异常情况
            val mFragments: List<Fragment> = supportFragmentManager.fragments
            for (item in mFragments){
                if (item is FirstFragment){
                    firstFragment = item
                }
                if (item is SecondFragment){
                    secondFragment = item
                }
                if (item is ThreeFragment){
                    threeFragment = item
                }
            }
        }else{
            firstFragment = FirstFragment()
            secondFragment = SecondFragment()
            threeFragment = ThreeFragment()
            val fragmentTrans = supportFragmentManager.beginTransaction()
            fragmentTrans.add(R.id.fl_content, firstFragment!!)
            fragmentTrans.add(R.id.fl_content, secondFragment!!)
            fragmentTrans.add(R.id.fl_content, threeFragment!!)
            fragmentTrans.commit()
        }
        supportFragmentManager.beginTransaction().show(firstFragment!!).hide(secondFragment!!).hide(threeFragment!!).commit()
    }

    /*设置监听器*/
    private fun setListener() {
        nav_view.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_item1-> {
                    tv_bar_title.text = "Item1"
                    supportFragmentManager.beginTransaction().show(firstFragment!!)
                            .hide(secondFragment!!)
                            .hide(threeFragment!!)
                            .commit()
                }
                R.id.nav_item2 -> {
                    tv_bar_title.text = "Item2"
                    supportFragmentManager.beginTransaction().show(secondFragment!!)
                            .hide(firstFragment!!)
                            .hide(threeFragment!!)
                            .commit()
                }
                R.id.nav_item3 -> {
                    tv_bar_title.text = "Item3"
                    supportFragmentManager.beginTransaction().show(threeFragment!!)
                            .hide(firstFragment!!)
                            .hide(secondFragment!!)
                            .commit()
                }
            }
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }
    }
}
