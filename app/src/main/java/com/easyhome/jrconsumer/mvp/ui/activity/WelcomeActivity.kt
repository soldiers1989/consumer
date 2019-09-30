package com.easyhome.jrconsumer.mvp.ui.activity

import android.app.Notification
import android.content.Intent
import android.os.Bundle
import android.os.Handler

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerWelcomeComponent
import com.easyhome.jrconsumer.di.module.WelcomeModule
import com.easyhome.jrconsumer.mvp.contract.WelcomeContract
import com.easyhome.jrconsumer.mvp.presenter.WelcomePresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.extension.singleClick
import kotlinx.android.synthetic.main.activity_welcome.*
import org.jetbrains.anko.startActivity
import android.app.NotificationManager
import android.app.NotificationChannel
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.app.NotificationCompat
import android.view.View
import me.leolin.shortcutbadger.ShortcutBadger


/**
 * 欢迎页
 *
 */
class WelcomeActivity : BaseActivity<WelcomePresenter>(), WelcomeContract.View {

    var sMessageCount = 1
    lateinit var mNotificationManager: NotificationManager
    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerWelcomeComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .welcomeModule(WelcomeModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_welcome //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {

        skipB.singleClick {
            startActivity<MainActivity>()
        }
        //测试桌面红点
        mNotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        timer()
    }

    fun timer() {
        val handler = Handler()
        val runnable = object : Runnable {
            override fun run() {
                //要做的事情
                testNotify()
            }
        }
        handler.postDelayed(runnable, 5000);
    }


    //测试通知
    fun testNotify() {
        val builder: NotificationCompat.Builder
        //8.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = NotificationCompat.Builder(this, getChannelId())
        } else {
            builder = NotificationCompat.Builder(this, "456")
            //8.0以下版本桌面红点显示
            ShortcutBadger.applyCount(this, ++sMessageCount);
        }

        builder.setSmallIcon(R.mipmap.launcher)
            .setDefaults(Notification.DEFAULT_ALL)
            .setTicker("title")
            .setAutoCancel(true)
            .setContentTitle("contentTitle")
            .setContentText("contentText")

        mNotificationManager.notify(123, builder.build())
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    fun getChannelId(): String {
        val channelId = "1"
        val channelName = "com.easyhome.jrconsumer"

        val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
        channel.enableLights(true)//显示桌面红点
        channel.lightColor = Color.RED
        channel.setShowBadge(true)
        mNotificationManager.createNotificationChannel(channel)
        return channel.id
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
}
