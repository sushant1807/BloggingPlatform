package com.sushant.android.bloggingplatform.presentation.ui.author_list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.sushant.android.bloggingplatform.R
import com.sushant.android.data.authors.model.Author
import kotlinx.android.synthetic.main.list_item_author.view.*
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class AuthorsListAdapter(
  private val context: Context,
  private val authors: List<Author>,
  var clickListner: OnItemClickListner
) :
  androidx.recyclerview.widget.RecyclerView.Adapter<AuthorsListAdapter.ViewHolder>() {

  class ViewHolder(val view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view)

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): ViewHolder {
    val relativeLayout = LayoutInflater.from(context)
      .inflate(R.layout.list_item_author, parent, false)
    return ViewHolder(relativeLayout)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    val datewithoutTZ: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
    holder.view.user_name_text.setText(authors[position].name)
    holder.view.email_text.setText(authors[position].email)

    Picasso.get()
            .load(authors[position].avatarUrl)
            .apply {
              fit()
              centerCrop()
              placeholder(R.drawable.ic_launcher_foreground)
              into(holder.view.image_avatar)
            }

    holder.view.setOnClickListener {
      clickListner.onItemClick(authors[position], position)

    }
  }

  fun convertISOTimeToDate(isoTime: String): String? {
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
    var convertedDate: Date? = null
    var formattedDate: String? = null
    try {
      convertedDate = sdf.parse(isoTime)
      formattedDate = SimpleDateFormat("dd-MM-yyyy" + "\n" + " hh:mm:ss a", Locale.ENGLISH).format(convertedDate)
    } catch (e: ParseException) {
      e.printStackTrace()
    }

    return formattedDate
  }

  override fun getItemCount() = authors.size

}

interface OnItemClickListner{
  fun onItemClick(item: Author, position: Int)
}
