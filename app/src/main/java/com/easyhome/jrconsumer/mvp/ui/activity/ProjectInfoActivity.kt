package com.easyhome.jrconsumer.mvp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.text.Html

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerProjectInfoComponent
import com.easyhome.jrconsumer.di.module.ProjectInfoModule
import com.easyhome.jrconsumer.mvp.contract.ProjectInfoContract
import com.easyhome.jrconsumer.mvp.presenter.ProjectInfoPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.getRequestBody
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.model.entity.MPair
import com.easyhome.jrconsumer.mvp.ui.activity.project.MaterialsListActivity
import com.easyhome.jrconsumer.mvp.ui.activity.project.ProjectDynamicActivity
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
    lateinit var wData: MutableList<String>
    lateinit var wAdapter: WorkingPlanItem1Adapter
    lateinit var sAdapter: ProjectServeAdapter
    lateinit var workerAdapter: WorkerAdapter
    lateinit var dataAdapter: DataAdapter


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
                    startActivity<ProjectDynamicActivity>()
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
        sAdapter = ProjectServeAdapter(arrayListOf())
        serveRV.adapter = sAdapter
        workerAdapter = WorkerAdapter(arrayListOf())
        workerRV.adapter = workerAdapter

        dataAdapter = DataAdapter(arrayListOf())
        dataRV.adapter = dataAdapter

        wData = arrayListOf(
            "项目编号：", "创建时间：", "量房时间：", "预交底时间：",
            "设计合同签约日期：", "设计合同金额：", "施工签约日期：",
            "施工合同金额：", "合同开工日期：", "合同竣工日期：", "结算日期："
        )
        wAdapter = WorkingPlanItem1Adapter(wData)
        itemRV.adapter = wAdapter
        score.singleClick { startActivity<ScoreActivity>() }

        dynamicTV.text = Html.fromHtml("施工状态：<font color='#FF0000'>已延期</font>")

        getData()

    }


    fun getData() {

          mPresenter!!.projectDetail(
              mapOf(
                  "deviceType" to "1",
                  "token" to "saasasasasfd",
                  "staffID" to "1",
                  "proID" to "123456789"
              ).getRequestBody()
          ) {
              title2.text = it.proID
              title3.text = it.addressAll
              info1.text = "户型：${it.htName}"
              info10.text = "套内面积：${it.floorage}m²"
              info2.text = "装修风格：${it.styleName}"
              info5.text = "装修类型：${it.dtName}"
              info3.text = "建筑面积：${it.floorSpace}m²"
              info6.text = "房屋类型：${it.sname}"
              val pDatas = arrayListOf(
                  MPair(0, "开工交底"),
                  MPair(0, "隐蔽验收"),
                  MPair(1, "中期验收"),
                  MPair(2, "基础验收"),
                  MPair(2, "竣工验收"),
                  MPair(2, "结算")
              )
              var pin = 0
              when (it.planName) {

                  "开工交底" -> {
                      pin = 0
                  }
                  "隐蔽验收" -> {
                      pin = 1
                  }
                  "中期验收" -> {
                      pin = 2
                  }
                  "基础验收" -> {
                      pin = 3
                  }
                  "竣工验收" -> {
                      pin = 4
                  }
                  "结算" -> {
                      pin = 5
                  }
              }

              pDatas.forEachIndexed { index, mPair ->
                  if (index < pin) {
                      mPair.first = 0
                  } else if (index == pin) {
                      mPair.first = 1
                  } else {
                      mPair.first = 2
                  }
              }
              progressRV.adapter = ProjectProgressAdapter(pDatas)
              dynamicTV.text=Html.fromHtml("施工状态：<font color='#FF0000'>${it.psName}</font>")
              contract2.text=Html.fromHtml("今日进度：${it.nowPlan}")

          }
        mPresenter!!.projectDetailContract(
            mapOf(
                "deviceType" to "1",
                "token" to "saasasasasfd",
                "staffID" to "1",
                "proID" to "123456789"
            ).getRequestBody()
        ) {
            contract4.text = "${it.contractSTime}~${it.contractETime}"
            contract5.text = "${it.trueSTime}~${it.trueETime}"
            /*wData[9] = "结算日期：${it.settleTime}"
            wData[1] = "创建时间：${it.logTime}"
            wData[2] = "量房时间：${it.measureTime}"
            wData[3] = "预交底时间：${it.prepaidTime}"*/

            wData[1]=("创建时间：${it.logTime}")
            wData[2]=("量房时间：${it.measureTime}")
            wData[3]=("预交底时间：${it.prepaidTime}")
            wData[4]=("设计合同签约日期：${it.signingTime}")
            wData[5]=("设计合同金额：${it.contractMoney}")
            wData[6]=("施工签约日期：${it.proSigningTime}")
            wData[7]=("施工合同金额：${it.proSigningMoney}")
            wData[8]=("合同开工日期：${it.contractSTime}")
            wData[9]=("合同竣工日期：${it.contractETime}")
            wData[10]=("结算日期：${it.settleTime}")
            wAdapter.setNewData(wData)
            wAdapter.notifyDataSetChanged()

            dataAdapter.setNewData(arrayListOf(
                MPair("设计合同",it.designURL),
                MPair("施工合同",it.executionURL),
                MPair("图纸",it.drawingURL),
                MPair("报价单",it.priceListURL),
                MPair("变更单",it.changeOrderURL),
                MPair("效果图",it.renderingURL),
                MPair("报价单",it.priceListURL)
            ))

           /* "designURL": "",  --设计合同地址
            "executionURL": "", --施工合同地址
            "drawingURL": "",  --图纸地址
            "priceListURL": "", --报价单地址
            "changeOrderURL": "", --变更单地址
            "renderingURL": "",  --效果图地址*/

        }
         mPresenter!!.projectDetailStatus(
             mapOf(
                 "deviceType" to "1",
                 "token" to "saasasasasfd",
                 "staffID" to "1",
                 "proID" to "123456789"
             ).getRequestBody()
         ) {

         }
         mPresenter!!.projectDetailUser(
             mapOf(
                 "deviceType" to "1",
                 "token" to "saasasasasfd",
                 "staffID" to "1",
                 "proID" to "123456789"
             ).getRequestBody()
         ) {

             sAdapter.setNewData(it)
             val datas= mutableListOf<MPair<String,String>>()
             datas.add(MPair("${it[0].workName.w1.split(":")[0]}：",it[0].workName.w1.split(":")[1] ))
             datas.add(MPair("${it[0].workName.w2.split(":")[0]}：",it[0].workName.w2.split(":")[1] ))
             datas.add(MPair("${it[0].workName.w3.split(":")[0]}：",it[0].workName.w3.split(":")[1] ))
             datas.add(MPair("${it[0].workName.w4.split(":")[0]}：",it[0].workName.w4.split(":")[1] ))
             datas.add(MPair("${it[0].workName.w5.split(":")[0]}：",it[0].workName.w5.split(":")[1] ))
             workerAdapter.setNewData(datas)
         }

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
