package com.easyhome.jrconsumer.api.service

import com.easyhome.jrconsumer.api.Api
import com.easyhome.jrconsumer.mvp.model.entity.HttpResult
import com.easyhome.jrconsumer.mvp.model.entity.LoginInfo
import com.easyhome.jrconsumer.mvp.model.javabean.ClassicCase
import com.easyhome.jrconsumer.mvp.model.javabean.ParentBean
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.*


interface JRService {


    /**
     * 用户登录
     *
     * @param phone    手机号
     * @param password 密码
     * @param app_os    操作系统
     */
    @POST("${Api.LOGIN}")//("${Api.STRATEGY_PATTERN}")
    fun login(@Body requestBody: RequestBody): Observable<HttpResult<LoginInfo>>

    /**
     * 修改密码
     */
    @POST("${Api.FORGET_OR_CHANGE_PASSWORD}")
    fun alter(@Body requestBody: RequestBody): Observable<HttpResult<Boolean>>

    /**
     * 合作品牌
     */
    @POST("${Api.STRATEGY_PATTERN}")
    fun brand(@Body requestBody: RequestBody): Observable<HttpResult<Any>>


    /**
     * 验证码
     * @param phone   手机号
     */
    @FormUrlEncoded
    @POST("${Api.SEND_SMS}")
    fun smsCode(
        @Field("mobile") mobile: String,
        @Field("genre") genre: String,
        @Field("type") type: String
    ): Observable<HttpResult<Any>>

    /**
     * 测试
     * @param phone   手机号
     */
    @POST("${Api.FORGET_OR_CHANGE_PASSWORD}")
    fun test(
        @Body requestBody: RequestBody
    ): Observable<HttpResult<Any>>

    @POST("${Api.STRATEGY_PATTERN}")
    fun classicCase(@Body requestBody: RequestBody): Observable<HttpResult<List<ClassicCase>>>


}
