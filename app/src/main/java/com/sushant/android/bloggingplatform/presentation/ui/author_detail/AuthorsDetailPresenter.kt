package com.sushant.android.bloggingplatform.presentation.ui.author_detail

import com.sushant.android.data.authors.model.Post
import com.sushant.android.domain.authors.GetAuthorsPostsUseCase
import com.sushant.android.mvp.CleanPresenter
import javax.inject.Inject

class AuthorsDetailPresenter @Inject constructor(private val getAuthorsPostsUseCase: GetAuthorsPostsUseCase) : CleanPresenter<AuthorsDetailView>() {

  override fun initialise() {
    getView()?.initialiseView()
    getAuthorsPostsUseCase.execute(AuthorDetailListObserver(this))
  }

  override fun disposeSubscriptions() {
    getAuthorsPostsUseCase.dispose()
  }

  fun showAuthorList(posts: List<Post>) {
    getView()?.showPostList(posts)
  }
}
