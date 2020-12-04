package kz.nurtbayev.childcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_advice.*

class AdviceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advice)
        OpenArticleEmotion()
        OpenArticlePlay()
        OpenArticleCommunity()
        OpenChildList()
        GoHomeFromAdvice()
        GoNotificationFromAdvice()
        GoHospitalFromAdvice()
    }

    private fun OpenArticleEmotion() {
        go_emotion_article.setOnClickListener {
            val intent = Intent(this, EmotionArticle::class.java)
            startActivity(intent)
        }
    }

    private fun OpenArticlePlay() {
        go_paly_article.setOnClickListener {
            val intent = Intent(this, PlayArticleActivity::class.java)
            startActivity(intent)
        }
    }

    private fun OpenArticleCommunity() {
        go_community_article.setOnClickListener {
            val intent = Intent(this, CommunicationArticleActivity::class.java)
            startActivity(intent)
        }
    }


    private fun OpenChildList() {
        go_pr_page.setOnClickListener {
            val intent = Intent(this, ChildlistActivity::class.java)
            startActivity(intent)
        }
    }

    private fun GoHomeFromAdvice() {
       go_home_fadvice.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun GoNotificationFromAdvice() {
        go_notification_fadvice.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun GoHospitalFromAdvice() {
        go_hospital_fadvice.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun GoBlogsFromAdvice() {
        go_liked_fadvice.setOnClickListener {
            val intent = Intent(this, OpenBlogActivity::class.java)
            startActivity(intent)
        }
    }






}