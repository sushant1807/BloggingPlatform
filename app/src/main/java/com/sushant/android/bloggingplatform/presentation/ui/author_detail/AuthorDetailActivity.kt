package com.sushant.android.bloggingplatform.presentation.ui.author_detail

import android.content.Intent
import com.sushant.android.bloggingplatform.App
import com.sushant.android.bloggingplatform.R
import com.sushant.android.bloggingplatform.presentation.component.DaggerAuthorDetailComponent
import com.sushant.android.bloggingplatform.presentation.ui.PostDetailActivity
import com.sushant.android.data.authors.model.Author
import com.sushant.android.data.authors.model.Post
import com.sushant.android.mvp.CleanActivity
import kotlinx.android.synthetic.main.activity_authors.*

class AuthorDetailActivity : CleanActivity<AuthorsDetailPresenter>(), AuthorsDetailView, OnItemClickListner {

    lateinit var receivedItem: Author

    override fun getLayout(): Int = R.layout.activity_authors

    override fun initInjector() {
        receivedItem = (intent.getSerializableExtra("AUTHOR") as? Author)!!
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
        val intent = Intent(this, PostDetailActivity::class.java)
        intent.putExtra("POST", item)
        intent.putExtra("AUTHOR", receivedItem)
        startActivity(intent)
    }

}