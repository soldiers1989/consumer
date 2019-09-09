package com.easyhome.jrconsumer.mvp.model.message

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

import com.easyhome.jrconsumer.mvp.contract.message.MessageCenterContract


@ActivityScope
class MessageCenterModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), MessageCenterContract.Model {
    @Inject
    lateinit var mGson: Gson;
    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
