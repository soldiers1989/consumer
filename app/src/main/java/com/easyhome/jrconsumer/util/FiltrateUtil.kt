package com.easyhome.jrconsumer.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.mvp.ui.adapter.OptionAdapter
import kotlinx.android.synthetic.main.select_area_layout.view.*
import kotlinx.android.synthetic.main.select_city_layout.view.*
import kotlinx.android.synthetic.main.select_house_type_layout.view.*
import kotlinx.android.synthetic.main.select_style_layout.view.*
import java.text.FieldPosition

class FiltrateUtil {

    companion object {

        const val CITY = 0
        const val HOUSE_TYPE = 1
        const val STYLE = 2
        const val AREA = 3
        const val PRICE = 4
        /**
         * @position 0,1,2,3
         */
        fun getFiltrateView(context: Context, position: Int, rootView: ViewGroup): View {
            lateinit var view: View
            when (position) {
                CITY -> {
                    view = LayoutInflater.from(context).inflate(R.layout.select_city_layout, rootView, false)
                    view.provinceRV.adapter = OptionAdapter(
                        arrayListOf(
                            OptionAdapter.Data("北京", false, R.mipmap.select_icon_2),
                            OptionAdapter.Data("河北省", true, R.mipmap.select_icon_2),
                            OptionAdapter.Data("河南省", false, R.mipmap.select_icon_2),
                            OptionAdapter.Data("黑龙江省", false, R.mipmap.select_icon_2),
                            OptionAdapter.Data("辽宁省", false, R.mipmap.select_icon_2)
                        )
                    )
                    view.cityRV.adapter = OptionAdapter(
                        arrayListOf(
                            OptionAdapter.Data("石家庄市", false, R.mipmap.select_icon),
                            OptionAdapter.Data("秦皇岛市", true, R.mipmap.select_icon),
                            OptionAdapter.Data("北戴河市", false, R.mipmap.select_icon),
                            OptionAdapter.Data("石家庄市", false, R.mipmap.select_icon)
                        )
                    )
                }
                HOUSE_TYPE -> {
                    view = LayoutInflater.from(context).inflate(R.layout.select_house_type_layout, rootView, false)
                    view.houseTypeRV.adapter = OptionAdapter(
                        arrayListOf(
                            OptionAdapter.Data("全部", false, R.mipmap.select_icon),
                            OptionAdapter.Data("一室一厅", true, R.mipmap.select_icon),
                            OptionAdapter.Data("两室两厅", false, R.mipmap.select_icon),
                            OptionAdapter.Data("三室两厅", false, R.mipmap.select_icon)
                        )
                    )
                }
                STYLE -> {
                    view = LayoutInflater.from(context).inflate(R.layout.select_style_layout, rootView, false)
                    view.styleRV.adapter = OptionAdapter(
                        arrayListOf(
                            OptionAdapter.Data("欧式", false, R.mipmap.select_icon),
                            OptionAdapter.Data("美式", true, R.mipmap.select_icon),
                            OptionAdapter.Data("中式", false, R.mipmap.select_icon),
                            OptionAdapter.Data("其他", false, R.mipmap.select_icon)
                        )
                    )
                }
                AREA -> {
                    view = LayoutInflater.from(context).inflate(R.layout.select_area_layout, rootView, false)
                    view.areaRV.adapter = OptionAdapter(
                        arrayListOf(
                            OptionAdapter.Data("全部", false, R.mipmap.select_icon),
                            OptionAdapter.Data("小于60m²", true, R.mipmap.select_icon),
                            OptionAdapter.Data("60m²~80m²", false, R.mipmap.select_icon),
                            OptionAdapter.Data("80m²~120m²", false, R.mipmap.select_icon),
                            OptionAdapter.Data("120m²以上", false, R.mipmap.select_icon)
                        )
                    )

                }
                PRICE -> {
                    view = LayoutInflater.from(context).inflate(R.layout.select_area_layout, rootView, false)
                    view.areaRV.adapter = OptionAdapter(
                        arrayListOf(
                            OptionAdapter.Data("全部", false, R.mipmap.select_icon),
                            OptionAdapter.Data("小于100元/m²", true, R.mipmap.select_icon),
                            OptionAdapter.Data("100~300元/m²", false, R.mipmap.select_icon),
                            OptionAdapter.Data("300~500元/m²", false, R.mipmap.select_icon),
                            OptionAdapter.Data("500~800元/m²", false, R.mipmap.select_icon)
                        )
                    )

                }

            }
            return view
        }
    }
}