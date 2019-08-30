package com.easyhome.jrconsumer.mvp.ui.activity.user

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerConfirmPhoneNumberComponent
import com.easyhome.jrconsumer.di.module.ConfirmPhoneNumberModule
import com.easyhome.jrconsumer.mvp.contract.user.ConfirmPhoneNumberContract
import com.easyhome.jrconsumer.mvp.presenter.user.ConfirmPhoneNumberPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity


/**
 * 修改手机号-确认
 */
class ConfirmPhoneNumberActivity : JRBaseActivity<ConfirmPhoneNumberPresenter>(), ConfirmPhoneNumberContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerConfirmPhoneNumberComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .confirmPhoneNumberModule(ConfirmPhoneNumberModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_confirm_phone_number //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {

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
