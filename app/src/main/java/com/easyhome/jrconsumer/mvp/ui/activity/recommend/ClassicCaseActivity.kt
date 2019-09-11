package com.easyhome.jrconsumer.mvp.ui.activity.recommend

import android.content.Intent
import android.os.Bundle
import android.view.View

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerClassicCaseComponent
import com.easyhome.jrconsumer.di.module.ClassicCaseModule
import com.easyhome.jrconsumer.mvp.contract.recommend.ClassicCaseContract
import com.easyhome.jrconsumer.mvp.presenter.recommend.ClassicCasePresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.ui.adapter.DesignCaseAdapter
import com.easyhome.jrconsumer.mvp.ui.adapter.Option2Adapter
import com.easyhome.jrconsumer.mvp.ui.adapter.Option3Adapter
import com.easyhome.jrconsumer.mvp.ui.adapter.OptionAdapter
import kotlinx.android.synthetic.main.activity_classic_case.*
import kotlinx.android.synthetic.main.layout_title.*


/**
 * 精品案例
 */
class ClassicCaseActivity : JRBaseActivity<ClassicCasePresenter>(), ClassicCaseContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerClassicCaseComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .classicCaseModule(ClassicCaseModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_classic_case //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        tvPageTitle.text = "精品案例"
        ivPageBack.singleClick { killMyself() }
        ivPageRight.setImageResource(R.mipmap.filtrate_title_icon)
        ivPageRight.visibility = View.VISIBLE
        ivPageRight.singleClick {
            if(filtrateCL.visibility==View.VISIBLE){
                filtrateCL.visibility=View.GONE
                ivPageRight.setImageResource(R.mipmap.filtrate_title_icon)
            }else{
                filtrateCL.visibility=View.VISIBLE
                ivPageRight.setImageResource(R.mipmap.filtrate_title_icon_2)
            }
        }
        dataRV.adapter = DesignCaseAdapter(arrayListOf("", "", "", ""))
        cityRV.adapter = OptionAdapter(arrayListOf("北京", "北京", "北京", "北京", "北京", "北京"))
        houseTypeRV.adapter = Option2Adapter(arrayListOf("一室一厅", "一室一厅", "一室一厅", "一室一厅", "一室一厅", "一室一厅"))
        areaRV.adapter = Option3Adapter(arrayListOf("小于60m²", "60~80m²", "80~100m²", "100~120m²", "120以上"))
        styleRV.adapter = Option2Adapter(arrayListOf("中式", "美式", "地中海", "阿拉伯", "北美", "混合"))
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
