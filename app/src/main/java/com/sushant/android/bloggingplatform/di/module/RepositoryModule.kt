package com.sushant.android.bloggingplatform.di.module

import com.sushant.android.data.ApiService
import com.sushant.android.data.repository.AuthorsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
  @Provides
  @Singleton
  internal fun provideAuthorRepository(apiService: ApiService): AuthorsRepository = AuthorsRepository(apiService)
}