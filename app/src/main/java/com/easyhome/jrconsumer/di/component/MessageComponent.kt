package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.MessageModule

import com.jess.arms.di.scope.FragmentScope
import com.easyhome.jrconsumer.mvp.ui.fragment.MessageFragment

@FragmentScope
@Component(modules = arrayOf(MessageModule::class), dependencies = arrayOf(AppComponent::class))
interface MessageComponent {
    fun inject(fragment: MessageFragment)
}
