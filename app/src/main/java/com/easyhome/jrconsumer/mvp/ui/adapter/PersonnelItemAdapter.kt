package com.easyhome.jrconsumer.mvp.ui.adapter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.mvp.model.entity.MPair

class PersonnelItemAdapter(data: List<String>) :
    BaseQuickAdapter<String, BaseViewHolder>
        (R.layout.personnel_item_layout, data) {

    override fun convert(helper: BaseViewHolder, item: String) {
        helper.setText(R.id.content, item)
    }


}