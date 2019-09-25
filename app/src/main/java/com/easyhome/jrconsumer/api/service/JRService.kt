package com.easyhome.jrconsumer.api.service

import com.easyhome.jrconsumer.api.Api
import com.easyhome.jrconsumer.mvp.model.entity.HttpResult
import com.easyhome.jrconsumer.mvp.model.entity.LoginInfo
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
    @POST("http://10.240.10.81:8080/decorate_unexpectedly/user/auth")//("${Api.LOGIN_TEST}")
    fun login(@Body requestBody: RequestBody): Observable<HttpResult<LoginInfo>>
    /**
     * 修改密码
     */
    @POST("${Api.FORGET_OR_CHANGE_PASSWORD}")
    fun alter(@Body requestBody: RequestBody): Observable<HttpResult<Boolean>>
    /**
     * 合作品牌
     */
    @POST("${Api.LOGIN_TEST}")
    fun brand(@Body requestBody: RequestBody): Observable<HttpResult<Any>>





    /**
     * 验证码
     * @param phone   手机号
     */
    @FormUrlEncoded
    @POST("${Api.SEND_SMS}")
    fun smsCode(
            @Field("mobile") phone: String
    ): Observable<HttpResult<Any>>
    /**
     * 测试
     * @param phone   手机号
     */
    @POST("${Api.FORGET_OR_CHANGE_PASSWORD}")
    fun test(
        @Body requestBody: RequestBody
    ): Observable<HttpResult<Any>>
    /**
     * 验证码校验
     * @param phone   手机号
     */
    @GET("${Api.APP_BASE_URL}${Api.CODECHECK}")
    fun codeCheck(
        @Query("phone") phone: String,
        @Query("code") code: String
    ): Observable<HttpResult<Any>>

}
