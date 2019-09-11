package com.easyhome.jrconsumer.mvp.ui.activity.user

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerMakeComplaintComponent
import com.easyhome.jrconsumer.di.module.MakeComplaintModule
import com.easyhome.jrconsumer.mvp.contract.user.MakeComplaintContract
import com.easyhome.jrconsumer.mvp.presenter.user.MakeComplaintPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.ui.adapter.Photo4Adapter
import kotlinx.android.synthetic.main.activity_make_complaint.*
import kotlinx.android.synthetic.main.layout_title.*


/**
 * 发起投诉/报修
 */
class MakeComplaintActivity : JRBaseActivity<MakeComplaintPresenter>(), MakeComplaintContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMakeComplaintComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .makeComplaintModule(MakeComplaintModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_make_complaint //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        tvPageTitle.text = "发起投诉/报修"
        ivPageBack.singleClick { killMyself() }
        photoRV.adapter=Photo4Adapter(arrayListOf("",""))
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
