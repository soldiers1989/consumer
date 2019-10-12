package com.easyhome.jrconsumer.mvp.model.project

import android.app.Application
import com.easyhome.jrconsumer.api.service.JRService
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

import com.easyhome.jrconsumer.mvp.contract.project.ProjectDynamicContract
import com.easyhome.jrconsumer.mvp.model.entity.HttpResult
import com.easyhome.jrconsumer.mvp.model.javabean.ClassicCase
import com.easyhome.jrconsumer.mvp.model.javabean.Dynamic
import com.easyhome.jrconsumer.mvp.model.javabean.Dynamic2
import io.reactivex.Observable
import okhttp3.RequestBody


@ActivityScope
class ProjectDynamicModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), ProjectDynamicContract.Model {
    override fun dynamicComment(requestBody: RequestBody): Observable<HttpResult<List<Dynamic>>> {
        return mRepositoryManager.obtainRetrofitService(JRService::class.java).dynamicComment(requestBody)
    }

    override fun dynamicReply(requestBody: RequestBody): Observable<HttpResult<List<Dynamic>>> {
        return mRepositoryManager.obtainRetrofitService(JRService::class.java).dynamicReply(requestBody)
    }

    override fun dynamicList(): Observable<HttpResult<List<Dynamic2>>> {
        return mRepositoryManager.obtainRetrofitService(JRService::class.java).dynamicList()
    }

    override fun dynamic(requestBody: RequestBody): Observable<HttpResult<List<Dynamic>>> {
        return mRepositoryManager.obtainRetrofitService(JRService::class.java).dynamic(requestBody)
    }

    @Inject
    lateinit var mGson: Gson;
    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
