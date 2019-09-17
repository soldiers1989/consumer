package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.user.AlterPasswordContract
import com.easyhome.jrconsumer.mvp.model.user.AlterPasswordModel


@Module
//构建AlterPasswordModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class AlterPasswordModule(private val view: AlterPasswordContract.View) {
    @ActivityScope
    @Provides
    fun provideAlterPasswordView(): AlterPasswordContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAlterPasswordModel(model: AlterPasswordModel): AlterPasswordContract.Model {
        return model
    }
}
