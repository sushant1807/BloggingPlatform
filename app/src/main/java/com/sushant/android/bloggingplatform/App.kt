package com.sushant.android.bloggingplatform

import android.app.Application
import com.sushant.android.bloggingplatform.di.component.AppComponent
import com.sushant.android.bloggingplatform.di.component.DaggerAppComponent
import com.sushant.android.bloggingplatform.di.module.AppModule

class App : Application() {
  val applicationComponent: AppComponent by lazy {
    DaggerAppComponent.builder()
      .appModule(AppModule(this))
      .build()
  }

  override fun onCreate() {
    super.onCreate()
    initInjector()
  }

  private fun initInjector() {
    applicationComponent.inject(this)
  }
}
