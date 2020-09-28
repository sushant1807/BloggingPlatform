package com.sushant.android.bloggingplatform.presentation.module

import com.sushant.android.bloggingplatform.presentation.ui.author_list.AuthorsPresenter
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
