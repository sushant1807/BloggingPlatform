package com.sushant.android.bloggingplatform.presentation.ui.author_list

import com.sushant.android.data.model.Author

interface AuthorsView {
  fun initialiseView()
  fun showAuthorList(authors: List<Author>)
}