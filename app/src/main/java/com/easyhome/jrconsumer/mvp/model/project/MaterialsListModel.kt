package com.easyhome.jrconsumer.mvp.model.project

import android.app.Application
import com.easyhome.jrconsumer.api.service.JRService
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

import com.easyhome.jrconsumer.mvp.contract.project.MaterialsListContract
import com.easyhome.jrconsumer.mvp.model.entity.HttpResult
import com.easyhome.jrconsumer.mvp.model.javabean.ClassicCase
import io.reactivex.Observable
import okhttp3.RequestBody


@ActivityScope
class MaterialsListModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), MaterialsListContract.Model {
    override fun buyForMe(requestBody: RequestBody): Observable<HttpResult<List<ClassicCase>>> {
       return mRepositoryManager.obtainRetrofitService(JRService::class.java).buyForMe(requestBody)
    }

    @Inject
    lateinit var mGson: Gson;
    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
