package com.easyhome.jrconsumer.mvp.presenter.fragment

import android.app.Application
import com.easyhome.jrconsumer.app.ResponseErrorSubscriber
import com.easyhome.jrconsumer.app.utils.RxUtils

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.easyhome.jrconsumer.mvp.contract.fragment.MallContract
import com.easyhome.jrconsumer.mvp.model.entity.LoginInfo
import com.easyhome.jrconsumer.mvp.model.javabean.ProjectListData
import okhttp3.RequestBody


@FragmentScope
class MallPresenter
@Inject
constructor(model: MallContract.Model, rootView: MallContract.View) :
    BasePresenter<MallContract.Model, MallContract.View>(model, rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler
    @Inject
    lateinit var mApplication: Application
    @Inject
    lateinit var mImageLoader: ImageLoader
    @Inject
    lateinit var mAppManager: AppManager

    fun projectList(requestBody: RequestBody,success: (any: List<ProjectListData>) -> Unit) {
        mModel.projectList(requestBody).compose(RxUtils.applySchedulersToData(mRootView))
            .subscribe(object : ResponseErrorSubscriber<List<ProjectListData>>(mErrorHandler) {
                override fun onNext(any: List<ProjectListData>) {
                    success(any)
                }
            })
    }

    override fun onDestroy() {
        super.onDestroy();
    }
}
