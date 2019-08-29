package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.recommend.ClassicCaseContract
import com.easyhome.jrconsumer.mvp.model.recommend.ClassicCaseModel


@Module
//构建ClassicCaseModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class ClassicCaseModule(private val view: ClassicCaseContract.View) {
    @ActivityScope
    @Provides
    fun provideClassicCaseView(): ClassicCaseContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideClassicCaseModel(model: ClassicCaseModel): ClassicCaseContract.Model {
        return model
    }
}
