package com.easyhome.jrconsumer.mvp.ui.activity

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerComplainComponent
import com.easyhome.jrconsumer.di.module.ComplainModule
import com.easyhome.jrconsumer.mvp.contract.ComplainContract
import com.easyhome.jrconsumer.mvp.presenter.ComplainPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.ui.adapter.Photo4Adapter
import kotlinx.android.synthetic.main.activity_complain.*
import kotlinx.android.synthetic.main.layout_title.*


/**
 * 投诉/报修
 */
class ComplainActivity : JRBaseActivity<ComplainPresenter>(), ComplainContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerComplainComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .complainModule(ComplainModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_complain //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        tvPageTitle.text = "投诉/报修"
        ivPageBack.singleClick { killMyself() }
        photoRV.adapter = Photo4Adapter(arrayListOf("","",""))
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
