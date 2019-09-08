package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.RepairsRuleContract
import com.easyhome.jrconsumer.mvp.model.RepairsRuleModel


@Module
//构建RepairsRuleModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class RepairsRuleModule(private val view: RepairsRuleContract.View) {
    @ActivityScope
    @Provides
    fun provideRepairsRuleView(): RepairsRuleContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideRepairsRuleModel(model: RepairsRuleModel): RepairsRuleContract.Model {
        return model
    }
}
