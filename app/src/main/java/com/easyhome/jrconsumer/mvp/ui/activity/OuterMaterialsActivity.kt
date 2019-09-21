package com.easyhome.jrconsumer.mvp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerOuterMaterialsComponent
import com.easyhome.jrconsumer.di.module.OuterMaterialsModule
import com.easyhome.jrconsumer.mvp.contract.OuterMaterialsContract
import com.easyhome.jrconsumer.mvp.presenter.OuterMaterialsPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.contract.search.CityPicker1Contract
import com.easyhome.jrconsumer.mvp.ui.adapter.Photo4Adapter
import com.easyhome.jrconsumer.mvp.ui.adapter.PhotoAdapter
import kotlinx.android.synthetic.main.activity_outer_materials.*
import kotlinx.android.synthetic.main.layout_title.*


/**
 * 外购材料
 */
class OuterMaterialsActivity : JRBaseActivity<OuterMaterialsPresenter>(), OuterMaterialsContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerOuterMaterialsComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .outerMaterialsModule(OuterMaterialsModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_outer_materials //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {

        tvPageTitle.text = "外购材料"
        ivPageBack.singleClick { killMyself() }
        ivPageRight.setImageResource(R.mipmap.edit_title_icon)
        ivPageRight.singleClick { }
        ivPageRight.visibility = View.VISIBLE
        phoneRV.adapter = Photo4Adapter(arrayListOf("", "", "", "", "", ""))
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
