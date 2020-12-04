package kz.nurtbayev.childcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_communication_article.*


class CommunicationArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_communication_article)
        BackAdvicePagefromCommunity()
        BackLikedfromCommunity()
        BackNotificationfromCommunity()
        BackHomefromCommunity()
    }

    private fun BackAdvicePagefromCommunity() {
        go_pr_p.setOnClickListener {
            val intent = Intent(this, AdviceActivity::class.java)
            startActivity(intent)
        }
    }

    private fun BackHomefromCommunity() {
        go_home_fcommunication.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun BackNotificationfromCommunity() {
        go_notification_fcommunication.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun BackLikedfromCommunity() {
        go_liked_fcommunication.setOnClickListener {
            val intent = Intent(this, OpenBlogActivity::class.java)
            startActivity(intent)
        }
    }


}