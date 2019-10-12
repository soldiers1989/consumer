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

import com.easyhome.jrconsumer.mvp.contract.project.SchedulingPlanContract
import com.easyhome.jrconsumer.mvp.model.javabean.Dynamic2
import okhttp3.RequestBody


@ActivityScope
class SchedulingPlanPresenter
@Inject
constructor(model: SchedulingPlanContract.Model, rootView: SchedulingPlanContract.View) :
    BasePresenter<SchedulingPlanContract.Model, SchedulingPlanContract.View>(model, rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler
    @Inject
    lateinit var mApplication: Application
    @Inject
    lateinit var mImageLoader: ImageLoader
    @Inject
    lateinit var mAppManager: AppManager

    fun projectPlan(projectId: String, success: (any: List<Dynamic2>) -> Unit) {
        mModel.projectPlan(projectId).compose(RxUtils.applySchedulersToData(mRootView))
            .subscribe(object : ResponseErrorSubscriber<List<Dynamic2>>(mErrorHandler) {
                override fun onNext(any: List<Dynamic2>) {
                    success(any)
                }
            })
    }

    override fun onDestroy() {
        super.onDestroy();
    }
}
