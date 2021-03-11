package com.example.androiddesignpatterns.callback

import com.example.androiddesignpatterns.bean.Account

/**
 * 作者: QQ:1396797522
 * 时间: 2021/3/11 15:57
 * 描述:
 */
interface MCallback {
    fun onSuccess(account: Account)
    fun onFailled()
}
