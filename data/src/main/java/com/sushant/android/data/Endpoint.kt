package com.sushant.android.data.data

import com.sushant.android.data.model.Author
import io.reactivex.Single
import retrofit2.http.GET

interface Endpoint {
  @GET("authors")
  fun getAuthorsList(): Single<List<Author>>
}
