package com.easyhome.jrconsumer.mvp.model.recommend

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

import com.easyhome.jrconsumer.mvp.contract.recommend.DesignerListContract


@ActivityScope
class DesignerListModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), DesignerListContract.Model {
    @Inject
    lateinit var mGson: Gson;
    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
