package com.easyhome.jrconsumer.mvp.presenter.recommend

import android.app.Application
import com.easyhome.jrconsumer.app.ResponseErrorSubscriber
import com.easyhome.jrconsumer.app.utils.RxUtils

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.easyhome.jrconsumer.mvp.contract.recommend.DesignerListContract
import com.easyhome.jrconsumer.mvp.model.javabean.ClassicCase
import okhttp3.RequestBody


@ActivityScope
class DesignerListPresenter
@Inject
constructor(model: DesignerListContract.Model, rootView: DesignerListContract.View) :
    BasePresenter<DesignerListContract.Model, DesignerListContract.View>(model, rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler
    @Inject
    lateinit var mApplication: Application
    @Inject
    lateinit var mImageLoader: ImageLoader
    @Inject
    lateinit var mAppManager: AppManager
    fun classicCase(args: RequestBody, success: (any: List<ClassicCase>) -> Unit) {
        mModel.classicCase(args).compose(RxUtils.applySchedulersToData(mRootView))
            .subscribe(object : ResponseErrorSubscriber<List<ClassicCase>>(mErrorHandler) {
                override fun onNext(any: List<ClassicCase>) {
                    success(any)
                }
            })
    }

    override fun onDestroy() {
        super.onDestroy();
    }
}
