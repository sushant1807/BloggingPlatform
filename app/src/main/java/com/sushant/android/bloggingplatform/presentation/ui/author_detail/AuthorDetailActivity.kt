package com.sushant.android.bloggingplatform.presentation.ui.author_detail

import android.widget.Toast
import com.sushant.android.bloggingplatform.App
import com.sushant.android.bloggingplatform.R
import com.sushant.android.bloggingplatform.presentation.component.DaggerAuthorDetailComponent
import com.sushant.android.data.authors.model.Post
import com.sushant.android.mvp.CleanActivity
import kotlinx.android.synthetic.main.activity_authors.*

class AuthorDetailActivity : CleanActivity<AuthorsDetailPresenter>(), AuthorsDetailView, OnItemClickListner {

    override fun getLayout(): Int = R.layout.activity_authors
    override fun initInjector() {
        DaggerAuthorDetailComponent.builder()
            .appComponent((application as App).applicationComponent)
            .build()
            .inject(this)
    }

    override fun initialiseView() {
        authors_list_recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this@AuthorDetailActivity)
        }
    }

    override fun showPostList(authors: List<Post>) {
        authors_list_recycler_view.adapter = AuthorsListAdapter(this, authors, this)
    }

    override fun onItemClick(item: Post, position: Int) {
        val message = item.title
        Toast.makeText(this, "Clicked on : $message" , Toast.LENGTH_LONG).show()
    }

}