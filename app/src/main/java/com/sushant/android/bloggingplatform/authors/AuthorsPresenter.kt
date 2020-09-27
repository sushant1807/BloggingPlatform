package com.sushant.android.bloggingplatform.authors

import com.sushant.android.data.model.Author
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

  fun showArticleList(articlesList: List<Author>) {
    getView()?.showArticleList(articlesList)
  }
}
