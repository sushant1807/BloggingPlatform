package com.sushant.android.bloggingplatform.authors

import com.sushant.android.data.model.Author
import io.reactivex.observers.DisposableSingleObserver

class AuthorsListObserver(private val presenter: AuthorsPresenter): DisposableSingleObserver<List<Author>>() {
  override fun onSuccess(articlesList: List<Author>) {
    presenter.showArticleList(articlesList)
  }

  override fun onError(e: Throwable) {
    e.printStackTrace()
  }
}
