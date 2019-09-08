package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.AboutAppModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.user.AboutAppActivity

@ActivityScope
@Component(modules = arrayOf(AboutAppModule::class), dependencies = arrayOf(AppComponent::class))
interface AboutAppComponent {
    fun inject(activity: AboutAppActivity)
}
