package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.user.AlterPhoneNumberContract
import com.easyhome.jrconsumer.mvp.model.user.AlterPhoneNumberModel


@Module
//构建AlterPhoneNumberModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class AlterPhoneNumberModule(private val view: AlterPhoneNumberContract.View) {
    @ActivityScope
    @Provides
    fun provideAlterPhoneNumberView(): AlterPhoneNumberContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAlterPhoneNumberModel(model: AlterPhoneNumberModel): AlterPhoneNumberContract.Model {
        return model
    }
}
