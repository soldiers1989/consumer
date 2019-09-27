package com.easyhome.jrconsumer.api

/**
 * 存放一些与 API 有关的东西,如请求地址,请求码等
 */
object Api {

    const val BASE = "api-user/"
    const val APP_BASE_URL = "http://api.qizhekeji.com/${BASE}"


    const val RequestSuccess = 0
    const val KEY_UUID = "KEY_UUID"
    const val USERAPI = "userapi"
    const val APP_LOGO_URl = "${APP_BASE_URL}${USERAPI}"


    const val BASE_URL = "http://39.105.53.52:8080"

    //注册登录
    const val LOGIN = "${BASE_URL}/decorate_unexpectedly/user/auth"
    //策略模式接口
    const val STRATEGY_PATTERN = "${BASE_URL}/decorate_unexpectedly/global/inlet"
    //发送短信
    const val SEND_SMS = "${BASE_URL}/decorate_unexpectedly/send/sms"
    //修改密码、忘记密码
    const val FORGET_OR_CHANGE_PASSWORD = "${BASE_URL}/decorate_unexpectedly/password/forgetOrChangePassword"
}
