package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.AlterGenderModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.user.AlterGenderActivity

@ActivityScope
@Component(modules = arrayOf(AlterGenderModule::class), dependencies = arrayOf(AppComponent::class))
interface AlterGenderComponent {
    fun inject(activity: AlterGenderActivity)
}
