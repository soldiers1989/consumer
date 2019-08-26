package com.easyhome.jrconsumer.mvp.model

import android.app.Application
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


@ActivityScope
class LoginModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), LoginContract.Model {
    override fun login(username: String, password: String): Observable<HttpResult<LoginInfo>> {
        return mRepositoryManager.obtainRetrofitService(UserInfoService::class.java).login(username,password)
    }

    override fun test(username: String, size: String): Observable<HttpResult<Any>> {
        return mRepositoryManager.obtainRetrofitService(UserInfoService::class.java).test(username,size)
    }
    override fun smsCode(phone: String): Observable<HttpResult<Any>> {
        return mRepositoryManager.obtainRetrofitService(UserInfoService::class.java).smsCode(phone)
    }

    @Inject
    lateinit var mGson: Gson;
    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
