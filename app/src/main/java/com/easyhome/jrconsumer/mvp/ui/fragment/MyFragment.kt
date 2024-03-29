package com.easyhome.jrconsumer.mvp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jess.arms.base.BaseActivity

import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerMyComponent
import com.easyhome.jrconsumer.di.module.MyModule
import com.easyhome.jrconsumer.mvp.contract.fragment.MyContract
import com.easyhome.jrconsumer.mvp.presenter.fragment.MyPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.base.JRBaseFragment
import com.easyhome.jrconsumer.app.extension.openH5ForUrl
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.app.manager.UserInfoManager
import com.easyhome.jrconsumer.mvp.ui.activity.*
import com.easyhome.jrconsumer.mvp.ui.activity.user.*
import com.easyhome.jrconsumer.mvp.ui.adapter.MySelectAdapter
import kotlinx.android.synthetic.main.fragment_my.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.startActivity


/**
 * 我的
 */
class MyFragment : JRBaseFragment<MyPresenter>(), MyContract.View {
    override fun getMyself(): BaseActivity<*> = this.activity as MainActivity

    companion object {
        fun newInstance(): MyFragment {
            val fragment = MyFragment()
            return fragment
        }
    }


    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerMyComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .myModule(MyModule(this))
            .build()
            .inject(this)
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    override fun initData(savedInstanceState: Bundle?) {


        val sAdapter = MySelectAdapter(
            arrayListOf(
                MySelectAdapter.Info(R.mipmap.my_icon_1, "保修政策"),
                MySelectAdapter.Info(R.mipmap.my_icon_2, "投诉/保修"),
                MySelectAdapter.Info(R.mipmap.my_icon_3, "联系客服"),
                MySelectAdapter.Info(R.mipmap.my_icon_4, "关务我们"),
                MySelectAdapter.Info(R.mipmap.my_icon_5, "我的评分"),
                MySelectAdapter.Info(R.mipmap.my_icon_6, "设置"),
                MySelectAdapter.Info(R.mipmap.my_icon_7, "分享好友"),
                MySelectAdapter.Info(R.mipmap.my_icon_8, "项目服务人员信息")
            )
        )
        sAdapter.setOnItemClickListener { adapter, view, position ->

            when (position) {

                0 -> {
                    startActivity<RepairsRuleActivity>()
                }
                1 -> {
                    //  startActivity<ComplaintOrRepairsActivity>()
                    // startActivity<MakeComplaintActivity>()
                    startActivity<ComplaintOrRepairsActivity>()
                }
                2 -> {

                }
                3 -> {
                    startActivity<H5Activity>(
                        "pageUrl" to "http://111.231.114.131/guochongyang/%E6%B6%88%E8%B4%B9%E8%80%85-moblie/m_%20about.html",
                        "title" to "关于我们")
                }
                4 -> {
                    startActivity<GradeListActivity>()
                }
                5 -> {
                    startActivity<SettingActivity>()
                }
                6 -> {
                    startActivity<ShareActivity>()
                }
                7 -> {
                    startActivity<RelatedPersonnelActivity>()
                }
            }

        }
        var adaptr = sAdapter

        val fView = LayoutInflater.from(activity).inflate(R.layout.rv_foot_layout, null)
        fView.singleClick {
            UserInfoManager.getInstance().setLogin(false)
            (activity as MainActivity).setCurrentTab(0)
        }
        adaptr.addFooterView(fView)
        userSelectRV.adapter = adaptr

        userData.singleClick {
            startActivity<UserDataActivity>()
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
}
