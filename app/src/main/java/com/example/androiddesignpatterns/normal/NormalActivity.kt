package com.example.androiddesignpatterns.normal

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androiddesignpatterns.databinding.ActivityNormalBinding
import com.example.androiddesignpatterns.bean.Account
import com.example.androiddesignpatterns.callback.MCallback
import kotlin.random.Random

class NormalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNormalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNormalBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initView()

    }

    private fun initView() {

        binding.button.setOnClickListener {
            getAccounData(getUserInput(), object : MCallback {
                override fun onSuccess(account: Account) {
                    showSuccessPage(account)
                }

                override fun onFailled() {
                    showFailPage()
                }
            })

        }
    }

    //获取用户输入的信息
    private fun getUserInput(): String {

        return binding.etAccount.text.toString()


    }

    //展示数据显示成功

    @SuppressLint("SetTextI18n")
    private fun showSuccessPage(account: Account) {

        binding.tvResult.text = "用户账户:" + account.name + "用户等级:" + account.level

    }

    //展示数据失败
    private fun showFailPage() {

        binding.tvResult.text = "获取数据失败"

    }


    //查询账号数据
    private fun getAccounData(accountName: String, callback: MCallback) {

        val miscount = Account()//模拟数据有没有数据
        if (Random.nextBoolean()) {
            miscount.name = accountName //账号
            miscount.level = 100 //默认100级
            callback.onSuccess(miscount)
        } else {
            callback.onFailled()
        }

    }


}