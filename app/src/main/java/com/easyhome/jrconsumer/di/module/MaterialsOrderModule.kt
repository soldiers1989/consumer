package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.project.MaterialsOrderContract
import com.easyhome.jrconsumer.mvp.model.project.MaterialsOrderModel


@Module
//构建MaterialsOrderModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class MaterialsOrderModule(private val view: MaterialsOrderContract.View) {
    @ActivityScope
    @Provides
    fun provideMaterialsOrderView(): MaterialsOrderContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideMaterialsOrderModel(model: MaterialsOrderModel): MaterialsOrderContract.Model {
        return model
    }
}
