package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.recommend.DesignerListContract
import com.easyhome.jrconsumer.mvp.model.recommend.DesignerListModel


@Module
//构建DesignerListModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class DesignerListModule(private val view: DesignerListContract.View) {
    @ActivityScope
    @Provides
    fun provideDesignerListView(): DesignerListContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideDesignerListModel(model: DesignerListModel): DesignerListContract.Model {
        return model
    }
}
