package com.easyhome.jrconsumer.mvp.ui.activity.user

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerShareComponent
import com.easyhome.jrconsumer.di.module.ShareModule
import com.easyhome.jrconsumer.mvp.contract.user.ShareContract
import com.easyhome.jrconsumer.mvp.presenter.user.SharePresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.ui.adapter.APPIconAdapter
import com.easyhome.jrconsumer.mvp.ui.adapter.FriendsAdapter
import kotlinx.android.synthetic.main.activity_share.*
import kotlinx.android.synthetic.main.layout_title.*


/**
 * 分享好友
 */
class ShareActivity : JRBaseActivity<SharePresenter>(), ShareContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerShareComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .shareModule(ShareModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_share //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        tvPageTitle.text = "分享好友"
        ivPageBack.singleClick { killMyself() }
        appRV.adapter = APPIconAdapter(
            arrayListOf(
                R.mipmap.jr_wx_icon,
                R.mipmap.wx_friends_icon,
                R.mipmap.jr_qq_icon,
                R.mipmap.qq_zone_icon
            )
        )
        friends.adapter = FriendsAdapter(arrayListOf("","",""))
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
