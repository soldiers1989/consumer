package com.easyhome.jrconsumer.mvp.ui.activity.message

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerMessageCenterComponent
import com.easyhome.jrconsumer.di.module.MessageCenterModule
import com.easyhome.jrconsumer.mvp.contract.message.MessageCenterContract
import com.easyhome.jrconsumer.mvp.presenter.message.MessageCenterPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.model.entity.MPair
import com.easyhome.jrconsumer.mvp.ui.activity.MessageInfoActivity
import com.easyhome.jrconsumer.mvp.ui.adapter.MessageCenterAdapter
import com.easyhome.jrconsumer.mvp.ui.adapter.MessageTabAdapter
import kotlinx.android.synthetic.main.activity_message_center.*
import kotlinx.android.synthetic.main.layout_title.*
import org.jetbrains.anko.startActivity


/**
 * 消息中心
 */
class MessageCenterActivity : JRBaseActivity<MessageCenterPresenter>(), MessageCenterContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMessageCenterComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .messageCenterModule(MessageCenterModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_message_center //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        tvPageTitle.text = "消息中心"
        ivPageBack.singleClick { killMyself() }
        val msgAdapter = MessageCenterAdapter(arrayListOf("", ""))
        msgAdapter.setOnItemClickListener { adapter, view, position ->
            startActivity<MessageInfoActivity>()
        }

        dataRV.adapter = msgAdapter

        val tab = arrayListOf(MPair(true, "全部"), MPair(false, "未读"), MPair(false, "已读"))
        val adapter = MessageTabAdapter(tab)
        adapter.setOnItemClickListener { adapter, view, position ->
            tab.forEachIndexed { index, mPair ->
                mPair.first = index == position
            }
            adapter.notifyDataSetChanged()
            when (position) {
                0 -> msgAdapter.setNewData(arrayListOf("", ""))
                1 -> msgAdapter.setNewData(arrayListOf(""))
                2 -> msgAdapter.setNewData(arrayListOf(""))
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
