package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.ComplaintOrRepairsContract
import com.easyhome.jrconsumer.mvp.model.ComplaintOrRepairsModel


@Module
//构建ComplaintOrRepairsModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class ComplaintOrRepairsModule(private val view: ComplaintOrRepairsContract.View) {
    @ActivityScope
    @Provides
    fun provideComplaintOrRepairsView(): ComplaintOrRepairsContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideComplaintOrRepairsModel(model: ComplaintOrRepairsModel): ComplaintOrRepairsContract.Model {
        return model
    }
}
