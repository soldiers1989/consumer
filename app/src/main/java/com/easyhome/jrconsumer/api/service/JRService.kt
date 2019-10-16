package com.easyhome.jrconsumer.api.service

import com.easyhome.jrconsumer.api.Api
import com.easyhome.jrconsumer.mvp.model.entity.HttpResult
import com.easyhome.jrconsumer.mvp.model.entity.LoginInfo
import com.easyhome.jrconsumer.mvp.model.javabean.*
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
    fun test(@Body requestBody: RequestBody): Observable<HttpResult<Any>>

    //精品案例
    @POST("${Api.STRATEGY_PATTERN}")
    fun classicCase(@Body requestBody: RequestBody): Observable<HttpResult<List<ClassicCase>>>

    //代购/内购材料
    @POST("${Api.STRATEGY_PATTERN}")
    fun buyForMe(@Body requestBody: RequestBody): Observable<HttpResult<List<ClassicCase>>>

    //动态
    @POST("${Api.STRATEGY_PATTERN}")
    fun dynamic(@Body requestBody: RequestBody): Observable<HttpResult<List<Dynamic>>>

    //施工动态动态
    @GET("${Api.DYNAMIC_LIST}")
    fun dynamicList(): Observable<HttpResult<List<Dynamic2>>>

    //施工计划
    @GET("${Api.PROJECT_PLAN}")
    fun projectPlan(@Query("projectId") projectId: String): Observable<HttpResult<List<Dynamic2>>>

    //项目动态--回复
    @POST("${Api.DYNAMIC_REPLY}")
    fun dynamicReply(@Body requestBody: RequestBody): Observable<HttpResult<List<Dynamic>>>
    //项目动态--评论
    @POST("${Api.DYNAMIC_COMMENT}")
    fun dynamicComment(@Body requestBody: RequestBody): Observable<HttpResult<List<Dynamic>>>

    /**
     * 预约设计师
     */
    @POST("${Api.STRATEGY_PATTERN}")
    fun predetermine(@Body requestBody: RequestBody): Observable<HttpResult<Any>>
    /**
     * 项目列表
     */
    @POST("${Api.PROJECT_LIST}")
    fun projectList(@Body requestBody: RequestBody): Observable<HttpResult<List<ProjectListData>>>
    /**
     * 项目详情-1
     */
    @POST("${Api.PROJECT_DETAIL}")
    fun projectDetail(@Body requestBody: RequestBody): Observable<HttpResult<ProjectData>>

    /**
     * 项目详情-2
     */
    @POST("${Api.PROJECT_DETAIL_CONTRACT}")
    fun projectDetailContract(@Body requestBody: RequestBody): Observable<HttpResult<ProjectData>>

    /**
     * 项目详情-3
     */
    @POST("${Api.PROJECT_DETAIL_STATUS}")
    fun projectDetailStatus(@Body requestBody: RequestBody): Observable<HttpResult<ProjectData>>

    /**
     * 项目详情-4
     */
    @POST("${Api.PROJECT_DETAIL_USER}")
    fun projectDetailUser(@Body requestBody: RequestBody): Observable<HttpResult<List<Server>>>
}
