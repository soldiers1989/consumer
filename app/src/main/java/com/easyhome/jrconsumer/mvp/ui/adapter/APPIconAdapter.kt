package com.easyhome.jrconsumer.mvp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R

class APPIconAdapter(data: List<Int>) :
    BaseQuickAdapter<Int, BaseViewHolder>
        (R.layout.app_icon_layout, data) {

    override fun convert(helper: BaseViewHolder, item: Int) {
        helper.setImageResource(R.id.icon, item)

    }


}