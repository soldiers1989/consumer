package com.easyhome.jrconsumer.mvp.ui.activity.live

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerLiveComponent
import com.easyhome.jrconsumer.di.module.LiveModule
import com.easyhome.jrconsumer.mvp.contract.live.LiveContract
import com.easyhome.jrconsumer.mvp.presenter.live.LivePresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.ui.adapter.LiveAdapter
import kotlinx.android.synthetic.main.activity_live.*
import kotlinx.android.synthetic.main.layout_title.*
import org.jetbrains.anko.startActivity


/**
 * 直播间
 */
class LiveActivity : JRBaseActivity<LivePresenter>(), LiveContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerLiveComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .liveModule(LiveModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_live //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {

        tvPageTitle.text = "直播间"
        ivPageBack.singleClick { killMyself() }
        val adapter = LiveAdapter(arrayListOf("", "", "", ""))
        adapter.setOnItemClickListener { adapter, view, position ->
            startActivity<LiveDetailsActivity>()
        }
        dataRV.adapter = adapter


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
