package com.easyhome.jrconsumer.mvp.ui.activity

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerComplaintOrRepairsComponent
import com.easyhome.jrconsumer.di.module.ComplaintOrRepairsModule
import com.easyhome.jrconsumer.mvp.contract.ComplaintOrRepairsContract
import com.easyhome.jrconsumer.mvp.presenter.ComplaintOrRepairsPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.ui.adapter.Rule2Adapter
import com.easyhome.jrconsumer.mvp.ui.adapter.RuleAdapter
import kotlinx.android.synthetic.main.activity_complaint_or_repairs.*
import kotlinx.android.synthetic.main.layout_title.*
import org.jetbrains.anko.startActivity


/**
 * 投诉/报修
 */
class ComplaintOrRepairsActivity : JRBaseActivity<ComplaintOrRepairsPresenter>(), ComplaintOrRepairsContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerComplaintOrRepairsComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .complaintOrRepairsModule(ComplaintOrRepairsModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_complaint_or_repairs //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        tvPageTitle.text = "报修政策"
        ivPageBack.singleClick { killMyself() }
        val adapter = Rule2Adapter(arrayListOf("", "", ""))
        adapter.setOnItemClickListener { adapter, view, position ->
            startActivity<RepairDetailsActivity>()
        }
        ruleRV.adapter = adapter
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
