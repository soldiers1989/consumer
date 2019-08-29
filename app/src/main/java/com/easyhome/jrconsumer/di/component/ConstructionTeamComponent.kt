package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.ConstructionTeamModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.recommend.ConstructionTeamActivity

@ActivityScope
@Component(modules = arrayOf(ConstructionTeamModule::class), dependencies = arrayOf(AppComponent::class))
interface ConstructionTeamComponent {
    fun inject(activity: ConstructionTeamActivity)
}
