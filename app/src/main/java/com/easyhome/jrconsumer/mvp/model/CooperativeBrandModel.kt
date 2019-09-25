package com.easyhome.jrconsumer.mvp.model

import android.app.Application
import com.easyhome.jrconsumer.api.service.JRService
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

import com.easyhome.jrconsumer.mvp.contract.CooperativeBrandContract
import com.easyhome.jrconsumer.mvp.model.entity.HttpResult
import io.reactivex.Observable
import okhttp3.RequestBody


@ActivityScope
class CooperativeBrandModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), CooperativeBrandContract.Model {
    override fun brand(requestBody: RequestBody): Observable<HttpResult<Any>> {
        return mRepositoryManager.obtainRetrofitService(JRService::class.java).brand(requestBody)
    }

    @Inject
    lateinit var mGson: Gson;
    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
