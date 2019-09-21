package com.easyhome.jrconsumer.mvp.ui.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R

class OptionAdapter(data: List<OptionAdapter.Data>) :
    BaseQuickAdapter<OptionAdapter.Data, BaseViewHolder>
        (R.layout.option_layout, data) {

    override fun convert(helper: BaseViewHolder, item: OptionAdapter.Data) {
        helper.setText(R.id.content, item.conten)
        if (item.select) {
            helper.setImageResource(R.id.selectIV, item.type)
        } else {
            helper.setImageResource(R.id.selectIV, R.drawable.null_background)
        }
    }

    data class Data(var conten: String, var select: Boolean, var type: Int)

}