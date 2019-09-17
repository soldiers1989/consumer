package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.RelatedPersonnelModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.user.RelatedPersonnelActivity

@ActivityScope
@Component(modules = arrayOf(RelatedPersonnelModule::class), dependencies = arrayOf(AppComponent::class))
interface RelatedPersonnelComponent {
    fun inject(activity: RelatedPersonnelActivity)
}
