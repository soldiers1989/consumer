package com.easyhome.jrconsumer.mvp.ui.adapter

import android.graphics.Color
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R

class ProjectProgress2Adapter(data: List<Pair<Int, String>>) :
    BaseQuickAdapter<Pair<Int, String>, BaseViewHolder>
        (R.layout.project_progress_layout_2, data) {

    override fun convert(helper: BaseViewHolder, item: Pair<Int, String>) {

        helper.setText(R.id.proTitle, item.second)
        helper.setBackgroundRes(R.id.proIcon, item.first)
        if (helper.layoutPosition == data.size - 1) {
            helper.setVisible(R.id.fg, false)
        }
        when (helper.layoutPosition) {
            0 -> {
                helper.setBackgroundColor(R.id.itemCL, Color.parseColor("#3669F8"))
                helper.setTextColor(R.id.proTitle, Color.parseColor("#FFFFFF"))
            }
            else-> {
                helper.setBackgroundColor(R.id.itemCL, Color.parseColor("#FFFFFF"))
                helper.setTextColor(R.id.proTitle, Color.parseColor("#555555"))
            }
        }

    }


}