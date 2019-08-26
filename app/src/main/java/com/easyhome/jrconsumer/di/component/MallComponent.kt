package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.MallModule

import com.jess.arms.di.scope.FragmentScope
import com.easyhome.jrconsumer.mvp.ui.fragment.MallFragment

@FragmentScope
@Component(modules = arrayOf(MallModule::class), dependencies = arrayOf(AppComponent::class))
interface MallComponent {
    fun inject(fragment: MallFragment)
}
