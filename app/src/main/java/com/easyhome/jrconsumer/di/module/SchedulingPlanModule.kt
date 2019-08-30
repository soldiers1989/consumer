package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.project.SchedulingPlanContract
import com.easyhome.jrconsumer.mvp.model.project.SchedulingPlanModel


@Module
//构建SchedulingPlanModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class SchedulingPlanModule(private val view: SchedulingPlanContract.View) {
    @ActivityScope
    @Provides
    fun provideSchedulingPlanView(): SchedulingPlanContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideSchedulingPlanModel(model: SchedulingPlanModel): SchedulingPlanContract.Model {
        return model
    }
}
