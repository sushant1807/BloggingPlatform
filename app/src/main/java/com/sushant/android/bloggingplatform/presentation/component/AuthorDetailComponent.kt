package com.sushant.android.bloggingplatform.presentation.component

import com.sushant.android.bloggingplatform.di.component.AppComponent
import com.sushant.android.bloggingplatform.presentation.ui.author_detail.AuthorDetailActivity
import com.sushant.android.mvp.scope.PerActivity
import dagger.Component

@PerActivity
@Component(dependencies = [AppComponent::class])
interface AuthorDetailComponent {
    fun inject(authorDetailActivity: AuthorDetailActivity)
}