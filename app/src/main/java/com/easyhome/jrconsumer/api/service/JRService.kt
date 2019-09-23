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
    @POST("${Api.LOGIN_TEST}")
    fun login(@Body requestBody: RequestBody): Observable<HttpResult<LoginInfo>>
    /**
     * 修改密码
     */
    @POST("${Api.LOGIN_TEST}")
    fun alter(@Body requestBody: RequestBody): Observable<HttpResult<LoginInfo>>


    /**
     * 登出接口
     * @param userId   用户id
     */
    @FormUrlEncoded
    @POST("${Api.APP_BASE_URL}${Api.LOGOUT}")
    fun loginOut(
            @Field("userId") userId: String
    ): Observable<HttpResult<Any>>
    /**
     * 验证码
     * @param phone   手机号
     */
    @FormUrlEncoded
    @POST("${Api.APP_BASE_URL}${Api.SMSCODE}")
    fun smsCode(
            @Field("phone") phone: String
    ): Observable<HttpResult<Any>>
    /**
     * 测试
     * @param phone   手机号
     */
    @POST("${Api.LOGIN_TEST}")
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
