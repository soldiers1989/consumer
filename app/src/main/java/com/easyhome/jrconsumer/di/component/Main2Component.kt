package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.Main2Module

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.MainActivity

@ActivityScope
@Component(modules = arrayOf(Main2Module::class), dependencies = arrayOf(AppComponent::class))
interface Main2Component {
    fun inject(activity: MainActivity)
}
