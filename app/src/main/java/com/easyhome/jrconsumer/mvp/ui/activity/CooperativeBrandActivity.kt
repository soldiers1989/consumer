package com.easyhome.jrconsumer.mvp.ui.activity

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerCooperativeBrandComponent
import com.easyhome.jrconsumer.di.module.CooperativeBrandModule
import com.easyhome.jrconsumer.mvp.contract.CooperativeBrandContract
import com.easyhome.jrconsumer.mvp.presenter.CooperativeBrandPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.getRequestBody
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.model.entity.LoginArgumentsBean
import com.easyhome.jrconsumer.mvp.model.entity.MPair
import com.easyhome.jrconsumer.mvp.ui.adapter.BrandAdapter
import com.easyhome.jrconsumer.mvp.ui.adapter.TabAdapter
import kotlinx.android.synthetic.main.activity_cooperative_brand.*
import kotlinx.android.synthetic.main.layout_title.*


/**
 * 合作品牌
 */
class CooperativeBrandActivity : JRBaseActivity<CooperativeBrandPresenter>(), CooperativeBrandContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerCooperativeBrandComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .cooperativeBrandModule(CooperativeBrandModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_cooperative_brand //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {

        tvPageTitle.text = "合作品牌"
        ivPageBack.singleClick { killMyself() }
        tabRV.adapter =
                TabAdapter(
                    arrayListOf(
                        MPair("地板", false),
                        MPair("卫浴", true),
                        MPair("瓷砖", false),
                        MPair("沙发", false),
                        MPair("灯具", false),
                        MPair("家具", false)
                    )
                )
        brandRV.adapter = BrandAdapter(arrayListOf("", "", "", ""))



         //fieldName=id_5644  //分类
        //fieldName=categoryID_1501//分类列表数据
        val b2=BrandArguments.BeanII("categoryID_1501","1","1")
        val b1=BrandArguments.BeanI(arrayListOf(b2))
       // val arg=BrandArguments("S85237-I25933-C76982-B13730","1", arrayListOf(b1))   //分类
        val arg=BrandArguments("S85237-I25933-C42200-B43245","1", arrayListOf(b1))//分类列表数据
        mPresenter!!.brand(arg.getRequestBody() ){


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


    data class BrandArguments(val codes: String, val isVerify: String, val datas: List<BeanI>) {
        data class BeanI(val condition: List<BeanII>)
        data class BeanII(val fieldName: String, val values: String,val queryMode:String)
    }
}
