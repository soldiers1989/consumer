package com.easyhome.jrconsumer.mvp.ui.activity.recommend

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerDesignerListComponent
import com.easyhome.jrconsumer.di.module.DesignerListModule
import com.easyhome.jrconsumer.mvp.contract.recommend.DesignerListContract
import com.easyhome.jrconsumer.mvp.presenter.recommend.DesignerListPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.ui.adapter.DesignCaseAdapter
import com.easyhome.jrconsumer.mvp.ui.adapter.DesignerListAdapter
import com.easyhome.jrconsumer.mvp.ui.adapter.OptionAdapter
import kotlinx.android.synthetic.main.activity_designer_list.*
import kotlinx.android.synthetic.main.layout_title.*


/**
 * 设计师
 */
class DesignerListActivity : JRBaseActivity<DesignerListPresenter>(), DesignerListContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerDesignerListComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .designerListModule(DesignerListModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_designer_list //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        tvPageTitle.text = "设计师"
        ivPageBack.singleClick { killMyself() }
        dataRV.adapter = DesignerListAdapter(arrayListOf("", "", "", ""))
        cityRV.adapter = OptionAdapter(arrayListOf("北京", "北京", "北京", "北京", "北京", "北京"))
        houseTypeRV.adapter = OptionAdapter(arrayListOf("一室一厅", "一室一厅", "一室一厅", "一室一厅", "一室一厅", "一室一厅"))
        areaRV.adapter = OptionAdapter(arrayListOf("小于60m2", "60-80m2", "0-80m2", "0-80m2", "0-80m2", "0-80m2"))
        styleRV.adapter = OptionAdapter(arrayListOf("中式", "美式", "地中海", "阿拉伯", "北美", "混合"))
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
