package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.user.ConfirmPhoneNumberContract
import com.easyhome.jrconsumer.mvp.model.user.ConfirmPhoneNumberModel


@Module
//构建ConfirmPhoneNumberModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class ConfirmPhoneNumberModule(private val view: ConfirmPhoneNumberContract.View) {
    @ActivityScope
    @Provides
    fun provideConfirmPhoneNumberView(): ConfirmPhoneNumberContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideConfirmPhoneNumberModel(model: ConfirmPhoneNumberModel): ConfirmPhoneNumberContract.Model {
        return model
    }
}
