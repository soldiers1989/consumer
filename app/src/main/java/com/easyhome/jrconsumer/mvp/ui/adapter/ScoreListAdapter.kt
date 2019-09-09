package com.easyhome.jrconsumer.mvp.ui.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R

class ScoreListAdapter(data: List<String>) :
    BaseQuickAdapter<String, BaseViewHolder>
        (R.layout.score_list_layout, data) {

    override fun convert(helper: BaseViewHolder, item: String) {
    }


}