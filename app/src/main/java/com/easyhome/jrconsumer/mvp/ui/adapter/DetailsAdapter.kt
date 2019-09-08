package com.easyhome.jrconsumer.mvp.ui.adapter

import android.graphics.Color
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R

class DetailsAdapter(data: List<String>) :
    BaseQuickAdapter<String, BaseViewHolder>
        (R.layout.details_layout, data) {

    override fun convert(helper: BaseViewHolder, item: String) {
        helper.setGone(R.id.titleLL, helper.layoutPosition == 0)
        if (helper.layoutPosition % 2 != 0) {
            helper.setBackgroundColor(R.id.contentLL, Color.parseColor("#FFF8F8F8"))
        }
    }


}