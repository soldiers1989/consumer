package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.user.EditNameContract
import com.easyhome.jrconsumer.mvp.model.user.EditNameModel


@Module
//构建EditNameModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class EditNameModule(private val view: EditNameContract.View) {
    @ActivityScope
    @Provides
    fun provideEditNameView(): EditNameContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideEditNameModel(model: EditNameModel): EditNameContract.Model {
        return model
    }
}
