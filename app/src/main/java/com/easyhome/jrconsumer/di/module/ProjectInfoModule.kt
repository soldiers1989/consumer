package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.ProjectInfoContract
import com.easyhome.jrconsumer.mvp.model.ProjectInfoModel


@Module
//构建ProjectInfoModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class ProjectInfoModule(private val view: ProjectInfoContract.View) {
    @ActivityScope
    @Provides
    fun provideProjectInfoView(): ProjectInfoContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideProjectInfoModel(model: ProjectInfoModel): ProjectInfoContract.Model {
        return model
    }
}
