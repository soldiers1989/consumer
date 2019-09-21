package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.OuterMaterialsContract
import com.easyhome.jrconsumer.mvp.model.OuterMaterialsModel


@Module
//构建OuterMaterialsModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class OuterMaterialsModule(private val view: OuterMaterialsContract.View) {
    @ActivityScope
    @Provides
    fun provideOuterMaterialsView(): OuterMaterialsContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideOuterMaterialsModel(model: OuterMaterialsModel): OuterMaterialsContract.Model {
        return model
    }
}
