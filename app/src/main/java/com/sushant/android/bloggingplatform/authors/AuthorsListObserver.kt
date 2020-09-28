package com.sushant.android.bloggingplatform.authors

import com.sushant.android.data.model.Author
import io.reactivex.observers.DisposableSingleObserver

class AuthorsListObserver(private val presenter: AuthorsPresenter): DisposableSingleObserver<List<Author>>() {
  override fun onSuccess(authors: List<Author>) {
    presenter.showAuthorList(authors)
  }

  override fun onError(e: Throwable) {
    e.printStackTrace()
  }
}
