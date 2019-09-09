package com.easyhome.jrconsumer.mvp.ui.activity

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerScoreComponent
import com.easyhome.jrconsumer.di.module.ScoreModule
import com.easyhome.jrconsumer.mvp.contract.ScoreContract
import com.easyhome.jrconsumer.mvp.presenter.ScorePresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.ui.adapter.ScoreListAdapter
import kotlinx.android.synthetic.main.activity_score.*
import kotlinx.android.synthetic.main.layout_title.*


/**
 * 评分
 */
class ScoreActivity : JRBaseActivity<ScorePresenter>(), ScoreContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerScoreComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .scoreModule(ScoreModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_score //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        tvPageTitle.text = "材料订单列表"
        ivPageBack.singleClick { killMyself() }
        scoreRV.adapter = ScoreListAdapter(arrayListOf("", "", ""))
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
