package com.easyhome.jrconsumer.mvp.ui.adapter

import android.graphics.Color
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R

class ProjectProgressAdapter(data: List<Pair<Int, String>>) :
    BaseQuickAdapter<Pair<Int, String>, BaseViewHolder>
        (R.layout.project_progress_layout, data) {

    override fun convert(helper: BaseViewHolder, item: Pair<Int, String>) {

        helper.setText(R.id.proTitle, item.second)
        //helper.setBackgroundRes(R.id.proIcon, item.first)
        /* if (helper.layoutPosition == data.size-1) {
             helper.setVisible(R.id.fg, false)
         }*/

        when (item.first) {

            0 -> {
                helper.setBackgroundRes(R.id.proIcon, R.mipmap.prs_icon_1)
                helper.setBackgroundRes(R.id.icon, R.mipmap.prs_icon_4)
            }
            1 -> {
                helper.setBackgroundRes(R.id.proIcon, R.mipmap.prs_icon_2)
                helper.setBackgroundRes(R.id.icon, R.mipmap.prs_icon_5)
                helper.setBackgroundColor(R.id.fg, Color.parseColor("#3669F8"))
            }
            2 -> {
                helper.setBackgroundRes(R.id.proIcon, R.mipmap.prs_icon_3)
                helper.setBackgroundRes(R.id.icon, R.mipmap.prs_icon_6)
                helper.setBackgroundColor(R.id.leftLine, Color.parseColor("#4D3669F8"))
                helper.setBackgroundColor(R.id.fg, Color.parseColor("#4D3669F8"))
            }

        }
    }


}