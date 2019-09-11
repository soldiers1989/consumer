@file:Suppress("DEPRECATION")

package com.easyhome.jrconsumer.mvp.ui.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.extension.loadImage

class GoodesAdapter(data: List<String>) :
    BaseQuickAdapter<String, BaseViewHolder>
        (R.layout.goodes_layout, data) {

    override fun convert(helper: BaseViewHolder, item: String) {
        when (helper.layoutPosition) {
            0 -> {
                helper.setImageResource(R.id.icon, R.mipmap.car_icon)
                helper.setText(R.id.name, "送货人：张三")
                helper.setText(R.id.time, "送货时间：预计2019年7月30日 送达")
            }
            1 -> {
                helper.setImageResource(R.id.icon, R.mipmap.goods_icon)
                helper.setText(R.id.name, "收货人：李四")
                helper.setText(R.id.time, "地址：北京市朝阳区双营路11号5号楼 一单元  405")
            }

        }

    }

}