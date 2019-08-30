package com.easyhome.jrconsumer.mvp.ui.activity.project

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerDecorateProcessComponent
import com.easyhome.jrconsumer.di.module.DecorateProcessModule
import com.easyhome.jrconsumer.mvp.contract.project.DecorateProcessContract
import com.easyhome.jrconsumer.mvp.presenter.project.DecorateProcessPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.ui.adapter.ProcessAdapter
import kotlinx.android.synthetic.main.activity_decorate_process.*
import kotlinx.android.synthetic.main.layout_title.*


/**
 * 装修流程
 */
class DecorateProcessActivity : JRBaseActivity<DecorateProcessPresenter>(), DecorateProcessContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerDecorateProcessComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .decorateProcessModule(DecorateProcessModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_decorate_process //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {

        tvPageTitle.text = "装修流程"
        ivPageBack.singleClick { killMyself() }
        processRV.adapter = ProcessAdapter(arrayListOf("", "", ""))
    }


    override fun showLoading() {

    }

    override fun hideLoading() {

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
