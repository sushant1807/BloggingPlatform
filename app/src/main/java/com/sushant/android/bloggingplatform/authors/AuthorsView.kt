package com.sushant.android.bloggingplatform.authors

import com.sushant.android.data.model.Author

interface AuthorsView {
  fun initialiseView()
  fun showAuthorList(authors: List<Author>)
}
