package com.easyhome.jrconsumer.mvp.model

import android.app.Application
import com.easyhome.jrconsumer.api.service.JRService
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.api.service.UserInfoService
import javax.inject.Inject

import com.easyhome.jrconsumer.mvp.contract.LoginContract
import com.easyhome.jrconsumer.mvp.model.entity.HttpResult
import com.easyhome.jrconsumer.mvp.model.entity.LoginInfo
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Field


@ActivityScope
class LoginModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), LoginContract.Model {
    override fun login(requestBody: RequestBody): Observable<HttpResult<LoginInfo>> {
        return mRepositoryManager.obtainRetrofitService(JRService::class.java).login(requestBody)
    }

    override fun test(requestBody: RequestBody): Observable<HttpResult<Any>> {
        return mRepositoryManager.obtainRetrofitService(JRService::class.java).test(requestBody)
    }

    override fun smsCode(mobile: String, genre: String, type: String): Observable<HttpResult<Any>> {
        return mRepositoryManager.obtainRetrofitService(JRService::class.java).smsCode(mobile, genre, type)
    }

    @Inject
    lateinit var mGson: Gson;
    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
