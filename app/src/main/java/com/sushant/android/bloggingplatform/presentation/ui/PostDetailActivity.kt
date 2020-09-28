package com.sushant.android.bloggingplatform.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import com.sushant.android.bloggingplatform.R
import com.sushant.android.data.authors.model.Author
import com.sushant.android.data.authors.model.Post
import kotlinx.android.synthetic.main.activity_post_detail.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class PostDetailActivity : AppCompatActivity() {

    lateinit var receivedPostItem: Post
    lateinit var receivedAuthorItem: Author

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)

        receivedPostItem = (intent.getSerializableExtra("POST") as? Post)!!
        receivedAuthorItem = (intent.getSerializableExtra("AUTHOR") as? Author)!!

        initInstance()
    }

    private fun initInstance() {

        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
        var convertedDate: Date? = null
        var formattedDate: String? = null
        try {
            convertedDate = sdf.parse(receivedPostItem.date)
            formattedDate = SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).format(convertedDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        title_text_view.setText(receivedPostItem.title)
        description_text_view.setText(receivedPostItem.body)
        date_of_creation.setText(formattedDate)
        author_name.setText(receivedAuthorItem.name)

        Picasso.get()
            .load(receivedPostItem.imageUrl)
            .apply {
                fit()
                centerCrop()
                placeholder(R.drawable.ic_launcher_foreground)
                into(itemImgView)
            }

        /*Picasso.get()
            .load(receivedAuthorItem.avatarUrl)
            .apply {
                fit()
                centerCrop()
                placeholder(R.drawable.ic_launcher_foreground)
                into(author_imageView)
            }*/
    }
}
