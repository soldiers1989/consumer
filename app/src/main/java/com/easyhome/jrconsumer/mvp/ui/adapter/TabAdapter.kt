package com.easyhome.jrconsumer.mvp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R

class TabAdapter(data: List<String>) :
    BaseQuickAdapter<String, BaseViewHolder>
        (R.layout.tab_layout, data) {

    override fun convert(helper: BaseViewHolder, item: String) {
        helper.setText(R.id.tab, item)
        if (helper.layoutPosition == data.size - 1) {
            helper.setVisible(R.id.vLine, false)
        }
    }


}