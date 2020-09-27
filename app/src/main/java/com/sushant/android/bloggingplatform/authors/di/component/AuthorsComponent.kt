package com.sushant.android.bloggingplatform.authors.di.component

import com.sushant.android.bloggingplatform.authors.AuthorsActivity
import com.sushant.android.bloggingplatform.authors.di.module.AuthorsModule
import com.sushant.android.bloggingplatform.di.component.AppComponent
import com.sushant.android.mvp.scope.PerActivity
import dagger.Component

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [AuthorsModule::class])
interface AuthorsComponent {
  fun inject(authorsActivity: AuthorsActivity)
}