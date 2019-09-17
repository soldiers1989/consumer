package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.project.ProjectDynamicContract
import com.easyhome.jrconsumer.mvp.model.project.ProjectDynamicModel


@Module
//构建ProjectDynamicModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class ProjectDynamicModule(private val view: ProjectDynamicContract.View) {
    @ActivityScope
    @Provides
    fun provideProjectDynamicView(): ProjectDynamicContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideProjectDynamicModel(model: ProjectDynamicModel): ProjectDynamicContract.Model {
        return model
    }
}
