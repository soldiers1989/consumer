package com.easyhome.jrconsumer.mvp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R

class FriendsAdapter(data: List<String>) :
    BaseQuickAdapter<String, BaseViewHolder>
        (R.layout.friends_layout, data) {

    override fun convert(helper: BaseViewHolder, item: String) {

    }


}