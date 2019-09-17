package com.easyhome.jrconsumer.mvp.ui.adapter

import android.support.v7.widget.CardView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R

class WaitThingAdapter(data: List<String>) :
    BaseQuickAdapter<String, BaseViewHolder>
        (R.layout.wait_thing_layout, data) {

    override fun convert(helper: BaseViewHolder, item: String) {

        helper.getView<ImageView>(R.id.dOrU).setOnClickListener {

            val vi = helper.getView<CardView>(R.id.detailCV)

            if (vi.visibility == View.VISIBLE) {
                vi.visibility = View.GONE
                helper.setImageResource(R.id.dOrU, R.mipmap.down_icon)
            } else {
                vi.visibility = View.VISIBLE
                helper.setImageResource(R.id.dOrU, R.mipmap.up_icon)
            }

        }

        helper.addOnClickListener(R.id.locationTV)

        when (helper.layoutPosition) {
            0 -> helper.setText(R.id.timeTV, "下午 8:00")
            5 -> helper.setText(R.id.timeTV, "下午 13:00")
            else -> helper.setText(R.id.timeTV, "")
        }

    }


}