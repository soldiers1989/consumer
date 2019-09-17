package com.easyhome.jrconsumer.mvp.ui.adapter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.mvp.model.entity.MPair

class PersonnelAdapter(data: List<String>) :
    BaseQuickAdapter<String, BaseViewHolder>
        (R.layout.personnel_layout, data) {

    override fun convert(helper: BaseViewHolder, item: String) {
        helper.getView<RecyclerView>(R.id.personnel).adapter = PersonnelItemAdapter(
            arrayListOf(
                "装修管家：赵哈哈",
                "材料员：张哈哈",
                "项目经理：赵哈哈",
                "设计师：张哈哈",
                "工长：赵哈哈"
            )
        )


    }


}