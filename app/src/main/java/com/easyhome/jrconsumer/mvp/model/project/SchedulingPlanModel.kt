package com.easyhome.jrconsumer.mvp.model.project

import android.app.Application
import com.easyhome.jrconsumer.api.service.JRService
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

import com.easyhome.jrconsumer.mvp.contract.project.SchedulingPlanContract
import com.easyhome.jrconsumer.mvp.model.entity.HttpResult
import com.easyhome.jrconsumer.mvp.model.javabean.Dynamic2
import io.reactivex.Observable


@ActivityScope
class SchedulingPlanModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), SchedulingPlanContract.Model {
    override fun projectPlan(projectId:String): Observable<HttpResult<List<Dynamic2>>> {
        return mRepositoryManager.obtainRetrofitService(JRService::class.java).projectPlan(projectId)
    }

    @Inject
    lateinit var mGson: Gson;
    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
