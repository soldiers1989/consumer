package com.easyhome.jrconsumer.mvp.ui.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R

class DesignCaseAdapter(data: List<String>) :
    BaseQuickAdapter<String, BaseViewHolder>
        (R.layout.design_case_layout, data) {

    override fun convert(helper: BaseViewHolder, item: String) {
    }


}