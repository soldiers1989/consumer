package com.easyhome.jrconsumer.mvp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R

class SchedulingPlanAdapter(data: List<String>) :
    BaseQuickAdapter<String, BaseViewHolder>
        (R.layout.scheduling_plan_layout, data) {

    override fun convert(helper: BaseViewHolder, item: String) {


        helper.getView<RecyclerView>(R.id.planTextRV).adapter = PlanTextAdapter(arrayListOf("", ""))

    }


}