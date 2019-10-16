package com.easyhome.jrconsumer.mvp.ui.activity.project

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerMaterialsOrderComponent
import com.easyhome.jrconsumer.di.module.MaterialsOrderModule
import com.easyhome.jrconsumer.mvp.contract.project.MaterialsOrderContract
import com.easyhome.jrconsumer.mvp.presenter.project.MaterialsOrderPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.model.entity.MPair
import com.easyhome.jrconsumer.mvp.ui.activity.ScoreActivity
import com.easyhome.jrconsumer.mvp.ui.adapter.DataAdapter
import com.easyhome.jrconsumer.mvp.ui.adapter.GoodesAdapter
import com.easyhome.jrconsumer.mvp.ui.adapter.WorkingPlanItem1Adapter
import kotlinx.android.synthetic.main.activity_materials_order.*
import kotlinx.android.synthetic.main.layout_title.*
import org.jetbrains.anko.startActivity


/**
 * 材料订单详情
 */
class MaterialsOrderActivity : JRBaseActivity<MaterialsOrderPresenter>(), MaterialsOrderContract.View {
    override fun getMyself(): BaseActivity<*> = this
    override fun isUseParentLayout(): Boolean = false

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMaterialsOrderComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .materialsOrderModule(MaterialsOrderModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_materials_order //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        backIV.singleClick { killMyself() }
        goodesRV.adapter = GoodesAdapter(arrayListOf("", ""))

        dataRV.adapter = DataAdapter(
            arrayListOf(
                MPair("测量结果", ""),
                MPair("复尺结果", ""),
                MPair("收货信息", ""),
                MPair("合同信息", ""),
                MPair("设计方案", ""),
                MPair("安装信息", "")
            )
        )
        itemRV.adapter = WorkingPlanItem1Adapter(
            arrayListOf(
                "订单编号：S2019678678", "销售合同：H201922222", "品牌：九牧  ", "供应商：北京九牧居然丽泽MALL专营店  ",
                "交易时间：2019-03-1", "订单金额：99元", "订单类型：套餐",
                "测量日期：2019-03-9", "是否复尺：是", "复尺日期：2019-03-19", "送货日期：2019-03-10", "安装日期："
            )
        )
        score.singleClick { startActivity<ScoreActivity>() }
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
