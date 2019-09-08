package com.easyhome.jrconsumer.mvp.ui.activity.live

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerLiveDetailsComponent
import com.easyhome.jrconsumer.di.module.LiveDetailsModule
import com.easyhome.jrconsumer.mvp.contract.live.LiveDetailsContract
import com.easyhome.jrconsumer.mvp.presenter.live.LiveDetailsPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.ui.adapter.DynamicAdapter
import com.easyhome.jrconsumer.mvp.ui.adapter.Photo2Adapter
import com.easyhome.jrconsumer.mvp.ui.adapter.PhotoAdapter
import com.easyhome.jrconsumer.mvp.ui.adapter.ProjectProgressAdapter
import kotlinx.android.synthetic.main.activity_live_details.*
import kotlinx.android.synthetic.main.layout_title.*


/**
 * 直播详情
 */
class LiveDetailsActivity : JRBaseActivity<LiveDetailsPresenter>(), LiveDetailsContract.View {
    override fun getMyself(): BaseActivity<*> = this


    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerLiveDetailsComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .liveDetailsModule(LiveDetailsModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_live_details //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        tvPageTitle.text = "直播详情"
        ivPageBack.singleClick { killMyself() }
        progressRV.adapter = ProjectProgressAdapter(
            arrayListOf(
                Pair(R.mipmap.ks_1, "量房"),
                Pair(R.mipmap.ks_1, "预交底"),
                Pair(R.mipmap.ks_1, "待开工"),
                Pair(R.mipmap.ks_1, "施工中\n基础"),
                Pair(R.mipmap.ks_1, "结算")
            )
        )

        processRV1.adapter = Photo2Adapter(arrayListOf("", "", ""))
        processRV2.adapter = DynamicAdapter(arrayListOf("", "", ""))
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
