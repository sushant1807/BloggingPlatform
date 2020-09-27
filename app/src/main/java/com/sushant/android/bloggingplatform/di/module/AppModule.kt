package com.sushant.android.bloggingplatform.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {
  @Provides
  @Singleton
  internal fun provideAppContext(): Context = app
}
