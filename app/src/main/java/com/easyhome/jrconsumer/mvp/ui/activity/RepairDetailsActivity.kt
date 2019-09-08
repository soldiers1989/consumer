package com.easyhome.jrconsumer.mvp.ui.activity

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerRepairDetailsComponent
import com.easyhome.jrconsumer.di.module.RepairDetailsModule
import com.easyhome.jrconsumer.mvp.contract.RepairDetailsContract
import com.easyhome.jrconsumer.mvp.presenter.RepairDetailsPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.ui.adapter.DetailsAdapter
import kotlinx.android.synthetic.main.activity_repair_details.*
import kotlinx.android.synthetic.main.layout_title.*


/**
 * 工程报修详情
 */
class RepairDetailsActivity : JRBaseActivity<RepairDetailsPresenter>(), RepairDetailsContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerRepairDetailsComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .repairDetailsModule(RepairDetailsModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_repair_details //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        tvPageTitle.text = "工程报修详情"
        ivPageBack.singleClick { killMyself() }
        itemRV.adapter = DetailsAdapter(arrayListOf("", "", "", ""))
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
