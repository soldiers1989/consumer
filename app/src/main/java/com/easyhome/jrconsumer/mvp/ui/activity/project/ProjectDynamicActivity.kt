package com.easyhome.jrconsumer.mvp.ui.activity.project

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerProjectDynamicComponent
import com.easyhome.jrconsumer.di.module.ProjectDynamicModule
import com.easyhome.jrconsumer.mvp.contract.project.ProjectDynamicContract
import com.easyhome.jrconsumer.mvp.presenter.project.ProjectDynamicPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.ui.adapter.DynamicAdapter
import kotlinx.android.synthetic.main.activity_project_dynamic.*
import kotlinx.android.synthetic.main.layout_title.*


/**
 * 施工动态
 */
class ProjectDynamicActivity : JRBaseActivity<ProjectDynamicPresenter>(), ProjectDynamicContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerProjectDynamicComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .projectDynamicModule(ProjectDynamicModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_project_dynamic //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {

        tvPageTitle.text = "施工动态"
        ivPageBack.singleClick { killMyself() }
        processRV2.adapter = DynamicAdapter(arrayListOf(""))
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
