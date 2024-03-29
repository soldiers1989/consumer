package com.easyhome.jrconsumer.mvp.ui.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.mvp.model.entity.MPair

class HomeServe2Adapter(data: List<MPair<Int, String>>) :
    BaseQuickAdapter<MPair<Int, String>, BaseViewHolder>
        (R.layout.home_serve_layout_2, data) {

    override fun convert(helper: BaseViewHolder, item: MPair<Int, String>) {

        helper.setImageResource(R.id.icon, item.first)
        helper.setText(R.id.content, item.second)
        helper.setGone(R.id.next, helper.layoutPosition != data.size - 1)
    }


}