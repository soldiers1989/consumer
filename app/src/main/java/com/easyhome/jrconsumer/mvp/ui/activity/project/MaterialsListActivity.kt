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
import com.easyhome.jrconsumer.mvp.model.entity.MPair
import com.easyhome.jrconsumer.mvp.ui.adapter.MaterialsList2Adapter
import com.easyhome.jrconsumer.mvp.ui.adapter.MaterialsListAdapter
import com.easyhome.jrconsumer.mvp.ui.adapter.MessageTabAdapter
import kotlinx.android.synthetic.main.activity_materials_list.*
import kotlinx.android.synthetic.main.layout_title.*
import org.jetbrains.anko.imageResource
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
        ivPageBack.singleClick { killMyself() }
        ivPageRight.setImageResource(R.mipmap.filtrate_title_icon)
        ivPageRight.visibility = View.VISIBLE
        ivPageRight.singleClick {
            if(filtrateCL.visibility== View.VISIBLE){
                filtrateCL.visibility= View.GONE
                ivPageRight.setImageResource(R.mipmap.filtrate_title_icon)
            }else{
                filtrateCL.visibility= View.VISIBLE
                ivPageRight.setImageResource(R.mipmap.filtrate_title_icon_2)
            }
        }
       /* tabRB1.isChecked = true

        tabRB1.singleClick {
            dataRV.adapter = adapter1
            add.visibility= View.VISIBLE
            totle.visibility= View.GONE

        }*/
        val adapter1 = MaterialsListAdapter(arrayListOf("", "", ""))
        val adapter2 = MaterialsList2Adapter(arrayListOf("", "", ""))
       /* tabRB2.singleClick {
            dataRV.adapter = adapter2
            add.visibility= View.GONE
            totle.visibility= View.VISIBLE

        }*/
        adapter2.setOnItemClickListener { adapter, view, position ->
            startActivity<MaterialsOrderActivity>()
        }
        dataRV.adapter = adapter2
        add.singleClick {
            startActivity<AddBuyCommodityActivity>()
        }

        val tab = arrayListOf(MPair(true, "内购"), MPair(false, "外购"))
        val adapter = MessageTabAdapter(tab)
        adapter.setOnItemClickListener { adapter, view, position ->
            tab.forEachIndexed { index, mPair ->
                mPair.first = index == position
            }
            adapter.notifyDataSetChanged()
            when (position) {
                0 -> {
                    dataRV.adapter = adapter2
                    add.visibility= View.GONE
                    totle.visibility= View.VISIBLE
                }
                1 -> {
                    dataRV.adapter = adapter1
                    add.visibility= View.VISIBLE
                    totle.visibility= View.GONE
                }

            }
        }
        tabRV.adapter = adapter
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
