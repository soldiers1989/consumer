package com.easyhome.jrconsumer.mvp.ui.activity

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerPredetermineComponent
import com.easyhome.jrconsumer.di.module.PredetermineModule
import com.easyhome.jrconsumer.mvp.contract.PredetermineContract
import com.easyhome.jrconsumer.mvp.presenter.PredeterminePresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import kotlinx.android.synthetic.main.layout_title.*


/**
 * 预约设计
 */
class PredetermineActivity : JRBaseActivity<PredeterminePresenter>(), PredetermineContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerPredetermineComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .predetermineModule(PredetermineModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_predetermine //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {

        tvPageTitle.text = "预约设计师"
        ivPageBack.singleClick { killMyself() }


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
