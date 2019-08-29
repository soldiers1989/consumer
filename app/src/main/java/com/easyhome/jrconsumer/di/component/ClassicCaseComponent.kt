package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.ClassicCaseModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.recommend.ClassicCaseActivity

@ActivityScope
@Component(modules = arrayOf(ClassicCaseModule::class), dependencies = arrayOf(AppComponent::class))
interface ClassicCaseComponent {
    fun inject(activity: ClassicCaseActivity)
}
