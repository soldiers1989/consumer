package com.easyhome.jrconsumer.mvp.ui.adapter

import android.widget.ImageView
import com.cb.ratingbar.CBRatingBar
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.mvp.model.entity.MPair

class ScoreListAdapter(data: List<MPair<String, Float>>) :
    BaseQuickAdapter<MPair<String, Float>, BaseViewHolder>
        (R.layout.score_list_layout, data) {

    override fun convert(helper: BaseViewHolder, item: MPair<String, Float>) {
        helper.setText(R.id.name, item.first)
        helper.getView<CBRatingBar>(R.id.score).starProgress = item.second
    }


}