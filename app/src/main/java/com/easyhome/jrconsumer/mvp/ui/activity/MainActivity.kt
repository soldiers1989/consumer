package com.easyhome.jrconsumer.mvp.ui.activity

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener

import com.jess.arms.base.BaseActivity
import com.jess.arms.base.delegate.FragmentNavigator
import com.jess.arms.di.component.AppComponent
import com.jess.arms.integration.AppManager
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerMain2Component
import com.easyhome.jrconsumer.di.module.Main2Module
import com.easyhome.jrconsumer.mvp.contract.Main2Contract
import com.easyhome.jrconsumer.mvp.presenter.Main2Presenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.api.Api
import com.easyhome.jrconsumer.app.JRApp
import com.easyhome.jrconsumer.app.base.JRBaseActivity
import com.easyhome.jrconsumer.app.manager.UserInfoManager
import com.easyhome.jrconsumer.mvp.model.entity.TabEntity
import com.easyhome.jrconsumer.mvp.ui.adapter.HomeFragmentAdapter
import kotlinx.android.synthetic.main.activity_main2.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.startActivity
import java.util.ArrayList


/**
 * 主页
 */
class MainActivity : JRBaseActivity<Main2Presenter>(), Main2Contract.View {

    private lateinit var mIconUnSelectIds: IntArray
    private lateinit var mIconSelectIds: IntArray
    private lateinit var mTabTitles: Array<String>
    private lateinit var mFragmentNavigator: FragmentNavigator
    private var currentPosition = 0
    var statusBarHeight: Int = 0
    private var position = 0 // 正在一次登录记录
    private var position1 = 0 // 上一次登录记录
    override fun isSupportSwipeBack() = false
    override fun isUseParentLayout() = false
    override fun getMyself(): BaseActivity<*> = this

    override fun showNetError() {
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMain2Component //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .main2Module(Main2Module(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main2 //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        getApp()
        //   DialogUtils.showUpDataDialog(this, "2.0版本", "http://candao.qizhekeji.com/app-release.apk")

        mIconUnSelectIds = intArrayOf(
            R.mipmap.jr_tab_main_icon_f,
            R.mipmap.jr_tab_home_f,
            R.mipmap.jr_my_icon_f
        )
        mIconSelectIds = intArrayOf(
            R.mipmap.jr_tab_main_icon_t,
            R.mipmap.jr_tab_home_t,
            R.mipmap.jr_my_icon_t
        )
        mTabTitles = arrayOf("首页", "新家", "我的")


        initAllFragment(savedInstanceState)
        initTabs()
        setCurrentTab(currentPosition)
        //获取到状态栏的高度
        val frame: Rect = Rect()
        window.decorView.getWindowVisibleDisplayFrame(frame)
        statusBarHeight = frame.top
    }

    private fun initAllFragment(savedInstanceState: Bundle?) {
        mFragmentNavigator =
                FragmentNavigator(supportFragmentManager, HomeFragmentAdapter(mTabTitles), R.id.homeContent)
        mFragmentNavigator.setDefaultPosition(0)
        mFragmentNavigator.onCreate(savedInstanceState)
    }

    private fun initTabs() {
        val tabEntities = mTabTitles.indices.mapTo(ArrayList<CustomTabEntity>()) {
            TabEntity(mTabTitles[it], mIconSelectIds[it], mIconUnSelectIds[it])
        }
        homeTab.setTabData(tabEntities)
        homeTab.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                /*if (position == 2) {
                    if (TextUtils.isEmpty(UserInfoManager.getInstance().userId)) {
                        this@Main2Activity.position = position
                        startActivityForResult(
                            Intent(this@Main2Activity, LoginActivity::class.java),
                            Api.LOGIN_REQUEST_CODE
                        )
                    } else {
                        setCurrentTab(position)
                    }
                } else {
                    position1 = position
                    setCurrentTab(position)
                }*/
                setCurrentTab(position)
            }

            override fun onTabReselect(position: Int) {

            }
        })
    }

    fun setCurrentTab(position: Int) {
        currentPosition = position
        if (position == 2) {
            if (!UserInfoManager.getInstance().isLogin) {
                startActivityForResult(
                    Intent(this@MainActivity, LoginActivity::class.java),
                    Api.LOGIN_REQUEST_CODE
                )
                //  mFragmentNavigator.showFragment(position)
            } else {
                mFragmentNavigator.showFragment(position)
            }
        } else {
            mFragmentNavigator.showFragment(position)
        }
        homeTab.currentTab = position
        mFragmentNavigator.currentFragment?.userVisibleHint = true
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit()
            true
        } else {
            super.onKeyDown(keyCode, event)
        }
    }

    private var mExitTime: Long = 0
    private fun exit() {
        if (System.currentTimeMillis() - mExitTime > 2000) {
            showMessage("再按一次退出应用")
            mExitTime = System.currentTimeMillis()
        } else {
            AppManager.getAppManager().appExit()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Api.LOGIN_REQUEST_CODE && resultCode == Api.LOGIN_RESULT_CODE) {
          //  Log.e("jsjsjsjs","skdajldjl--------")
            mFragmentNavigator.showFragment(2)

        }
    }

    companion object {
        //退出登陆时  值为true  重新加载加载“我的”页面   如果其他模块需要重新加载  可以以此类推再写一个变量来做退出标识
        var MyRefresh = false

        private const val PAGE_MAP = 0
        private const val PAGE_DESIGN = 1
        private const val PAGE_DIY = 2
        private const val PAGE_USER = 3

        const val KEY_PAGE_INDEX = "pageIndex"

        fun goHome(context: Context, tabnumer: Int) {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("tabnumer", tabnumer)
            context.startActivity(intent)
        }

        /**
         * 首页
         */
        fun openMapPage(context: Context) {
            openPage(context, PAGE_MAP)
        }

        /**
         * 设计家
         */
        fun openDesigPage(context: Context) {
            openPage(context, PAGE_DESIGN)
        }

        /**
         * DIY
         */
        fun openDIYPage(context: Context) {
            openPage(context, PAGE_DIY)
        }

        /**
         * 我的
         */
        fun openUserPage(context: Context) {
            openPage(context, PAGE_USER)
        }

        private fun openPage(context: Context, type: Int) {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra(KEY_PAGE_INDEX, type)
            context.startActivity(intent)
        }
    }

    override fun showMessage(message: String) {
        ArmsUtils.snackbarText(message)
    }

    override fun launchActivity(intent: Intent) {
        ArmsUtils.startActivity(intent)
    }

    override fun killMyself() {
        finish()
    }

    fun getApp(): JRApp {
        return applicationContext as JRApp
    }


}
