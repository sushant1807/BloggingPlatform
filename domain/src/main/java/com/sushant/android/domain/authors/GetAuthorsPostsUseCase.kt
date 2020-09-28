package com.sushant.android.domain.authors

import com.sushant.android.data.authors.model.Post
import com.sushant.android.data.repository.AuthorsRepository
import com.sushant.android.domain.UseCasePosts
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

class GetAuthorsPostsUseCase @Inject constructor(private val authorsRepository: AuthorsRepository,
                                                 subscribeScheduler: Scheduler,
                                                 postExecutionScheduler: Scheduler
) : UseCasePosts<List<Post>, Unit>(subscribeScheduler, postExecutionScheduler) {
    override fun buildUseCaseSingle(params: Unit?): Single<List<Post>> = authorsRepository.postsByAuthorID(12)
}