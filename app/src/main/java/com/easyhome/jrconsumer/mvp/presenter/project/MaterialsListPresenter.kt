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

import com.easyhome.jrconsumer.mvp.contract.project.MaterialsListContract
import com.easyhome.jrconsumer.mvp.model.javabean.ClassicCase
import okhttp3.RequestBody


@ActivityScope
class MaterialsListPresenter
@Inject
constructor(model: MaterialsListContract.Model, rootView: MaterialsListContract.View) :
    BasePresenter<MaterialsListContract.Model, MaterialsListContract.View>(model, rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler
    @Inject
    lateinit var mApplication: Application
    @Inject
    lateinit var mImageLoader: ImageLoader
    @Inject
    lateinit var mAppManager: AppManager

    fun buyForMe(args: RequestBody, success: (any: List<ClassicCase>) -> Unit) {
        mModel.buyForMe(args).compose(RxUtils.applySchedulersToData(mRootView))
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
