package com.easyhome.jrconsumer.mvp.ui.adapter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.mvp.model.entity.MPair

class TabAdapter(data: List<MPair<String, Boolean>>) :
    BaseQuickAdapter<MPair<String, Boolean>, BaseViewHolder>
        (R.layout.tab_layout, data) {

    override fun convert(helper: BaseViewHolder, item: MPair<String, Boolean>) {
        helper.setText(R.id.tab, item.first)
        if (item.second) {
            helper.setBackgroundColor(R.id.tab, Color.parseColor("#EBEBEB"))
            helper.setTextColor(R.id.tab, Color.parseColor("#3669F8"))
        } else {
            helper.setBackgroundColor(R.id.tab, Color.parseColor("#FFFFFF"))
            helper.setTextColor(R.id.tab, Color.parseColor("#000000"))
        }
        if (helper.layoutPosition == data.size - 1) {
            helper.setVisible(R.id.vLine, false)
        }
    }


}