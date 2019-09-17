package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.user.RelatedPersonnelContract
import com.easyhome.jrconsumer.mvp.model.user.RelatedPersonnelModel


@Module
//构建RelatedPersonnelModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class RelatedPersonnelModule(private val view: RelatedPersonnelContract.View) {
    @ActivityScope
    @Provides
    fun provideRelatedPersonnelView(): RelatedPersonnelContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideRelatedPersonnelModel(model: RelatedPersonnelModel): RelatedPersonnelContract.Model {
        return model
    }
}
