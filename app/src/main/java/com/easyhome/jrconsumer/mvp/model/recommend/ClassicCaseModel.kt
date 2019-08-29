package com.easyhome.jrconsumer.mvp.model.recommend

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

import com.easyhome.jrconsumer.mvp.contract.recommend.ClassicCaseContract


@ActivityScope
class ClassicCaseModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), ClassicCaseContract.Model {
    @Inject
    lateinit var mGson: Gson;
    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
