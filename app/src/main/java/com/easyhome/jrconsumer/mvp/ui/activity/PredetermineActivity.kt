package com.easyhome.jrconsumer.mvp.ui.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.bigkoo.pickerview.OptionsPickerView

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerPredetermineComponent
import com.easyhome.jrconsumer.di.module.PredetermineModule
import com.easyhome.jrconsumer.mvp.contract.PredetermineContract
import com.easyhome.jrconsumer.mvp.presenter.PredeterminePresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.extension.getRequestBody
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.contract.search.CityPicker1Contract
import com.easyhome.jrconsumer.mvp.model.entity.MPair
import com.easyhome.jrconsumer.util.ToastUtil
import kotlinx.android.synthetic.main.activity_predetermine.*
import kotlinx.android.synthetic.main.layout_title.*
import kotlinx.android.synthetic.main.tab_layout_2.*


/**
 * 预约设计
 */
class PredetermineActivity : JRBaseActivity<PredeterminePresenter>(), PredetermineContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerPredetermineComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .predetermineModule(PredetermineModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_predetermine //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {

        tvPageTitle.text = "预约设计师"
        ivPageBack.singleClick { killMyself() }

        predetermine.singleClick {

            if (phone.text.trim().toString().length > 0 && name.text.trim().toString().length > 0) {


                val b2 = BrandArguments.BeanII(
                    "0",
                    start.text.toString(),
                    homeTypeTV.tag.toString(),
                    areaET.text.toString(),
                    style.tag.toString(),
                    extraET.text.toString(),
                    province.tag.toString(),
                    city.tag.toString(),
                    county.tag.toString(),
                    town.tag.toString(),
                    detailET.text.toString(),
                    "3",
                    phone.text.toString(),
                    name.text.toString(),
                    end.text.toString()

                )

                val b1 = BrandArguments.BeanI(arrayListOf(b2))
                val b = BrandArguments("S85237-I67167-C06208-B85798", "1", arrayListOf(b1))


                mPresenter!!.predetermine(b.getRequestBody()) {
                    showMessage("预约成功")
                    killMyself()
                }
            } else {
                showMessage("未填写必填项")
            }
        }


        province.singleClick {

            showPickerView("省份选择", arrayListOf(MPair("河北", 1), MPair("北京", 1)), province)

        }
        city.singleClick {

            if (province.text.toString().equals("河北")) {
                showPickerView(
                    "城市选择",
                    arrayListOf(MPair("石家庄", 10)),
                    city
                )
            } else {
                showPickerView(
                    "城市选择",
                    arrayListOf(MPair("北京", 10)),
                    city
                )
            }

        }
        county.singleClick {

            if (city.text.toString().equals("石家庄")) {
                showPickerView(
                    "区县选择",
                    arrayListOf(MPair("正定", 398), MPair("赵县", 398)),
                    county
                )
            } else {
                showPickerView(
                    "区县选择",
                    arrayListOf(MPair("朝阳区", 398), MPair("海淀区", 398)),
                    county
                )
            }

        }
        town.singleClick {
            if (county.text.toString().equals("正定")) {
                showPickerView(
                    "街道选择",
                    arrayListOf(MPair("迎宾路", 0), MPair("正阳街", 0)),
                    town
                )
            } else if (county.text.toString().equals("赵县")) {
                showPickerView(
                    "街道选择",
                    arrayListOf(MPair("莱阳路", 0), MPair("希望路", 0)),
                    town
                )
            } else if (county.text.toString().equals("朝阳区")) {
                showPickerView(
                    "街道选择",
                    arrayListOf(MPair("东风南路", 0), MPair("双营路", 0)),
                    town
                )
            } else if (county.text.toString().equals("海淀区")) {
                showPickerView(
                    "街道选择",
                    arrayListOf(MPair("上地", 0), MPair("西二旗", 0)),
                    town
                )
            }

        }


        homeTypeTV.singleClick {

            showPickerView("户型选择", arrayListOf(MPair("三室一厅", 1), MPair("两室一厅", 1)), homeTypeTV)
        }
        style.singleClick {

            showPickerView("风格选择", arrayListOf(MPair("中式", 1), MPair("欧式", 1)), style)
        }

    }


    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showMessage(message: String) {
        ArmsUtils.snackbarText(message)

        ToastUtil.showShort(this, message)
    }

    override fun launchActivity(intent: Intent) {
        ArmsUtils.startActivity(intent)
    }

    override fun killMyself() {
        finish()
    }

    private data class BrandArguments(val codes: String, val isVerify: String, val datas: List<BeanI>) {
        data class BeanI(val data: List<BeanII>)
        data class BeanII(
            val userID_8966: String, val inBudget_8966: String, val houseHold_8966: String,
            val floorage_8966: String, val decorateStyle_8966: String, val remarks_8966: String,
            val province_8966: String, val city_8966: String, val counties_8966: String,
            val street_8966: String, val address_8966: String, val source_8966: String,
            val linkMobile_8966: String, val userName_8966: String, val inBudgetM_8966: String
        )


        /* "userID_8966":"0",
         "inBudget_8966":"5000.00",
         "":"1",
         "":"120",
         "":"1",
         "":"比较偏爱中式风格",
         "":"1",
         "":"10",
         "":"398",
         "":"花园街",
         "":"北京市朝阳区花园街21",
         "":"3",
         "":"13668494939",
         "":"赵11",
         "":"30000.00"*/
    }


    fun showPickerView(title: String, datas: List<MPair<String, Int>>, view: TextView) {// 弹出选择器

        val pvOptions = OptionsPickerView.Builder(this,
            OptionsPickerView.OnOptionsSelectListener { options1, options2, options3, v ->
                //返回的分别是三个级别的选中位置
                var data = datas.get(options1);
                view.text = data.first
                view.tag = data.second
            })

            .setTitleText(title)
            .setDividerColor(Color.GRAY)
            .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
            .setContentTextSize(20)
            .setBgColor(Color.parseColor("#F6F7F6"))
            .setTitleSize(20)
            .setSubmitColor(Color.parseColor("#50abd2"))
            .setCancelColor(Color.parseColor("#50abd2"))
            .build()

        val ls = mutableListOf<String>()
        datas.forEach {
            ls.add(it.first)
        }
        pvOptions.setPicker(ls)//三级选择器
        pvOptions.show()
    }

}
