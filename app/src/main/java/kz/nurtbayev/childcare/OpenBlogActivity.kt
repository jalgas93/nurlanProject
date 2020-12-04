package kz.nurtbayev.childcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.nurtbayev.childcare.adapter.OpenBlogAdapter
import kz.nurtbayev.childcare.database.OpenBlog
import kotlinx.android.synthetic.main.open_blog_recycle_activity.*

class OpenBlogActivity : AppCompatActivity() {
    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private fun setupViewstoHome() {
        go_pr_p.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun GoNotificationFBlog() {
        go_notification_fblog.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun GoHospitalFBlog() {
        go_hospital_fblog.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.open_blog_recycle_activity)
        setupViewstoHome()
        GoNotificationFBlog()


        val blogList = listOf<OpenBlog>(
            OpenBlog(
                R.drawable.blog1,
                R.drawable.favorite,
                "Название",
                "Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста"
            ),

            OpenBlog(
                R.drawable.blog2,
                R.drawable.favorite,
                "Название",
                "Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста"
            ),

            OpenBlog(
                R.drawable.blog3,
                R.drawable.favorite,
                "Название",
                "Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста"
            ),

            OpenBlog(
                R.drawable.blog3,
                R.drawable.favorite,
                "Название",
                "Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста"
            ),

            OpenBlog(
                R.drawable.blog3,
                R.drawable.favorite,
                "Название",
                "Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста"
            ),
            OpenBlog(
                R.drawable.blog3,
                R.drawable.favorite,
                "Название",
                "Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста"
            ),

            OpenBlog(
                R.drawable.blog3,
                R.drawable.favorite,
                "Название",
                "Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста Кусок текста"
            )






        )



        val recyclerView = findViewById<RecyclerView>(R.id._blogRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter =
            OpenBlogAdapter(
                this,
                blogList
            ) {
                val intent = Intent(this, OpenArticleActivity::class.java)
                intent.putExtra(INTENT_PARCELABLE, it)
                startActivity(intent)
            }
    }
}