package com.easyhome.jrconsumer.mvp.ui.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.mvp.model.entity.MPair

class WorkerAdapter(data: List<MPair<String, String>>) :
    BaseQuickAdapter<MPair<String, String>, BaseViewHolder>
        (R.layout.worker_layout, data) {

    override fun convert(helper: BaseViewHolder, item: MPair<String, String>) {
        helper.setText(R.id.workType,item.first)
        helper.setText(R.id.worker,item.second)
    }


}