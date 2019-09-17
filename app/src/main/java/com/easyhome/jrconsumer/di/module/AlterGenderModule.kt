package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.user.AlterGenderContract
import com.easyhome.jrconsumer.mvp.model.user.AlterGenderModel


@Module
//构建AlterGenderModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class AlterGenderModule(private val view: AlterGenderContract.View) {
    @ActivityScope
    @Provides
    fun provideAlterGenderView(): AlterGenderContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAlterGenderModel(model: AlterGenderModel): AlterGenderContract.Model {
        return model
    }
}
