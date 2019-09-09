package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.MakeComplaintModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.user.MakeComplaintActivity

@ActivityScope
@Component(modules = arrayOf(MakeComplaintModule::class), dependencies = arrayOf(AppComponent::class))
interface MakeComplaintComponent {
    fun inject(activity: MakeComplaintActivity)
}
