package com.sushant.android.data.repository

import com.sushant.android.data.authors.model.Post
import com.sushant.android.data.ApiService
import com.sushant.android.data.authors.model.Author
import io.reactivex.Single
import javax.inject.Inject

class AuthorsRepository @Inject constructor(private val apiService: ApiService) {
  fun authors(): Single<List<Author>> = apiService.getAuthorsList()

  fun postsByAuthorID(authorID : Int) : Single<List<Post>> = apiService.getPostsByAuthorID(authorID)
}