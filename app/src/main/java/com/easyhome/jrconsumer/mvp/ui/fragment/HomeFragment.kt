package com.easyhome.jrconsumer.mvp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bigkoo.convenientbanner.ConvenientBanner
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator
import com.bigkoo.convenientbanner.holder.Holder
import com.bigkoo.convenientbanner.listener.OnPageChangeListener
import com.jess.arms.base.BaseActivity

import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerHomeComponent
import com.easyhome.jrconsumer.di.module.HomeModule
import com.easyhome.jrconsumer.mvp.contract.fragment.HomeContract
import com.easyhome.jrconsumer.mvp.presenter.fragment.HomePresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.api.RequestCodeInfo
import com.easyhome.jrconsumer.app.base.JRBaseFragment
import com.easyhome.jrconsumer.app.extension.loadImage
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.mvp.model.entity.MPair
import com.easyhome.jrconsumer.mvp.ui.activity.*
import com.easyhome.jrconsumer.mvp.ui.activity.live.LiveActivity
import com.easyhome.jrconsumer.mvp.ui.activity.live.LiveDetailsActivity
import com.easyhome.jrconsumer.mvp.ui.activity.message.MessageCenterActivity
import com.easyhome.jrconsumer.mvp.ui.activity.recommend.ClassicCaseActivity
import com.easyhome.jrconsumer.mvp.ui.activity.recommend.ConstructionTeamActivity
import com.easyhome.jrconsumer.mvp.ui.activity.recommend.DesignerListActivity
import com.easyhome.jrconsumer.mvp.ui.activity.search.CityPickerActivity
import com.easyhome.jrconsumer.mvp.ui.adapter.*
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.startActivity


/**
 * 首页
 */
class HomeFragment : JRBaseFragment<HomePresenter>(), HomeContract.View {
    override fun getMyself(): BaseActivity<*> = this.activity as MainActivity

    companion object {
        fun newInstance(): HomeFragment {
            val fragment = HomeFragment()
            return fragment
        }
    }


    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerHomeComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .homeModule(HomeModule(this))
            .build()
            .inject(this)
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    override fun initData(savedInstanceState: Bundle?) {
        showa.singleClick { startActivity<PredetermineActivity>() }
        val sAdapter = HomeServeAdapter(
            arrayListOf(
                MPair(R.mipmap.serve_icon_1, "精品案例"),
                MPair(R.mipmap.serve_icon_2, "产品介绍"),
                MPair(R.mipmap.serve_icon_3, "合作品牌"),
                MPair(R.mipmap.serve_icon_4, "门店信息"),
                MPair(R.mipmap.serve_icon_5, "设计师"),
                MPair(R.mipmap.serve_icon_6, "施工队"),
                MPair(R.mipmap.serve_icon_7, "直播间"),
                MPair(R.mipmap.serve_icon_8, "装修计算器")
            )
        )
        sAdapter.setOnItemClickListener { adapter, view, position ->

            when (position) {
                0 -> startActivity<ClassicCaseActivity>()
                2 -> startActivity<CooperativeBrandActivity>()
                4 -> startActivity<DesignerListActivity>()
                5 -> startActivity<ConstructionTeamActivity>()
                6 -> startActivity<LiveActivity>()
            }

        }
        serveRV.adapter = sAdapter
        processRV.adapter = HomeServe2Adapter(
            arrayListOf(
                MPair(R.mipmap.process_icon_1, "在线预约"),
                MPair(R.mipmap.process_icon_2, "上门量房"),
                MPair(R.mipmap.process_icon_3, " 预交底 "),
                MPair(R.mipmap.process_icon_4, "更多详情")
            )
        )

        val dAdapter=DesignCaseAdapter(arrayListOf("", "", "", ""))
        dAdapter.setOnItemClickListener { adapter, view, position ->

            startActivity<H5Activity>(
                "pageUrl" to "http://111.231.114.131/guochongyang/%E6%B6%88%E8%B4%B9%E8%80%85-moblie/m_%20case%20details.html",
                "title" to "精品案例")

        }
        caseRV.adapter = dAdapter
        val lAdapter = LiveAdapter(arrayListOf("", "", "", ""))
        lAdapter.setOnItemClickListener { adapter, view, position ->
            startActivity<LiveDetailsActivity>()
        }
        liveRV.adapter = lAdapter
        message.singleClick { startActivity<MessageCenterActivity>() }

        moreCase.singleClick {
            startActivity<ClassicCaseActivity>()
        }
        moreLive.singleClick {
            startActivity<LiveActivity>()
        }
        notification.singleClick {
            startActivity<MessageInfoActivity>()
        }


    }

    /**
     * 通过此方法可以使 Fragment 能够与外界做一些交互和通信, 比如说外部的 Activity 想让自己持有的某个 Fragment 对象执行一些方法,
     * 建议在有多个需要与外界交互的方法时, 统一传 {@link Message}, 通过 what 字段来区分不同的方法, 在 {@link #setData(Object)}
     * 方法中就可以 {@code switch} 做不同的操作, 这样就可以用统一的入口方法做多个不同的操作, 可以起到分发的作用
     * <p>
     * 调用此方法时请注意调用时 Fragment 的生命周期, 如果调用 {@link #setData(Object)} 方法时 {@link Fragment#onCreate(Bundle)} 还没执行
     * 但在 {@link #setData(Object)} 里却调用了 Presenter 的方法, 是会报空的, 因为 Dagger 注入是在 {@link Fragment#onCreate(Bundle)} 方法中执行的
     * 然后才创建的 Presenter, 如果要做一些初始化操作,可以不必让外部调用 {@link #setData(Object)}, 在 {@link #initData(Bundle)} 中初始化就可以了
     * <p>
     * Example usage:
     * <pre>
     *fun setData(data:Any) {
     *   if(data is Message){
     *       when (data.what) {
     *           0-> {
     *               //根据what 做你想做的事情
     *           }
     *           else -> {
     *           }
     *       }
     *   }
     *}
     *
     *
     *
     *
     *
     * // call setData(Object):
     * val data = Message();
     * data.what = 0;
     * data.arg1 = 1;
     * fragment.setData(data);
     * </pre>
     *
     * @param data 当不需要参数时 {@code data} 可以为 {@code null}
     */
    override fun setData(data: Any?) {

    }


    override fun showMessage(message: String) {
        ArmsUtils.snackbarText(message)
    }

    override fun launchActivity(intent: Intent) {
        ArmsUtils.startActivity(intent)
    }

    override fun killMyself() {

    }

    inner class ImageHolderView(itemView: View) : Holder<String>(itemView) {
        private var imageView: ImageView? = null

        override fun initView(itemView: View) {
            imageView = itemView.findViewById(R.id.ivBanner)
        }

        override fun updateUI(url: String) {
            imageView?.loadImage(url)
        }
    }
}
