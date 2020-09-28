package com.sushant.android.bloggingplatform.presentation.ui.author_detail

import com.sushant.android.data.authors.model.Post
import io.reactivex.observers.DisposableSingleObserver

class AuthorDetailListObserver(private val detailPresenter: AuthorsDetailPresenter): DisposableSingleObserver<List<Post>>() {
  override fun onSuccess(authors: List<Post>) {
    detailPresenter.showAuthorList(authors)
  }

  override fun onError(e: Throwable) {
    e.printStackTrace()
  }
}
