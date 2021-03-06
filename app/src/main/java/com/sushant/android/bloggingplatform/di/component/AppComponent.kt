package com.sushant.android.bloggingplatform.di.component

import android.content.Context
import com.sushant.android.bloggingplatform.di.module.AppModule
import com.sushant.android.bloggingplatform.di.module.IOModule
import com.sushant.android.bloggingplatform.di.module.RepositoryModule
import com.sushant.android.bloggingplatform.di.module.UseCaseModule
import com.sushant.android.data.data.Endpoint
import com.sushant.android.domain.authors.GetAuthorsListUseCase
import dagger.Component
import com.sushant.android.bloggingplatform.App
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, IOModule::class, RepositoryModule::class, UseCaseModule::class])
interface AppComponent {
  fun inject(app: App)
  fun getApplicationContext(): Context
  fun getEndpoint(): Endpoint

  fun getArticlesListUseCase(): GetAuthorsListUseCase
}
