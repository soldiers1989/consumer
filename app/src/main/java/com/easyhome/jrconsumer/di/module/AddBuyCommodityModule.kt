package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.project.AddBuyCommodityContract
import com.easyhome.jrconsumer.mvp.model.project.AddBuyCommodityModel


@Module
//构建AddBuyCommodityModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class AddBuyCommodityModule(private val view: AddBuyCommodityContract.View) {
    @ActivityScope
    @Provides
    fun provideAddBuyCommodityView(): AddBuyCommodityContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAddBuyCommodityModel(model: AddBuyCommodityModel): AddBuyCommodityContract.Model {
        return model
    }
}
