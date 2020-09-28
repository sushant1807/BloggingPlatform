package com.sushant.android.bloggingplatform.presentation.ui.author_detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.sushant.android.bloggingplatform.R
import com.sushant.android.data.authors.model.Post
import com.sushant.android.data.model.Author
import kotlinx.android.synthetic.main.list_item_author.view.*


class AuthorsListAdapter(private val context: Context, private val posts: List<Post>, var clickListner: OnItemClickListner) :
  androidx.recyclerview.widget.RecyclerView.Adapter<AuthorsListAdapter.ViewHolder>() {

  class ViewHolder(val view: View ) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view)

  override fun onCreateViewHolder(parent: ViewGroup,
                                  viewType: Int): ViewHolder {
    val relativeLayout = LayoutInflater.from(context)
      .inflate(R.layout.list_item_author, parent, false)
    return ViewHolder(relativeLayout)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.view.user_name_text.setText(posts[position].title)
    holder.view.email_text.setText(posts[position].date)

    Picasso.get()
            .load(posts[position].imageUrl)
            .apply {
              fit()
              centerCrop()
              placeholder(R.drawable.ic_launcher_foreground)
              into(holder.view.image_avatar)
            }

    holder.view.setOnClickListener {
      clickListner.onItemClick(posts[position], position)

    }
  }

  override fun getItemCount() = posts.size

}

interface OnItemClickListner{
  fun onItemClick(item: Post, position: Int)
}
