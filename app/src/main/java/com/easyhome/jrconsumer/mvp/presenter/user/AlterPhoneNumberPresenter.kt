package com.easyhome.jrconsumer.mvp.presenter.user

import android.app.Application

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.easyhome.jrconsumer.mvp.contract.user.AlterPhoneNumberContract


@ActivityScope
class AlterPhoneNumberPresenter
@Inject
constructor(model: AlterPhoneNumberContract.Model, rootView: AlterPhoneNumberContract.View) :
    BasePresenter<AlterPhoneNumberContract.Model, AlterPhoneNumberContract.View>(model, rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler
    @Inject
    lateinit var mApplication: Application
    @Inject
    lateinit var mImageLoader: ImageLoader
    @Inject
    lateinit var mAppManager: AppManager


    override fun onDestroy() {
        super.onDestroy();
    }
}
