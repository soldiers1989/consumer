package com.easyhome.jrconsumer.mvp.ui.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.mvp.model.javabean.ProjectListData

class NewHomeAdapter(data: List<ProjectListData>) :
    BaseQuickAdapter<ProjectListData, BaseViewHolder>
        (R.layout.new_home_layout, data) {

    override fun convert(helper: BaseViewHolder, item: ProjectListData) {
        helper.setText(R.id.content,"${item.addressAll}\n${item.htName}\n${item.floorage}\n${item.psName}")
    }


}