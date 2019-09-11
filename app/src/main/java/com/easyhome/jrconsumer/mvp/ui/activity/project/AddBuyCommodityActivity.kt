package com.easyhome.jrconsumer.mvp.ui.activity.project

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerAddBuyCommodityComponent
import com.easyhome.jrconsumer.di.module.AddBuyCommodityModule
import com.easyhome.jrconsumer.mvp.contract.project.AddBuyCommodityContract
import com.easyhome.jrconsumer.mvp.presenter.project.AddBuyCommodityPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.ui.adapter.Photo4Adapter
import com.easyhome.jrconsumer.mvp.ui.adapter.PhotoAdapter
import kotlinx.android.synthetic.main.activity_add_buy_commodity.*
import kotlinx.android.synthetic.main.layout_title.*


/**
 * 添加外购商品
 */
class AddBuyCommodityActivity : JRBaseActivity<AddBuyCommodityPresenter>(), AddBuyCommodityContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerAddBuyCommodityComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .addBuyCommodityModule(AddBuyCommodityModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_add_buy_commodity //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        tvPageTitle.text = "添加外购商品"
        ivPageBack.singleClick { killMyself() }
        photoRV.adapter = Photo4Adapter(arrayListOf("", "", ""))
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
