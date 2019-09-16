package com.easyhome.jrconsumer.mvp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.mvp.model.entity.MPair

class GradeAdapter(data: List<String>) :
    BaseQuickAdapter<String, BaseViewHolder>
        (R.layout.grade_layout, data) {

    override fun convert(helper: BaseViewHolder, item: String) {

        helper.getView<RecyclerView>(R.id.grade).adapter =ScoreListAdapter(
            arrayListOf(
                MPair("客户顾问：刘芸", 50F),
                MPair("设计师：张硕", 50F),
                MPair("装修管家：刘芸", 70F),
                MPair("项目经理：刘芸", 50F),
                MPair("工长：刘芸", 60F)
            )
        )
    }


}