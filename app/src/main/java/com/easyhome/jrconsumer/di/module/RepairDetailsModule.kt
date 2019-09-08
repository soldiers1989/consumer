package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.RepairDetailsContract
import com.easyhome.jrconsumer.mvp.model.RepairDetailsModel


@Module
//构建RepairDetailsModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class RepairDetailsModule(private val view: RepairDetailsContract.View) {
    @ActivityScope
    @Provides
    fun provideRepairDetailsView(): RepairDetailsContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideRepairDetailsModel(model: RepairDetailsModel): RepairDetailsContract.Model {
        return model
    }
}
