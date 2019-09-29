package com.easyhome.jrconsumer.mvp.model.recommend

import android.app.Application
import com.easyhome.jrconsumer.api.service.JRService
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

import com.easyhome.jrconsumer.mvp.contract.recommend.DesignerListContract
import com.easyhome.jrconsumer.mvp.model.entity.HttpResult
import com.easyhome.jrconsumer.mvp.model.javabean.ClassicCase
import io.reactivex.Observable
import okhttp3.RequestBody


@ActivityScope
class DesignerListModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), DesignerListContract.Model {
    override fun classicCase(requestBody: RequestBody): Observable<HttpResult<List<ClassicCase>>> {
        return mRepositoryManager.obtainRetrofitService(JRService::class.java).classicCase(requestBody)
    }

    @Inject
    lateinit var mGson: Gson;
    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
