package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.user.GradeListContract
import com.easyhome.jrconsumer.mvp.model.user.GradeListModel


@Module
//构建GradeListModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class GradeListModule(private val view: GradeListContract.View) {
    @ActivityScope
    @Provides
    fun provideGradeListView(): GradeListContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideGradeListModel(model: GradeListModel): GradeListContract.Model {
        return model
    }
}
