package com.easyhome.jrconsumer.mvp.ui.adapter

import android.graphics.Color
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.mvp.model.entity.MPair

class Tab2Adapter(data: List<MPair<String, Boolean>>) :
    BaseQuickAdapter<MPair<String, Boolean>, BaseViewHolder>
        (R.layout.tab_layout_2, data) {

    override fun convert(helper: BaseViewHolder, item: MPair<String, Boolean>) {
        helper.setText(R.id.tabTV, item.first)
        if (item.second) {
            helper.setTextColor(R.id.tabTV, Color.parseColor("#000000"))
        } else {
            helper.setTextColor(R.id.tabTV, Color.parseColor("#7C7C7C"))
        }

    }


}