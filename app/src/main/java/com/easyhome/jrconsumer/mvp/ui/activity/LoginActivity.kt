package com.easyhome.jrconsumer.mvp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.animation.AnimationUtils

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.easyhome.jrconsumer.di.component.DaggerLoginComponent
import com.easyhome.jrconsumer.di.module.LoginModule
import com.easyhome.jrconsumer.mvp.contract.LoginContract
import com.easyhome.jrconsumer.mvp.presenter.LoginPresenter

import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.extension.singleClick
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity


/**
 * 登录
 */
class LoginActivity : BaseActivity<LoginPresenter>(), LoginContract.View {
    override fun getMyself(): BaseActivity<*> = this

    override fun showNetError() {
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerLoginComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .loginModule(LoginModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_login //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {


        accountTV.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                println("输入的是${p0.toString()}")
                if (p0.toString().length > 0) {
                    accountClean.visibility = View.VISIBLE
                    if (passwordED.text.trim().length > 0) {//判断是否输入账号，如果如果输入则可点击
                        loginB.isChecked = true
                        loginB.isEnabled = true
                    }
                } else {
                    accountClean.visibility = View.GONE
                    loginB.isChecked = false
                    loginB.isEnabled = false
                }
            }

        })
        passwordED.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                println("输入的是${p0.toString()}")
                if (p0.toString().length > 0) {
                    passwordClean.visibility = View.VISIBLE
                    if (accountTV.text.trim().length > 0) {//判断是否输入账号，如果如果输入则可点击
                        loginB.isChecked = true
                        loginB.isEnabled = true
                    }
                } else {
                    passwordClean.visibility = View.GONE
                    loginB.isChecked = false
                    loginB.isEnabled = false
                }
            }

        })
        accountClean.singleClick {
            accountTV.text.clear()
        }
        passwordClean.singleClick {
            passwordED.text.clear()
        }
        loginB.singleClick {
            startActivity<MainActivity>()

        }
        forgetpsw.singleClick {
            startActivity<RetrievePasswordActivity>()
        }

        goRegisterTV.singleClick {
            val hide = AnimationUtils.loadAnimation(this, R.anim.gradually_hide)
            passwordCL.startAnimation(hide);
            forgetpsw.startAnimation(hide)
            logoBacIV.startAnimation(hide)
            forgetpsw.visibility = View.GONE
            passwordCL.visibility = View.GONE
            logoBacIV.visibility = View.INVISIBLE


            val show = AnimationUtils.loadAnimation(this, R.anim.gradually_show)
            verificationCL.startAnimation(show)
            logoBacIV_2.startAnimation(show)
            verificationCL.visibility = View.VISIBLE
            logoBacIV_2.visibility = View.VISIBLE

        }
        goRegisterTV2.singleClick {
            val hide = AnimationUtils.loadAnimation(this, R.anim.gradually_hide)
            verificationCL.startAnimation(hide)
            logoBacIV_2.startAnimation(hide)
            verificationCL.visibility = View.GONE
            logoBacIV_2.visibility = View.GONE

            val show = AnimationUtils.loadAnimation(this, R.anim.gradually_show)
            forgetpsw.startAnimation(show)
            passwordCL.startAnimation(show)
            logoBacIV.startAnimation(show)
            forgetpsw.visibility = View.VISIBLE
            passwordCL.visibility = View.VISIBLE
            logoBacIV.visibility = View.VISIBLE


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

}
