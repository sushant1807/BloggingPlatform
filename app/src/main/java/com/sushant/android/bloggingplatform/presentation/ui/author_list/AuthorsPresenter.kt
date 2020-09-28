package com.sushant.android.bloggingplatform.presentation.ui.author_list

import com.sushant.android.data.authors.model.Author
import com.sushant.android.domain.authors.GetAuthorsListUseCase
import com.sushant.android.mvp.CleanPresenter
import javax.inject.Inject

class AuthorsPresenter @Inject constructor(private val getAuthorsListUseCase: GetAuthorsListUseCase) : CleanPresenter<AuthorsView>() {

  override fun initialise() {
    getView()?.initialiseView()
    getAuthorsListUseCase.execute(AuthorsListObserver(this))
  }

  override fun disposeSubscriptions() {
    getAuthorsListUseCase.dispose()
  }

  fun showAuthorList(authorsList: List<Author>) {
    getView()?.showAuthorList(authorsList)
  }
}
