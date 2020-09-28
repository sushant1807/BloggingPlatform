package com.sushant.android.bloggingplatform.di.module

import com.sushant.android.data.repository.AuthorsRepository
import com.sushant.android.domain.authors.GetAuthorsListUseCase
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
class UseCaseModule {
  @Provides
  @Singleton
  @Named("ioScheduler")
  internal fun provideIoScheduler() = Schedulers.io()

  @Provides
  @Singleton
  @Named("mainThreadScheduler")
  internal fun provideMainThreadScheduler() = AndroidSchedulers.mainThread()

  @Provides
  @Singleton
  internal fun provideGetAuthorsListUseCase(authorsRepository: AuthorsRepository,
                                            @Named("ioScheduler") ioScheduler: Scheduler,
                                            @Named("mainThreadScheduler")
                                              mainThreadScheduler: Scheduler):
          GetAuthorsListUseCase = GetAuthorsListUseCase(authorsRepository, ioScheduler, mainThreadScheduler)
}
