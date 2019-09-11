package com.easyhome.jrconsumer.mvp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.text.Html
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R

class WorkingPlanItem1Adapter(data: List<String>) :
    BaseQuickAdapter<String, BaseViewHolder>
        (R.layout.working_plan_item_layout_1, data) {

    override fun convert(helper: BaseViewHolder, item: String) {
        val ls = item.split("：")
        if (ls.size>1){
            val str1 = "${ls[0]}：<font color='#777777'>${ls[1]}</font>";
            helper.setText(R.id.content, Html.fromHtml(str1))
        }else {
            val str1 = "${item}<font color='#777777'>2019年8月20日 - 2019年8月20日</font>";
            helper.setText(R.id.content, Html.fromHtml(str1))
        }
    }


}