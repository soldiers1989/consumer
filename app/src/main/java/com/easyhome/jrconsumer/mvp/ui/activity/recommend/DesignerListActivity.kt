package com.easyhome.jrconsumer.mvp.ui.activity.recommend

import android.content.Intent
import android.os.Bundle
import android.view.View

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerDesignerListComponent
import com.easyhome.jrconsumer.di.module.DesignerListModule
import com.easyhome.jrconsumer.mvp.contract.recommend.DesignerListContract
import com.easyhome.jrconsumer.mvp.presenter.recommend.DesignerListPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.getRequestBody
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.model.entity.MPair
import com.easyhome.jrconsumer.mvp.ui.activity.H5Activity
import com.easyhome.jrconsumer.mvp.ui.activity.PredetermineActivity
import com.easyhome.jrconsumer.mvp.ui.adapter.*
import com.easyhome.jrconsumer.util.FiltrateUtil
import kotlinx.android.synthetic.main.activity_classic_case.*
import kotlinx.android.synthetic.main.layout_title.*
import org.jetbrains.anko.startActivity


/**
 * 设计师
 */
class DesignerListActivity : JRBaseActivity<DesignerListPresenter>(), DesignerListContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerDesignerListComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .designerListModule(DesignerListModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_classic_case //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        tvPageTitle.text = "设计师"
        ivPageBack.singleClick { killMyself() }

        /*ivPageRight.setImageResource(R.mipmap.filtrate_title_icon)
        ivPageRight.visibility = View.VISIBLE
        ivPageRight.singleClick {
            if(filtrateCL.visibility== View.VISIBLE){
                filtrateCL.visibility= View.GONE
                ivPageRight.setImageResource(R.mipmap.filtrate_title_icon)
            }else{
                filtrateCL.visibility= View.VISIBLE
                ivPageRight.setImageResource(R.mipmap.filtrate_title_icon_2)
            }
        }*/
        val adapter = DesignerListAdapter(arrayListOf("", "", "", ""))

        adapter.setOnItemClickListener { adapter, view, position ->

            startActivity<H5Activity>(
                "pageUrl" to " http://111.231.114.131/guochongyang/%E6%B6%88%E8%B4%B9%E8%80%85-moblie/m_%20designer.html",
                "title" to "设计师"
            )
        }

        adapter.setOnItemChildClickListener { adapter, view, position ->

            when (view.id) {
                R.id.cancel -> startActivity<PredetermineActivity>()
            }
        }
        dataRV.adapter = adapter
        val tabAdapter = Tab2Adapter(
            arrayListOf(
                MPair("城市", true),
                MPair("装修风格", false),
                MPair("价格区间", false)
            )
        )
        tabAdapter.setOnItemClickListener { adapter, view, position ->
            val data = adapter.data as List<MPair<String, Boolean>>
            if (data[position].second) {
                filtrate.visibility = View.GONE
                data[position].second = false
            } else {
                data[position].second = true
                filtrate.removeAllViews()
                filtrate.visibility = View.VISIBLE
                //   filtrate.addView(FiltrateUtil.getFiltrateView(this@DesignerListActivity, position, filtrate))
                // filtrate.addView(LayoutInflater.from(this).inflate(R.layout.select_city_layout, filtrate,false))
                when (position) {
                    0 -> {
                        filtrate.addView(
                            FiltrateUtil.getFiltrateView(
                                this@DesignerListActivity,
                                FiltrateUtil.CITY,
                                filtrate
                            )
                        )
                    }
                    1 -> {
                        filtrate.addView(
                            FiltrateUtil.getFiltrateView(
                                this@DesignerListActivity,
                                FiltrateUtil.STYLE,
                                filtrate
                            )
                        )
                    }
                    2 -> {
                        filtrate.addView(
                            FiltrateUtil.getFiltrateView(
                                this@DesignerListActivity,
                                FiltrateUtil.PRICE,
                                filtrate
                            )
                        )
                    }
                }
            }

        }
        tabRV.adapter = tabAdapter


        val b2 = BrandArguments.BeanII("city_8235", "138", "1")
        val b1 = BrandArguments.BeanI(arrayListOf(b2))
        val arg = BrandArguments("S85237-I15976-C58924-B65847", "1")

        mPresenter!!.classicCase(arg.getRequestBody()) {

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

    private data class BrandArguments(val codes: String, val isVerify: String) {
        //, val datas: List<BeanI>
        data class BeanI(val condition: List<BeanII>)

        data class BeanII(val fieldName: String, val values: String, val queryMode: String)
    }
}
