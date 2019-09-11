package com.easyhome.jrconsumer.mvp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R

class DynamicAdapter(data: List<String>) :
    BaseQuickAdapter<String, BaseViewHolder>
        (R.layout.dynamic_layout, data) {

    override fun convert(helper: BaseViewHolder, item: String) {
        helper.getView<RecyclerView>(R.id.photoRV).adapter = Photo3Adapter(arrayListOf("", "", ""))
        helper.getView<RecyclerView>(R.id.leavewordRV).adapter = PInfoAdapter(arrayListOf(""))
    }


}