package com.sushant.android.bloggingplatform.presentation.ui.author_list

import android.content.Intent
import android.widget.Toast
import com.sushant.android.bloggingplatform.R
import com.sushant.android.data.model.Author
import com.sushant.android.mvp.CleanActivity
import com.sushant.android.bloggingplatform.App
import com.sushant.android.bloggingplatform.presentation.component.DaggerAuthorsComponent
import com.sushant.android.bloggingplatform.presentation.ui.author_detail.AuthorDetailActivity
import kotlinx.android.synthetic.main.activity_authors.*

class AuthorsActivity : CleanActivity<AuthorsPresenter>(), AuthorsView, OnItemClickListner {
  override fun getLayout(): Int = R.layout.activity_authors

  override fun initInjector() {
    DaggerAuthorsComponent.builder()
      .appComponent((application as App).applicationComponent)
      .build()
      .inject(this)
  }

  override fun initialiseView() {
    authors_list_recycler_view.apply {
      setHasFixedSize(true)
      layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this@AuthorsActivity)
    }
  }

  override fun showAuthorList(authors: List<Author>) {
    authors_list_recycler_view.adapter = AuthorsListAdapter(this, authors, this)
  }

  override fun onItemClick(item: Author, position: Int) {
    val message = item.name
    Toast.makeText(this, "Clicked on : $message" , Toast.LENGTH_LONG).show()
    val intent = Intent(this, AuthorDetailActivity::class.java)
    startActivity(intent)

  }
}
