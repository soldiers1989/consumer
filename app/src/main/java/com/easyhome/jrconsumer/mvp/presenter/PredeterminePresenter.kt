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

import com.easyhome.jrconsumer.mvp.contract.PredetermineContract
import com.easyhome.jrconsumer.mvp.model.entity.LoginInfo
import okhttp3.RequestBody


@ActivityScope
class PredeterminePresenter
@Inject
constructor(model: PredetermineContract.Model, rootView: PredetermineContract.View) :
    BasePresenter<PredetermineContract.Model, PredetermineContract.View>(model, rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler
    @Inject
    lateinit var mApplication: Application
    @Inject
    lateinit var mImageLoader: ImageLoader
    @Inject
    lateinit var mAppManager: AppManager
    fun predetermine(arg: RequestBody, success: (any: Any) -> Unit) {
        mModel.predetermine(arg).compose(RxUtils.applySchedulersToData(mRootView))
            .subscribe(object : ResponseErrorSubscriber<Any>(mErrorHandler) {
                override fun onNext(any: Any) {
                    success(any)
                }
            })
    }

    override fun onDestroy() {
        super.onDestroy();
    }
}
