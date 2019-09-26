package com.easyhome.jrconsumer.mvp.presenter

import android.app.Application
import com.easyhome.jrconsumer.app.ResponseErrorSubscriber
import com.easyhome.jrconsumer.app.extension.getRequestBody
import com.easyhome.jrconsumer.app.utils.RxUtils

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.easyhome.jrconsumer.mvp.contract.ConfirmContract


@ActivityScope
class ConfirmPresenter
@Inject
constructor(model: ConfirmContract.Model, rootView: ConfirmContract.View) :
    BasePresenter<ConfirmContract.Model, ConfirmContract.View>(model, rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler
    @Inject
    lateinit var mApplication: Application
    @Inject
    lateinit var mImageLoader: ImageLoader
    @Inject
    lateinit var mAppManager: AppManager

    fun alter(map: Map<String, String>, success: (any: Boolean) -> Unit) {
        mModel.alter(map.getRequestBody()).compose(RxUtils.applySchedulersToData(mRootView))
            .subscribe(object : ResponseErrorSubscriber<Boolean>(mErrorHandler) {
                override fun onNext(any: Boolean) {
                    success(any)
                }
            })
    }
    override fun onDestroy() {
        super.onDestroy();
    }
}
