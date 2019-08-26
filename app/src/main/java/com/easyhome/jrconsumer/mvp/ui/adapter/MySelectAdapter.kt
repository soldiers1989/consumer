package com.easyhome.jrconsumer.mvp.ui.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R

class MySelectAdapter(data: List<MySelectAdapter.Info>) :
    BaseQuickAdapter<MySelectAdapter.Info, BaseViewHolder>
        (R.layout.my_select_item_layout, data) {

    override fun convert(helper: BaseViewHolder, item: Info) {
        helper.getView<ImageView>(R.id.iconIV).setImageResource(item.icon)
        helper.setText(R.id.itemTV, item.title)
    }

    data class Info(
        var icon: Int,
        var title: String
    )
}