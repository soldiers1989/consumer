package com.easyhome.jrconsumer.mvp.ui.activity.user

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerAlterPasswordComponent
import com.easyhome.jrconsumer.di.module.AlterPasswordModule
import com.easyhome.jrconsumer.mvp.contract.user.AlterPasswordContract
import com.easyhome.jrconsumer.mvp.presenter.user.AlterPasswordPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import kotlinx.android.synthetic.main.activity_user_data.*
import kotlinx.android.synthetic.main.layout_title.*


/**
 * 修改密码
 */
class AlterPasswordActivity : JRBaseActivity<AlterPasswordPresenter>(), AlterPasswordContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerAlterPasswordComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .alterPasswordModule(AlterPasswordModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_alter_password //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        tvPageTitle.text = "修改密码"
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
