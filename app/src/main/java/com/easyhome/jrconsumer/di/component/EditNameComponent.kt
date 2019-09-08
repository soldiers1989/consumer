package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.EditNameModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.user.EditNameActivity

@ActivityScope
@Component(modules = arrayOf(EditNameModule::class), dependencies = arrayOf(AppComponent::class))
interface EditNameComponent {
    fun inject(activity: EditNameActivity)
}
