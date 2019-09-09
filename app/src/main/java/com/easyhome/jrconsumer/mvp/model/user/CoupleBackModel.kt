package com.easyhome.jrconsumer.mvp.model.user

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

import com.easyhome.jrconsumer.mvp.contract.user.CoupleBackContract


@ActivityScope
class CoupleBackModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), CoupleBackContract.Model {
    @Inject
    lateinit var mGson: Gson;
    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
