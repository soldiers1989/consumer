package com.easyhome.jrconsumer.mvp.model.fragment

import android.app.Application
import com.easyhome.jrconsumer.api.service.JRService
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.FragmentScope
import javax.inject.Inject

import com.easyhome.jrconsumer.mvp.contract.fragment.MallContract
import com.easyhome.jrconsumer.mvp.model.entity.HttpResult
import com.easyhome.jrconsumer.mvp.model.javabean.ProjectListData
import io.reactivex.Observable
import okhttp3.RequestBody


@FragmentScope
class MallModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), MallContract.Model {
    override fun projectList(requestBody: RequestBody): Observable<HttpResult<List<ProjectListData>>> {
      return  mRepositoryManager.obtainRetrofitService(JRService::class.java).projectList(requestBody)
    }

    @Inject
    lateinit var mGson: Gson;
    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
