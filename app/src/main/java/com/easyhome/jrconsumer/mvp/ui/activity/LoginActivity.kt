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
import com.easyhome.jrconsumer.app.extension.getRequestBody
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.app.manager.UserInfoManager
import com.easyhome.jrconsumer.mvp.model.entity.LoginArgumentsBean
import com.easyhome.jrconsumer.mvp.model.entity.TestBean
import com.easyhome.jrconsumer.mvp.model.entity.TestResult
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import android.text.InputType


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

        /* mPresenter!!.test(TestBean("S85237-I72191-C52513-B18169", "sdkfal")) {


          }*/

        /*
        //注册
        val args = LoginArgumentsBean(
            "S85237-I72191-C18279-B65163", "12345",
            arrayListOf(LoginArgumentsBean.Bean(arrayListOf(mapOf(
                Pair("password_2290", "123"),
                Pair("mobile_2290", "13612341234"),
                Pair("status_2290", "0"),
                Pair("ip_2290", "192.168.1.1")
            ))))
        )*/


        /* val args = LoginArgumentsBean(
             "S85237-I72191-C49749-B49793", "12345",
             arrayListOf(LoginArgumentsBean.Bean(arrayListOf(mapOf(
                 Pair("password_2290", "123"),
                 Pair("mobile_2290", "13510417332"),
                 Pair("status_2290", "0"),
                 Pair("ip_2290", "192.168.1.1"),
                 Pair("IP_4895", "192.168.1.1"),
                 Pair("token_4895", "123"),
                 Pair("type_4895", "0"),
                 Pair("id_4895", "2"),
                 Pair("userID_4895", "2"),
                 Pair("os_4895", "1")
             ))))
         )*/
        /*  mPresenter!!.login(args) {

          }*/

        /*
        //初始化接口
        mPresenter!!.test(mapOf(Pair("codes","S85237-I72191-C56211-B01605"), Pair("isVerify","1"))){
             mobile_1319
         }*/
        /*
        //查询手机号是否存在
        mPresenter!!.test(TestResult("S85237-I72191-C61941-B59134",
            "1",
            arrayListOf(TestResult.Data(arrayListOf(TestResult.Data.Condition("mobile_2290","13612341234","1"))))
            )){
        }*/

/*// 发送验证吗
        mPresenter!!.smsCode("13691345442"){

        }*/

        /*  mPresenter!!.test(
              mapOf(
                  Pair("mobile", "13612341234"),
                  Pair("type", "2"),
                  Pair("newPassword", "qwe123"),
                  Pair("oldPassword", "123")
              )
          ) {

          }*/
        val args = LoginArgumentsBean(
            "S85237-I72191-C93024-B93528", "1",
            arrayListOf(
                LoginArgumentsBean.Bean(
                    arrayListOf(
                        mapOf(
                            Pair("userID", "12"),
                            Pair("mobile_1319", "13691345442"),
                            Pair("code", "613437"),
                            Pair("logTime", "2019-09-24 21:17:49"),
                            Pair("status", "0"),
                            Pair("genre", "0")
                        )
                    )
                )
            )
        )

        accountTV.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                println("输入的是${p0.toString()}")
              /*  if (p0.toString().length > 0) {
                    accountClean.visibility = View.VISIBLE
                    if (passwordED.text.trim().length > 0) {//判断是否输入账号，如果如果输入则可点击
                        loginB.isChecked = true
                        loginB.isEnabled = true
                    }
                } else {
                    accountClean.visibility = View.GONE
                    loginB.isChecked = false
                    loginB.isEnabled = false
                }*/
            }

        })
        passwordED.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                println("输入的是${p0.toString()}")
               /* if (p0.toString().length > 0) {
                    passwordClean.visibility = View.VISIBLE
                    if (accountTV.text.trim().length > 0) {//判断是否输入账号，如果如果输入则可点击
                        loginB.isChecked = true
                        loginB.isEnabled = true
                    }
                } else {
                    passwordClean.visibility = View.GONE
                    loginB.isChecked = false
                    loginB.isEnabled = false
                }*/
            }

        })
        accountClean.singleClick {
            accountTV.text.clear()
        }
        passwordClean.singleClick {

            if (passwordED.inputType == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                passwordClean.setImageResource(R.mipmap.psw_show)
                passwordED.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
            } else {
                passwordClean.setImageResource(R.mipmap.psw_hide)
                passwordED.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            }
        }
        loginB.singleClick {

            if (verificationCL.visibility == View.VISIBLE) {
                //验证码登录
                codeLogin()
            } else {
                //密码登录
                pswLogin()
            }
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

        sendSms.singleClick {
            //发送验证码
            mPresenter!!.smsCode(
                accountTV2.text.toString(),
                "0",
                "0"
            ) {


            }

        }

    }


    fun codeLogin() {
        if (accountTV2.text.trim().length != 11 || passwordED2.text.trim().length != 6) {
            showMessage("请正确输入手机号和验证码")
        } else if (!userAgreement.isChecked) {
            showMessage("请同意用户协议")
        } else {
            mPresenter!!.login(
                mapOf(
                    Pair("mobile", accountTV2.text.toString()),
                    Pair("authCode", passwordED2.text.toString()),
                    Pair("uuid", UserInfoManager.getInstance().uuid),
                    Pair("ip", UserInfoManager.getInstance().getIpAddress()),
                    Pair("os", "1"),
                    Pair("loginType", "2")
                ).getRequestBody()
            ) {
                UserInfoManager.getInstance().saveUserInfo(it);
                killMyself()
            }
        }
    }

    fun pswLogin() {
        if (accountTV.text.trim().length != 11 || passwordED.text.trim().length < 3) {
            showMessage("请正确输入手机号和密码")
        } else if (!userAgreement.isChecked) {
            showMessage("请同意用户协议")
        } else {
            mPresenter!!.login(
                mapOf(
                    Pair("mobile", accountTV.text.toString()),
                    Pair("password", passwordED.text.toString()),
                    Pair("uuid", UserInfoManager.getInstance().uuid),
                    Pair("ip", UserInfoManager.getInstance().getIpAddress()),
                    Pair("os", "1"),
                    Pair("loginType", "1")
                ).getRequestBody()
            ) {
                UserInfoManager.getInstance().saveUserInfo(it);
                killMyself()
            }
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
