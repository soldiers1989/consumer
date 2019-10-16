package com.easyhome.jrconsumer.mvp.ui.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.extension.loadImage

class Photo5Adapter(data: List<String>) :
    BaseQuickAdapter<String, BaseViewHolder>
        (R.layout.photo_layout_5, data) {

    override fun convert(helper: BaseViewHolder, item: String) {
        helper.getView<ImageView>(R.id.icon).loadImage(item)
    }


}