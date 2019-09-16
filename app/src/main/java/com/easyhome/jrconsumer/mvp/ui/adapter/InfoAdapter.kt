package com.easyhome.jrconsumer.mvp.ui.adapter

import android.graphics.Color
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.mvp.model.entity.MPair

class InfoAdapter(data: List<MPair<String, String>>) :
    BaseQuickAdapter<MPair<String,String>, BaseViewHolder>
        (R.layout.info_layout, data) {

    override fun convert(helper: BaseViewHolder, item: MPair<String,String>) {

        helper.setText(R.id.title,item.first)
        helper.setText(R.id.content,item.second)

    }


}