package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.project.DecorateProcessContract
import com.easyhome.jrconsumer.mvp.model.project.DecorateProcessModel


@Module
//构建DecorateProcessModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class DecorateProcessModule(private val view: DecorateProcessContract.View) {
    @ActivityScope
    @Provides
    fun provideDecorateProcessView(): DecorateProcessContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideDecorateProcessModel(model: DecorateProcessModel): DecorateProcessContract.Model {
        return model
    }
}
