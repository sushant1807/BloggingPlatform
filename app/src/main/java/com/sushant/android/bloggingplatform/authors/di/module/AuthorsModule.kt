package com.sushant.android.bloggingplatform.authors.di.module

import com.sushant.android.bloggingplatform.authors.AuthorsPresenter
import dagger.Module
import dagger.Provides
import com.sushant.android.domain.authors.GetAuthorsListUseCase
import com.sushant.android.mvp.scope.PerActivity

@Module
class AuthorsModule {
  @PerActivity
  @Provides
  internal fun provideAuthorsPresenter(getAuthorsListUseCase: GetAuthorsListUseCase) = AuthorsPresenter(getAuthorsListUseCase)
}
