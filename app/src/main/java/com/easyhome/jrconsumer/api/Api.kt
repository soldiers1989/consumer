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


    const val BASE_URL = "http://39.106.135.189:8080"

    //注册登录
    const val LOGIN = "${BASE_URL}/decorate_unexpectedly/user/auth"
    //策略模式接口
    const val STRATEGY_PATTERN = "${BASE_URL}/decorate_unexpectedly/global/inlet"
    //发送短信
    const val SEND_SMS = "${BASE_URL}/decorate_unexpectedly/send/sms"
    //修改密码、忘记密码
    const val FORGET_OR_CHANGE_PASSWORD = "${BASE_URL}/decorate_unexpectedly/password/forgetOrChangePassword"
    //施工动态
    const val DYNAMIC_LIST = "${BASE_URL}/decorate_unexpectedly/api/find/dynamic/list"

    //施工计划
    const val PROJECT_PLAN = "${BASE_URL}/api/find/Project/plan"

    //项目动态-评论回复
    const val DYNAMIC_REPLY = "${BASE_URL}/api/add/dynamic/reply"
    //项目动态-评论
    const val DYNAMIC_COMMENT = "${BASE_URL}/api/add/dynamic/comment"
    //项目列表
    const val PROJECT_LIST = "${BASE_URL}/decorate_unexpectedly/api/project/find/userProjectList"
}
