package com.easyhome.jrconsumer.mvp.ui.activity.user

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerGradeListComponent
import com.easyhome.jrconsumer.di.module.GradeListModule
import com.easyhome.jrconsumer.mvp.contract.user.GradeListContract
import com.easyhome.jrconsumer.mvp.presenter.user.GradeListPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.model.entity.MPair
import com.easyhome.jrconsumer.mvp.ui.adapter.GradeAdapter
import com.easyhome.jrconsumer.mvp.ui.adapter.InfoAdapter
import kotlinx.android.synthetic.main.activity_grade_list.*
import kotlinx.android.synthetic.main.layout_title.*


/**
 * 评分记录
 */
class GradeListActivity : JRBaseActivity<GradeListPresenter>(), GradeListContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerGradeListComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .gradeListModule(GradeListModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_grade_list //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        tvPageTitle.text = "评分记录"
        ivPageBack.singleClick { killMyself() }
        homeInfoRV.adapter = InfoAdapter(arrayListOf(
            MPair("户型：","三室两厅两卫"),
            MPair("房屋类型：","新房"),
            MPair("装修风格：","欧式"),
            MPair("房屋类型：","三室两厅两卫"),
            MPair("建筑面积：","100.98m²"),
            MPair("房屋类型：","三室两厅两卫")
        ))
        gradeRV.adapter = GradeAdapter(arrayListOf("", ""))
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
