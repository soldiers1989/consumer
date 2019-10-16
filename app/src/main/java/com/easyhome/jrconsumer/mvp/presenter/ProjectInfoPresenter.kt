package com.easyhome.jrconsumer.mvp.presenter

import android.app.Application
import com.easyhome.jrconsumer.app.ResponseErrorSubscriber
import com.easyhome.jrconsumer.app.utils.RxUtils

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.easyhome.jrconsumer.mvp.contract.ProjectInfoContract
import com.easyhome.jrconsumer.mvp.model.entity.LoginInfo
import com.easyhome.jrconsumer.mvp.model.javabean.ProjectData
import com.easyhome.jrconsumer.mvp.model.javabean.Server
import okhttp3.RequestBody


@ActivityScope
class ProjectInfoPresenter
@Inject
constructor(model: ProjectInfoContract.Model, rootView: ProjectInfoContract.View) :
    BasePresenter<ProjectInfoContract.Model, ProjectInfoContract.View>(model, rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler
    @Inject
    lateinit var mApplication: Application
    @Inject
    lateinit var mImageLoader: ImageLoader
    @Inject
    lateinit var mAppManager: AppManager

    fun projectDetail(arg: RequestBody, success: (any: ProjectData) -> Unit) {
        mModel.projectDetail(arg).compose(RxUtils.applySchedulersToData(mRootView))
            .subscribe(object : ResponseErrorSubscriber<ProjectData>(mErrorHandler) {
                override fun onNext(any: ProjectData) {
                    success(any)
                }
            })
    }

    fun projectDetailContract(arg: RequestBody, success: (any: ProjectData) -> Unit) {
        mModel.projectDetailContract(arg).compose(RxUtils.applySchedulersToData(mRootView))
            .subscribe(object : ResponseErrorSubscriber<ProjectData>(mErrorHandler) {
                override fun onNext(any: ProjectData) {
                    success(any)
                }
            })
    }

    fun projectDetailStatus(arg: RequestBody, success: (any: ProjectData) -> Unit) {
        mModel.projectDetailStatus(arg).compose(RxUtils.applySchedulersToData(mRootView))
            .subscribe(object : ResponseErrorSubscriber<ProjectData>(mErrorHandler) {
                override fun onNext(any: ProjectData) {
                    success(any)
                }
            })
    }

    fun projectDetailUser(arg: RequestBody, success: (any: List<Server>) -> Unit) {
        mModel.projectDetailUser(arg).compose(RxUtils.applySchedulersToData(mRootView))
            .subscribe(object : ResponseErrorSubscriber<List<Server>>(mErrorHandler) {
                override fun onNext(any: List<Server>) {
                    success(any)
                }
            })
    }

    override fun onDestroy() {
        super.onDestroy();
    }
}
