package com.easyhome.jrconsumer.mvp.ui.activity.user

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerRelatedPersonnelComponent
import com.easyhome.jrconsumer.di.module.RelatedPersonnelModule
import com.easyhome.jrconsumer.mvp.contract.user.RelatedPersonnelContract
import com.easyhome.jrconsumer.mvp.presenter.user.RelatedPersonnelPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.ui.adapter.PersonnelAdapter
import kotlinx.android.synthetic.main.activity_related_personnel.*
import kotlinx.android.synthetic.main.layout_title.*


/**
 * 服务人员信息
 */
class RelatedPersonnelActivity : JRBaseActivity<RelatedPersonnelPresenter>(), RelatedPersonnelContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerRelatedPersonnelComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .relatedPersonnelModule(RelatedPersonnelModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_related_personnel //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        tvPageTitle.text = "人员信息"
        ivPageBack.singleClick { killMyself() }
        personnelRV.adapter = PersonnelAdapter(arrayListOf(""))
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
