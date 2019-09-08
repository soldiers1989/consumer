package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.RepairsRuleModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.RepairsRuleActivity

@ActivityScope
@Component(modules = arrayOf(RepairsRuleModule::class), dependencies = arrayOf(AppComponent::class))
interface RepairsRuleComponent {
    fun inject(activity: RepairsRuleActivity)
}
