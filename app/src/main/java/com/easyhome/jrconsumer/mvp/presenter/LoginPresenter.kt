package com.easyhome.jrconsumer.mvp.presenter

import android.app.Application

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import com.easyhome.jrconsumer.app.ResponseErrorSubscriber
import com.easyhome.jrconsumer.app.extension.getRequestBody
import com.easyhome.jrconsumer.app.utils.RxUtils
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.easyhome.jrconsumer.mvp.contract.LoginContract
import com.easyhome.jrconsumer.mvp.model.entity.LoginArgumentsBean
import com.easyhome.jrconsumer.mvp.model.entity.LoginInfo
import com.easyhome.jrconsumer.mvp.model.entity.TestBean
import com.easyhome.jrconsumer.mvp.model.entity.TestResult
import okhttp3.RequestBody


@ActivityScope
class LoginPresenter
@Inject
constructor(model: LoginContract.Model, rootView: LoginContract.View) :
    BasePresenter<LoginContract.Model, LoginContract.View>(model, rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler
    @Inject
    lateinit var mApplication: Application
    @Inject
    lateinit var mImageLoader: ImageLoader
    @Inject
    lateinit var mAppManager: AppManager

    fun smsCode(mobile: String, genre: String, type: String, success: (any: Any) -> Unit) {
        mModel.smsCode(mobile, genre, type).compose(RxUtils.applySchedulersToData(mRootView))
            .subscribe(object : ResponseErrorSubscriber<Any>(mErrorHandler) {
                override fun onNext(any: Any) {
                    success(any)
                }
            })
    }

    fun test(codes: Map<String, String>, success: (any: Any) -> Unit) {
        mModel.test(codes.getRequestBody()).compose(RxUtils.applySchedulersToData(mRootView))
            .subscribe(object : ResponseErrorSubscriber<Any>(mErrorHandler) {
                override fun onNext(any: Any) {
                    success(any)
                }
            })
    }

    fun login(arg: RequestBody, success: (any: LoginInfo) -> Unit) {
        mModel.login(arg).compose(RxUtils.applySchedulersToData(mRootView))
            .subscribe(object : ResponseErrorSubscriber<LoginInfo>(mErrorHandler) {
                override fun onNext(any: LoginInfo) {
                    success(any)
                }
            })
    }


    override fun onDestroy() {
        super.onDestroy();
    }
}
