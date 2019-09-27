package com.easyhome.jrconsumer.mvp.ui.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.extension.loadImage
import com.easyhome.jrconsumer.mvp.model.javabean.ClassicCase

class DesignCaseAdapter(data: List<ClassicCase.Data>) :
    BaseQuickAdapter<ClassicCase.Data, BaseViewHolder>
        (R.layout.design_case_layout, data) {

    override fun convert(helper: BaseViewHolder, item: ClassicCase.Data) {
        helper.getView<ImageView>(R.id.coverPictur).loadImage(item.cover8235)
        helper.getView<ImageView>(R.id.head).loadImage(item.icon4466)
        helper.setText(R.id.name, item.name4466)
        helper.setText(R.id.style, "${item.style8235}/${item.lever8235}/${item.acreage8235}")
//        helper.setText(R.id.praiseTV, item.praisesCount8235)
    }


}