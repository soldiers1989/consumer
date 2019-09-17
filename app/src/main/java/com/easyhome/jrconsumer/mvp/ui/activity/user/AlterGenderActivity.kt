package com.easyhome.jrconsumer.mvp.ui.activity.user

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerAlterGenderComponent
import com.easyhome.jrconsumer.di.module.AlterGenderModule
import com.easyhome.jrconsumer.mvp.contract.user.AlterGenderContract
import com.easyhome.jrconsumer.mvp.presenter.user.AlterGenderPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import kotlinx.android.synthetic.main.activity_alter_gender.*
import kotlinx.android.synthetic.main.layout_title.*
import org.jetbrains.anko.imageResource


/**
 * 编辑姓别
 */
class AlterGenderActivity : JRBaseActivity<AlterGenderPresenter>(), AlterGenderContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerAlterGenderComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .alterGenderModule(AlterGenderModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_alter_gender //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        tvPageTitle.text = "编辑姓别"
        ivPageBack.singleClick { killMyself() }
        womanSelect.singleClick { }
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
