package com.sushant.android.bloggingplatform.authors

import com.sushant.android.bloggingplatform.R
import com.sushant.android.data.model.Author
import com.sushant.android.mvp.CleanActivity
import com.sushant.android.bloggingplatform.App
import com.sushant.android.bloggingplatform.authors.di.component.DaggerAuthorsComponent
import kotlinx.android.synthetic.main.activity_authors.*

class AuthorsActivity : CleanActivity<AuthorsPresenter>(), AuthorsView {
  override fun getLayout(): Int = R.layout.activity_authors

  override fun initInjector() {
    DaggerAuthorsComponent.builder()
      .appComponent((application as App).applicationComponent)
      .build()
      .inject(this)
  }

  override fun initialiseView() {
    articles_list_recycler_view.apply {
      setHasFixedSize(true)
      layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this@AuthorsActivity)
    }
  }

  override fun showArticleList(articles: List<Author>) {
    articles_list_recycler_view.adapter = AuthorsListAdapter(this, articles)
  }
}
