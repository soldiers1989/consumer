package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.user.MakeComplaintContract
import com.easyhome.jrconsumer.mvp.model.user.MakeComplaintModel


@Module
//构建MakeComplaintModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class MakeComplaintModule(private val view: MakeComplaintContract.View) {
    @ActivityScope
    @Provides
    fun provideMakeComplaintView(): MakeComplaintContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideMakeComplaintModel(model: MakeComplaintModel): MakeComplaintContract.Model {
        return model
    }
}
