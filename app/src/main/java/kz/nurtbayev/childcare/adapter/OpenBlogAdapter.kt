package kz.nurtbayev.childcare.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.nurtbayev.childcare.database.OpenBlog
import kz.nurtbayev.childcare.R

class OpenBlogAdapter(
    private val context: Context,
    private val blogs: List<OpenBlog>,
    val listenerblog: (OpenBlog) -> Unit
) : RecyclerView.Adapter<OpenBlogAdapter.BlogViewHolder>() {
    class BlogViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val blogSrc = view.findViewById<ImageView>(R.id.open_blog_image)
        val blogTitle = view.findViewById<TextView>(R.id.open_blog_title)
        val blogLike = view.findViewById<ImageView>(R.id.open_blog_like)
        val blogDescription = view.findViewById<TextView>(R.id.open_blog_description)

        fun bindView(blog: OpenBlog, listener: (OpenBlog) -> Unit) {
            blogSrc.setImageResource(blog.open_blogSrc)
            blogTitle.text = blog.open_blogTitle
            blogLike.setImageResource(blog.open_blogLike)
            blogDescription.text = blog.open_blogDesc
            itemView.setOnClickListener { listener(blog) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder =
        BlogViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.activity_open_blog,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = blogs.size

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        holder.bindView(blogs[position], listenerblog)
    }
}