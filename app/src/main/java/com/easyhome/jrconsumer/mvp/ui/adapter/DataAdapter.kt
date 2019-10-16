package com.easyhome.jrconsumer.mvp.ui.adapter

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.mvp.model.entity.MPair

class DataAdapter(data: List<MPair<String, String>>) :
    BaseQuickAdapter<MPair<String, String>, BaseViewHolder>
        (R.layout.data_layout, data) {

    override fun convert(helper: BaseViewHolder, item: MPair<String, String>) {

        helper.setText(R.id.itemTitle, item.first)
        if (!item.second.isNullOrEmpty()) {
            helper.getView<RecyclerView>(R.id.imageRV).adapter = Photo5Adapter(item.second.split(","))
        }

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
    }


}