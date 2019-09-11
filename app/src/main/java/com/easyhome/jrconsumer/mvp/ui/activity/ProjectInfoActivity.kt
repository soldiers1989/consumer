package com.easyhome.jrconsumer.mvp.ui.activity

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerProjectInfoComponent
import com.easyhome.jrconsumer.di.module.ProjectInfoModule
import com.easyhome.jrconsumer.mvp.contract.ProjectInfoContract
import com.easyhome.jrconsumer.mvp.presenter.ProjectInfoPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.model.entity.MPair
import com.easyhome.jrconsumer.mvp.ui.activity.project.MaterialsListActivity
import com.easyhome.jrconsumer.mvp.ui.activity.project.SchedulingPlanActivity
import com.easyhome.jrconsumer.mvp.ui.adapter.*
import kotlinx.android.synthetic.main.activity_project_info.*
import kotlinx.android.synthetic.main.layout_title.*
import org.jetbrains.anko.startActivity


/**
 * 项目详情
 */
class ProjectInfoActivity : JRBaseActivity<ProjectInfoPresenter>(), ProjectInfoContract.View {
    override fun getMyself(): BaseActivity<*> = this
    override fun isUseParentLayout(): Boolean = false

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerProjectInfoComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .projectInfoModule(ProjectInfoModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_project_info //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {

        backIV.singleClick { killMyself() }
        progressRV.adapter = ProjectProgressAdapter(
            arrayListOf(
                Pair(0, "开工交底"),
                Pair(0, "隐蔽验收"),
                Pair(1, "中期验收"),
                Pair(2, "基础验收"),
                Pair(2, "竣工验收"),
                Pair(2, "竣工验收"),
                Pair(2, "结算")
            )
        )

        val pAdapter = ProjectProgress2Adapter(
            arrayListOf(
                Pair(R.mipmap.p_icon_1, "施工动态"),
                Pair(R.mipmap.p_icon_2, "施工进度"),
                Pair(R.mipmap.p_icon_3, "主材信息"),
                Pair(R.mipmap.p_icon_4, "投诉报修")
            )
        )
        pAdapter.setOnItemClickListener { adapter, view, position ->

            when (position) {
                0 -> {
                }
                1 -> {
                    startActivity<SchedulingPlanActivity>()
                }
                2 -> {
                    startActivity<MaterialsListActivity>()
                }
                3 -> {
                    startActivity<ComplaintOrRepairsActivity>()
                }
            }
        }
        prsRV.adapter = pAdapter

        serveRV.adapter = ProjectServeAdapter(arrayListOf("客户顾问：", "装修管家：", "材料员：", "项目经理：", "设计师：", "工长："))
        workerRV.adapter =
                WorkerAdapter(arrayListOf(MPair("水电工：", "张三、李四、王五"), MPair("木工：", "小张"), MPair("油漆工：", "张思")))
        dataRV.adapter = DataAdapter(arrayListOf("设计合同", "施工合同", "图纸", "报价单"))

        itemRV.adapter = WorkingPlanItem1Adapter(
            arrayListOf(
                "项目编号：", "创建时间：", "量房时间：", "预交底时间：",
                "实际合同签约日期：", "设计合同金额：", "施工签约日期：",
                "施工合同金额：", "合同开工日期：", "合同竣工日期：", "结算日期："
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
