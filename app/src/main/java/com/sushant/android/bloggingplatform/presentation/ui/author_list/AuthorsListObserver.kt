package com.sushant.android.bloggingplatform.presentation.ui.author_list

import com.sushant.android.data.authors.model.Author
import io.reactivex.observers.DisposableSingleObserver

class AuthorsListObserver(private val presenter: AuthorsPresenter): DisposableSingleObserver<List<Author>>() {
  override fun onSuccess(authors: List<Author>) {
    presenter.showAuthorList(authors)
  }

  override fun onError(e: Throwable) {
    e.printStackTrace()
  }
}
