package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.ShareModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.user.ShareActivity

@ActivityScope
@Component(modules = arrayOf(ShareModule::class), dependencies = arrayOf(AppComponent::class))
interface ShareComponent {
    fun inject(activity: ShareActivity)
}
