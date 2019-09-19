package com.easyhome.jrconsumer.mvp.ui.activity.recommend

import android.content.Intent
import android.os.Bundle
import android.view.View

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerConstructionTeamComponent
import com.easyhome.jrconsumer.di.module.ConstructionTeamModule
import com.easyhome.jrconsumer.mvp.contract.recommend.ConstructionTeamContract
import com.easyhome.jrconsumer.mvp.presenter.recommend.ConstructionTeamPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.ui.activity.H5Activity
import com.easyhome.jrconsumer.mvp.ui.adapter.ConstructionTeamAdapter
import com.easyhome.jrconsumer.mvp.ui.adapter.DesignerListAdapter
import com.easyhome.jrconsumer.mvp.ui.adapter.OptionAdapter
import kotlinx.android.synthetic.main.activity_construction_team.*
import kotlinx.android.synthetic.main.layout_title.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.startActivity


/**
 * 施工队列表
 */
class ConstructionTeamActivity : JRBaseActivity<ConstructionTeamPresenter>(), ConstructionTeamContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerConstructionTeamComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .constructionTeamModule(ConstructionTeamModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_construction_team //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        tvPageTitle.text = "施工队列表"
        ivPageBack.singleClick { killMyself() }
        val  adapter=ConstructionTeamAdapter(arrayListOf("", "", "", ""))
        adapter.setOnItemClickListener { adapter, view, position ->

            startActivity<H5Activity>(
                "pageUrl" to "http://111.231.114.131/guochongyang/%E6%B6%88%E8%B4%B9%E8%80%85-moblie/m_%20construction_team.html",
                "title" to "精品案例"
            )
        }
        dataRV.adapter = adapter



        cityRV.adapter = OptionAdapter(arrayListOf("北京", "上海", "天津", "重庆", "保定", "象牙山"))
        levelRV.adapter = OptionAdapter(arrayListOf("资深", "高级", "中级", "初级"))

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
