package kz.nurtbayev.childcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        setupViewsnotificationtwo()
        setupViewsnotificationthree()
        setupViewsnotificationfour()
        setupViewsnotificationfive()
        GoHomeFNotification()
        GoLikedFNotification()
    }

    private fun setupViewsnotificationtwo() {
        notification_two_button.setOnClickListener {
            val intent = Intent(this, NotificationtwoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupViewsnotificationthree() {
        notification_three_button.setOnClickListener {
            val intent = Intent(this, NotificationtwoActivity::class.java)
            startActivity(intent)
        }
    }


    private fun setupViewsnotificationfour() {
        notification_four_button.setOnClickListener {
            val intent = Intent(this, NotificationtwoActivity::class.java)
            startActivity(intent)
        }
    }


    private fun setupViewsnotificationfive() {
        notification_five_button.setOnClickListener {
            val intent = Intent(this, NotificationtwoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun GoHomeFNotification() {
        go_home_fnotification.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun GoLikedFNotification() {
        go_liked_fnotification.setOnClickListener {
            val intent = Intent(this, OpenBlogActivity::class.java)
            startActivity(intent)
        }
    }



}