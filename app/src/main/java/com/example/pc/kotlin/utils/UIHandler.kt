package com.example.pc.kotlin.utils

import java.lang.ref.WeakReference
import java.util.logging.Handler
import java.util.logging.LogRecord


/**
 * 采用弱引用handler 防止内存泄漏
 */
open class UIHandler<T>(cls: T) : Handler(){

    protected var ref : WeakReference<T>? = null

    init {
        ref = WeakReference(cls)
    }

    fun getRef(): T? {
        return if (ref != null) ref!!.get() else null
    }

    override fun publish(record: LogRecord?) {
    }

    override fun flush() {
    }

    override fun close() {
    }
}