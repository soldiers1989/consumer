package com.easyhome.jrconsumer.mvp.ui.activity

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerMessageInfoComponent
import com.easyhome.jrconsumer.di.module.MessageInfoModule
import com.easyhome.jrconsumer.mvp.contract.MessageInfoContract
import com.easyhome.jrconsumer.mvp.presenter.MessageInfoPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import kotlinx.android.synthetic.main.layout_title.*


/**
 * 消息中心
 */
class MessageInfoActivity : JRBaseActivity<MessageInfoPresenter>(), MessageInfoContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMessageInfoComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .messageInfoModule(MessageInfoModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_message_info //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        tvPageTitle.text = "消息中心"
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
