package com.easyhome.jrconsumer.mvp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerConfirmComponent
import com.easyhome.jrconsumer.di.module.ConfirmModule
import com.easyhome.jrconsumer.mvp.contract.ConfirmContract
import com.easyhome.jrconsumer.mvp.presenter.ConfirmPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import kotlinx.android.synthetic.main.activity_confirm.*
import kotlinx.android.synthetic.main.layout_title.*
import org.jetbrains.anko.startActivity


/**
 * 设置新密码
 */
class ConfirmActivity : JRBaseActivity<ConfirmPresenter>(), ConfirmContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerConfirmComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .confirmModule(ConfirmModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_confirm //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        ivPageBack.singleClick { finish() }
        tvPageTitle.text = "设置新密码"
        accountTV.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                println("输入的是${p0.toString()}")

            }

        })
        passwordED.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                println("输入的是${p0.toString()}")

            }

        })

        confirmB.singleClick {
            if (accountTV.text.toString().equals(passwordED.text.toString())) {
                mPresenter!!.alter(
                    mapOf(
                        Pair("mobile", intent.getStringExtra("mobile")),
                        Pair("type", "1"),
                        Pair("newPassword", "${passwordED.text.toString()}")
                    )
                ) {
                    startActivity<MainActivity>()
                }
            }
        }
    }


    override fun showMessage(message: String) {
        ArmsUtils.snackbarText(message)
    }

    override fun launchActivity(intent: Intent) {
        ArmsUtils.startActivity(intent)
    }

    override fun killMyself() {
        finish()
    }
}
