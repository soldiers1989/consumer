package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.GradeContract
import com.easyhome.jrconsumer.mvp.model.GradeModel


@Module
//构建GradeModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class GradeModule(private val view: GradeContract.View) {
    @ActivityScope
    @Provides
    fun provideGradeView(): GradeContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideGradeModel(model: GradeModel): GradeContract.Model {
        return model
    }
}
