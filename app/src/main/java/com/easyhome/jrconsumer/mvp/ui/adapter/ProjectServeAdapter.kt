package com.easyhome.jrconsumer.mvp.ui.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.mvp.model.javabean.Server

class ProjectServeAdapter(data: List<Server>) :
    BaseQuickAdapter<Server, BaseViewHolder>
        (R.layout.project_serve_layout, data) {

    override fun convert(helper: BaseViewHolder, item: Server) {
        helper.setText(R.id.itemTitle, "${item.staRoleName}：")
        helper.setText(R.id.nameTV, item.staUserName)
    }


}