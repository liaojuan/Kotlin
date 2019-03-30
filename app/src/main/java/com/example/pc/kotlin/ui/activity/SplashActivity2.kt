package com.example.pc.kotlin.ui.activity

import android.content.Intent
import android.os.Handler
import android.os.Message
import com.example.pc.kotlin.MainActivity
import com.example.pc.kotlin.R
import com.example.pc.kotlin.ui.base.BaseActivity
import com.example.pc.kotlin.utils.Constant
import com.example.pc.kotlin.utils.PreferencesUtil
import java.lang.ref.WeakReference

class SplashActivity2 : BaseActivity() {

    private val handler = MyHandler(this)

    override fun getLayoutID(): Int {
        return R.layout.activity_splash
    }

    override fun initListener() {
    }

    override fun initView() {


    }

    override fun initData() {
    }


    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 2000)
    }

    val runnable = Runnable {
        kotlin.run {
            val message = handler.obtainMessage(Constant.ZERO)
            handler.sendMessage(message)
        }
    }



    private class MyHandler(activity: SplashActivity2) : Handler() {
        private val mActivity: WeakReference<SplashActivity2> = WeakReference(activity)

        override fun handleMessage(msg: Message?) {
            if (mActivity.get() == null){
                return
            }
            val activity = mActivity.get()
            if (msg != null) {
                when(msg.what){
                    Constant.ZERO -> {
                        val isFirstUse = PreferencesUtil.getBoolean(Constant.splash)
                        if (!isFirstUse){
                            val intent = Intent(activity, GuideActivity().javaClass)
                            if (activity != null) {
                                activity.startActivity(intent)
                                activity.finish()
                            }
                        }
                        else{
//                            val intent = Intent(activity, MainActivity::class.java)
//                            val intent = Intent(activity, MainActivity2::class.java)
//                            val intent = Intent(activity, TestMvpActivity::class.java)
                            val intent = Intent(activity, LoginActivity::class.java)
                            activity!!.startActivity(intent)
                            activity.finish()
                        }
                    }
                    else -> {

                    }
                }
            }
        }
    }


    override fun onDestroy() {
        MyHandler(this).removeCallbacksAndMessages(null)
        super.onDestroy()
    }



}