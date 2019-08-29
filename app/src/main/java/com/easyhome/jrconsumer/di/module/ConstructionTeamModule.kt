package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.recommend.ConstructionTeamContract
import com.easyhome.jrconsumer.mvp.model.recommend.ConstructionTeamModel


@Module
//构建ConstructionTeamModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class ConstructionTeamModule(private val view: ConstructionTeamContract.View) {
    @ActivityScope
    @Provides
    fun provideConstructionTeamView(): ConstructionTeamContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideConstructionTeamModel(model: ConstructionTeamModel): ConstructionTeamContract.Model {
        return model
    }
}
