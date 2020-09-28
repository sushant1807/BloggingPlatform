package com.sushant.android.domain.authors

import com.sushant.android.data.model.Author
import com.sushant.android.data.repository.AuthorsRepository
import com.sushant.android.domain.UseCase
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

class GetAuthorsListUseCase @Inject constructor(private val authorsRepository: AuthorsRepository,
                                                subscribeScheduler: Scheduler,
                                                postExecutionScheduler: Scheduler) : UseCase<List<Author>, Unit>(subscribeScheduler, postExecutionScheduler) {

  override fun buildUseCaseSingle(params: Unit?): Single<List<Author>> = authorsRepository.authors()
}
