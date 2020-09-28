package com.sushant.android.bloggingplatform.presentation.ui.author_detail

import com.sushant.android.data.authors.model.Post

interface AuthorsDetailView {
  fun initialiseView()
  fun showPostList(authors: List<Post>)
}
