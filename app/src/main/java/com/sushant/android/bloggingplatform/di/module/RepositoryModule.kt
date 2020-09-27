package com.sushant.android.bloggingplatform.di.module

import com.sushant.android.data.data.Endpoint
import com.sushant.android.data.repository.AuthorsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
  @Provides
  @Singleton
  internal fun provideArticleRepository(endpoint: Endpoint): AuthorsRepository = AuthorsRepository(endpoint)
}