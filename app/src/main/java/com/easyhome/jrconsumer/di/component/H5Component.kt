package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.H5Module

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.H5Activity

@ActivityScope
@Component(modules = arrayOf(H5Module::class), dependencies = arrayOf(AppComponent::class))
interface H5Component {
    fun inject(activity: H5Activity)
}
