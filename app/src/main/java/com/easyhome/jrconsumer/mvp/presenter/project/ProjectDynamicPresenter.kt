package com.easyhome.jrconsumer.mvp.presenter.project

import android.app.Application
import com.easyhome.jrconsumer.app.ResponseErrorSubscriber
import com.easyhome.jrconsumer.app.utils.RxUtils

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.easyhome.jrconsumer.mvp.contract.project.ProjectDynamicContract
import com.easyhome.jrconsumer.mvp.model.javabean.ClassicCase
import com.easyhome.jrconsumer.mvp.model.javabean.Dynamic
import okhttp3.RequestBody


@ActivityScope
class ProjectDynamicPresenter
@Inject
constructor(model: ProjectDynamicContract.Model, rootView: ProjectDynamicContract.View) :
    BasePresenter<ProjectDynamicContract.Model, ProjectDynamicContract.View>(model, rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler
    @Inject
    lateinit var mApplication: Application
    @Inject
    lateinit var mImageLoader: ImageLoader
    @Inject
    lateinit var mAppManager: AppManager

    fun dynamic(args: RequestBody, success: (any: List<Dynamic>) -> Unit) {
        mModel.dynamic(args).compose(RxUtils.applySchedulersToData(mRootView))
            .subscribe(object : ResponseErrorSubscriber<List<Dynamic>>(mErrorHandler) {
                override fun onNext(any: List<Dynamic>) {
                    success(any)
                }
            })
    }
    override fun onDestroy() {
        super.onDestroy();
    }
}
