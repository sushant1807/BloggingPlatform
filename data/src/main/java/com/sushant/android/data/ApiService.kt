package com.sushant.android.data

import com.sushant.android.data.authors.model.Post
import com.sushant.android.data.model.Author
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
  @GET("authors")
  fun getAuthorsList(): Single<List<Author>>

  @GET("posts")
  fun getPostsByAuthorID(
    @Query("authorId") page: Int = 1
  ) : Single<List<Post>>


}
