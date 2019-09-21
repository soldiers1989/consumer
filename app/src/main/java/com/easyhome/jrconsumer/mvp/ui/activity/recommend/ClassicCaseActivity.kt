package com.easyhome.jrconsumer.mvp.ui.activity.recommend

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
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
import com.easyhome.jrconsumer.mvp.model.entity.MPair
import com.easyhome.jrconsumer.mvp.ui.adapter.*
import com.easyhome.jrconsumer.util.FiltrateUtil
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
        /* ivPageRight.setImageResource(R.mipmap.filtrate_title_icon)
         ivPageRight.visibility = View.VISIBLE
         ivPageRight.singleClick {
             if (filtrateCL.visibility == View.VISIBLE) {
                 filtrateCL.visibility = View.GONE
                 ivPageRight.setImageResource(R.mipmap.filtrate_title_icon)
             } else {
                 filtrateCL.visibility = View.VISIBLE
                 ivPageRight.setImageResource(R.mipmap.filtrate_title_icon_2)
             }
         }*/
        val tabAdapter = Tab2Adapter(
            arrayListOf(
                MPair("城市", true),
                MPair("户型", false),
                MPair("装修风格", false),
                MPair("面积", false)
            )
        )
        tabAdapter.setOnItemClickListener { adapter, view, position ->
            val data = adapter.data as List<MPair<String, Boolean>>
            if (data[position].second) {
                filtrate.visibility = View.GONE
                data[position].second=false
            } else {
                data[position].second=true
                filtrate.removeAllViews()
                filtrate.visibility = View.VISIBLE

                when(position){
                    0->{
                        filtrate.addView(FiltrateUtil.getFiltrateView(this@ClassicCaseActivity,FiltrateUtil.CITY, filtrate))
                    }
                    1->{
                        filtrate.addView(FiltrateUtil.getFiltrateView(this@ClassicCaseActivity,FiltrateUtil.HOUSE_TYPE, filtrate))
                    }
                    2->{
                        filtrate.addView(FiltrateUtil.getFiltrateView(this@ClassicCaseActivity,FiltrateUtil.STYLE, filtrate))
                    }
                    3->{
                        filtrate.addView(FiltrateUtil.getFiltrateView(this@ClassicCaseActivity,FiltrateUtil.AREA, filtrate))
                    }
                }


                // filtrate.addView(LayoutInflater.from(this).inflate(R.layout.select_city_layout, filtrate,false))
            }

        }
        tabRV.adapter = tabAdapter
        dataRV.adapter = DesignCaseAdapter(arrayListOf("", "", "", ""))

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
