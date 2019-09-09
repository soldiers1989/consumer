package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.CoupleBackModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.user.CoupleBackActivity

@ActivityScope
@Component(modules = arrayOf(CoupleBackModule::class), dependencies = arrayOf(AppComponent::class))
interface CoupleBackComponent {
    fun inject(activity: CoupleBackActivity)
}
