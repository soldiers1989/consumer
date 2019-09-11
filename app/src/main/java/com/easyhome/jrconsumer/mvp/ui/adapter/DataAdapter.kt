package com.easyhome.jrconsumer.mvp.ui.adapter

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R

class DataAdapter(data: List<String>) :
    BaseQuickAdapter<String, BaseViewHolder>
        (R.layout.data_layout, data) {

    override fun convert(helper: BaseViewHolder, item: String) {

        helper.setText(R.id.itemTitle,item)

        helper.getView<RecyclerView>(R.id.imageRV).adapter = Photo5Adapter(arrayListOf("", ""))

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