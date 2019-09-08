package com.easyhome.jrconsumer.mvp.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R

class PInfoAdapter(data: List<String>) :
    BaseQuickAdapter<String, BaseViewHolder>
        (R.layout.p_info_layout, data) {

    override fun convert(helper: BaseViewHolder, item: String) {
        helper.setText(R.id.itemContent, if (!item.isNullOrEmpty()) item else "客户编号：111111")
    }


}