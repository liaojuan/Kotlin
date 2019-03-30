package com.example.pc.kotlin.ui.activity

import android.content.Intent
import android.os.Handler
import android.os.Message
import com.example.pc.kotlin.MainActivity
import com.example.pc.kotlin.R
import com.example.pc.kotlin.ui.base.BaseActivity
import com.example.pc.kotlin.utils.Constant
import com.example.pc.kotlin.utils.PreferencesUtil

class SplashActivity : BaseActivity() {

    // 委托属性，Preference把取值和存值的操作代理给variable，我们对userId的赋值和取值最终是操作的Preference得setValue和getValue函数。
    //private var variable by Preference("keyName", "10")//由于已经能够推断出variable的类型是String，所以这里的variable省去了类型。
    //完整写法如下：
    //private var variable: String by Preference("keyName", "10")

    //默认是为加载过引导页面的
//    var isFirstUse = PreferencesUtil.getBoolean(Constant.splash)

//    private val handler = MyHandler(SplashActivity())
//    private lateinit var myThread: Thread

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//////        initView()
////        setContentView(R.layout.activity_splash)
//    }

    override fun getLayoutID(): Int {
        return R.layout.activity_splash
    }

    override fun initListener() {
    }

    override fun initView() {
//        if (isFirstUse)
//            ContextCompat.startActivity(Intent(this, GuideActivity::class.java))
//        else
//            ContextCompat.startActivity(Intent(this, MainActivity::class.java))
//        myThread = object : Thread(){
//            override fun run() {
//                super.run()
//                MyHandler(this@SplashActivity).sendEmptyMessageDelayed(Constant.ZERO, 2000)
//            }
//        }
        //初始化myThread
        myThread = object : Thread(){
            override fun run() {
                super.run()
                handler.sendEmptyMessageDelayed(Constant.ZERO, 2000)
            }
        }
        //初始化handler
        handler = object : Handler(){
            override fun handleMessage(msg: Message?) {
                super.handleMessage(msg)
                if (msg?.what == Constant.ZERO){
                    val isFirstUse = PreferencesUtil.getBoolean(Constant.splash)
                    if (isFirstUse){
                            val intent = Intent(this@SplashActivity, GuideActivity().javaClass)
                                startActivity(intent)
                        }
                        else{
                            val intent = Intent(this@SplashActivity, MainActivity::class.java)
                            startActivity(intent)
                        }
                }
            }
        }
    }

    override fun initData() {
    }


    override fun onResume() {
        super.onResume()
        if (!(myThread!!.isAlive))
//        if (!myThread.isAlive)
            myThread.start()
//        handler.postDelayed(runnable, 2000)
    }
//
//    val runnable = Runnable {
//        kotlin.run {
//            val message = handler.obtainMessage(Constant.ZERO)
//            handler.sendMessage(message)
//        }
//    }
//
    override fun onStop() {
        super.onStop()
        //判断线程是否仍活着
        if (myThread.isAlive) {
            myThread.interrupt()
        }
    }
//
//    private class MyHandler(activity: SplashActivity) : Handler() {
//        private val mActivity: WeakReference<SplashActivity> = WeakReference(activity)
//
//        override fun handleMessage(msg: Message?) {
//            if (mActivity.get() == null){
//                return
//            }
//            val activity = mActivity.get()
//            if (msg != null) {
//                when(msg.what){
//                    Constant.ZERO -> {
//                        val isFirstUse = PreferencesUtil.getBoolean(Constant.splash)
//                        if (isFirstUse){
//                            val intent = Intent(activity, GuideActivity().javaClass)
//                            if (activity != null) {
//                                activity.startActivity(intent)
//                            }
//                        }
//                        else{
//                            val intent = Intent(activity, MainActivity::class.java)
//                            activity!!.startActivity(intent)
//                        }
//                    }
//                    else -> {
//
//                    }
//                }
//            }
//        }
////
//////        fun activityTiaozhuan(ctx: Context, clazz:Class<Any>){
//////            var intent = Intent()
//////            intent.setClass(ctx,clazz)
//////            startActivity(intent)
//////        }
//    }
//
//
//    override fun onDestroy() {
//        MyHandler(this).removeCallbacksAndMessages(null)
//        super.onDestroy()
//    }

    //声明变量
    private lateinit var handler: Handler
    private lateinit var myThread: Thread

}