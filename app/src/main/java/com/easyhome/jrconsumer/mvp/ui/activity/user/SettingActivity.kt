package com.easyhome.jrconsumer.mvp.ui.activity.user

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerSettingComponent
import com.easyhome.jrconsumer.di.module.SettingModule
import com.easyhome.jrconsumer.mvp.contract.user.SettingContract
import com.easyhome.jrconsumer.mvp.presenter.user.SettingPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.openH5ForUrl
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.ui.adapter.ItemAdapter
import kotlinx.android.synthetic.main.activity_setting.*
import kotlinx.android.synthetic.main.layout_title.*
import org.jetbrains.anko.startActivity


/**
 * 设置
 */
class SettingActivity : JRBaseActivity<SettingPresenter>(), SettingContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerSettingComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .settingModule(SettingModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_setting //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        tvPageTitle.text = "设置"
        ivPageBack.singleClick { killMyself() }
        val adapter = ItemAdapter(arrayListOf("关于APP", "意见反馈"))
        adapter.setOnItemClickListener { adapter, view, position ->
            when(position){
                0->{
                   // startActivity<AboutAppActivity>()
openH5ForUrl("http://111.231.114.131/guochongyang/%E6%B6%88%E8%B4%B9%E8%80%85-moblie/m_%20about.html",
    "关于我们")
                }
                1->{
                    startActivity<CoupleBackActivity>()

                }

            }

        }
        itemRV.adapter = adapter

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
