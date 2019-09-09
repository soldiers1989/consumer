package com.easyhome.jrconsumer.mvp.ui.activity.project

import android.content.Intent
import android.os.Bundle
import android.view.View

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerMaterialsListComponent
import com.easyhome.jrconsumer.di.module.MaterialsListModule
import com.easyhome.jrconsumer.mvp.contract.project.MaterialsListContract
import com.easyhome.jrconsumer.mvp.presenter.project.MaterialsListPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.ui.adapter.MaterialsList2Adapter
import com.easyhome.jrconsumer.mvp.ui.adapter.MaterialsListAdapter
import kotlinx.android.synthetic.main.activity_materials_list.*
import kotlinx.android.synthetic.main.layout_title.*
import org.jetbrains.anko.startActivity


/**
 * 材料订单列表
 */
class MaterialsListActivity : JRBaseActivity<MaterialsListPresenter>(), MaterialsListContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMaterialsListComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .materialsListModule(MaterialsListModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_materials_list //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        tvPageTitle.text = "材料订单列表"
        ivPageBack.singleClick { killMyself() }
        tabRB1.isChecked = true

        val adapter1 = MaterialsListAdapter(arrayListOf("", "", ""))
        tabRB1.singleClick {
            dataRV.adapter = adapter1
            add.visibility= View.VISIBLE
            totle.visibility= View.GONE

        }
        val adapter2 = MaterialsList2Adapter(arrayListOf("", "", ""))
        tabRB2.singleClick {
            dataRV.adapter = adapter2
            add.visibility= View.GONE
            totle.visibility= View.VISIBLE

        }
        dataRV.adapter = adapter1
        add.singleClick {
            startActivity<AddBuyCommodityActivity>()
        }
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
