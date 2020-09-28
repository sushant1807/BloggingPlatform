package com.sushant.android.data.repository

import com.sushant.android.data.data.Endpoint
import com.sushant.android.data.model.Author
import io.reactivex.Single
import javax.inject.Inject

class AuthorsRepository @Inject constructor(private val endpoint: Endpoint) {
  fun authors(): Single<List<Author>> = endpoint.getAuthorsList()
}