package com.easyhome.jrconsumer.mvp.model

import android.app.Application
import com.easyhome.jrconsumer.api.service.JRService
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

import com.easyhome.jrconsumer.mvp.contract.ProjectInfoContract
import com.easyhome.jrconsumer.mvp.model.entity.HttpResult
import com.easyhome.jrconsumer.mvp.model.javabean.ProjectData
import com.easyhome.jrconsumer.mvp.model.javabean.Server
import io.reactivex.Observable
import okhttp3.RequestBody


@ActivityScope
class ProjectInfoModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), ProjectInfoContract.Model {
    override fun projectDetail(requestBody: RequestBody): Observable<HttpResult<ProjectData>> {
        return mRepositoryManager.obtainRetrofitService(JRService::class.java).projectDetail(requestBody)
    }

    override fun projectDetailContract(requestBody: RequestBody): Observable<HttpResult<ProjectData>> {
        return mRepositoryManager.obtainRetrofitService(JRService::class.java).projectDetailContract(requestBody)
    }

    override fun projectDetailStatus(requestBody: RequestBody): Observable<HttpResult<ProjectData>> {
        return mRepositoryManager.obtainRetrofitService(JRService::class.java).projectDetailStatus(requestBody)
    }

    override fun projectDetailUser(requestBody: RequestBody): Observable<HttpResult<List<Server>>> {
        return mRepositoryManager.obtainRetrofitService(JRService::class.java).projectDetailUser(requestBody)
    }

    @Inject
    lateinit var mGson: Gson;
    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
