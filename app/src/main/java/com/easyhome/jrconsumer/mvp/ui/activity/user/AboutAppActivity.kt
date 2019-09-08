package com.easyhome.jrconsumer.mvp.ui.activity.user

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerAboutAppComponent
import com.easyhome.jrconsumer.di.module.AboutAppModule
import com.easyhome.jrconsumer.mvp.contract.user.AboutAppContract
import com.easyhome.jrconsumer.mvp.presenter.user.AboutAppPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.ui.adapter.SettingOptionAdapter
import kotlinx.android.synthetic.main.activity_about_app.*
import kotlinx.android.synthetic.main.layout_title.*


/**
 * 关于APP
 */
class AboutAppActivity : JRBaseActivity<AboutAppPresenter>(), AboutAppContract.View {
    override fun getMyself(): BaseActivity<*> = this
    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerAboutAppComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .aboutAppModule(AboutAppModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_about_app //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        tvPageTitle.text = "关于APP"
        ivPageBack.singleClick { killMyself() }
        val adapter = SettingOptionAdapter(
            arrayListOf(
                SettingOptionAdapter.Bean("版本更新：", "V12.01"),
                SettingOptionAdapter.Bean("意见反馈：", "")
            )
        )
        adapter.setOnItemClickListener { adapter, view, position ->

            when (position) {
                0 -> {
                }
                1 -> {
                   // startActivity<CoupleBackActivity>()
                }
            }

        }

        optionRV.adapter = adapter
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
